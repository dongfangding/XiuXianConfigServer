package com.ddf.game.xiuxian.core.application.impl;

import com.ddf.boot.common.api.util.DateUtils;
import com.ddf.boot.common.authentication.model.AuthenticateToken;
import com.ddf.boot.common.authentication.model.UserClaim;
import com.ddf.boot.common.authentication.util.TokenUtil;
import com.ddf.boot.common.core.encode.BCryptPasswordEncoder;
import com.ddf.boot.common.core.util.ObjectUtil;
import com.ddf.boot.common.core.util.PreconditionUtil;
import com.ddf.boot.common.core.util.WebUtil;
import com.ddf.game.xiuxian.api.enume.PlayerConfigCodeEnum;
import com.ddf.game.xiuxian.api.enume.PlayerStatusEnum;
import com.ddf.game.xiuxian.api.enume.XiuXianExceptionCode;
import com.ddf.game.xiuxian.api.request.player.LoginRequest;
import com.ddf.game.xiuxian.api.request.player.PlayerConfigSyncRequest;
import com.ddf.game.xiuxian.api.request.player.RegistryRequest;
import com.ddf.game.xiuxian.api.response.player.LoginResponse;
import com.ddf.game.xiuxian.core.application.PlayerApplicationService;
import com.ddf.game.xiuxian.core.entity.PlayerInfo;
import com.ddf.game.xiuxian.core.entity.PlayerMetadataConfig;
import com.ddf.game.xiuxian.core.repository.PlayerConfigRepository;
import com.ddf.game.xiuxian.core.repository.PlayerRepository;
import java.util.Objects;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>玩家业务</p >
 *
 * @author Snowball
 * @version 1.0
 * @date 2022/12/16 14:52
 */
@Service
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
@Slf4j
public class PlayerApplicationServiceImpl implements PlayerApplicationService {

    private final PlayerRepository playerRepository;
    private final PlayerConfigRepository playerConfigRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;


    @Override
    public void registry(RegistryRequest request) {
        final boolean exists = playerRepository.nicknameExists(request.getNickname());
        PreconditionUtil.checkArgument(!exists, XiuXianExceptionCode.ACCOUNT_EXISTS);

        String password = bCryptPasswordEncoder.encode(request.getPassword());
        final PlayerInfo playerInfo = new PlayerInfo();
        playerInfo.setNickname(request.getNickname());
        playerInfo.setPassword(password);
        playerInfo.setRegisterIp(WebUtil.getHost());
        playerInfo.setCtime(DateUtils.currentTimeSeconds());
        playerInfo.setStatus(PlayerStatusEnum.NORMAL.name());
        playerRepository.insertPlayerInfo(playerInfo);
    }

    @Override
    public LoginResponse login(LoginRequest loginRequest) {
        final String nickname = loginRequest.getLoginIdentity();
        final PlayerInfo playerInfo = playerRepository.getByAccountName(nickname);
        PreconditionUtil.checkArgument(Objects.nonNull(playerInfo), XiuXianExceptionCode.ACCOUNT_NOT_EXISTS);

        String password = loginRequest.getCredential();
        final boolean matches = bCryptPasswordEncoder.matches(password, playerInfo.getPassword());
        PreconditionUtil.checkArgument(matches, XiuXianExceptionCode.PASSWORD_ERROR);


        final UserClaim userClaim = new UserClaim();
        userClaim.setUserId(playerInfo.getId().toString());
        userClaim.setUsername(nickname);
        userClaim.setCredit(WebUtil.getUserAgent());

        final PlayerMetadataConfig metadataConfig = playerConfigRepository.getConfig(
                playerInfo.getId(), PlayerConfigCodeEnum.ACCOUNT_METADATA);
        final AuthenticateToken authenticateToken = TokenUtil.createToken(userClaim);
        return LoginResponse.builder()
                .playerId(playerInfo.getId())
                .token(authenticateToken.getToken())
                .accountMetadata(Objects.nonNull(metadataConfig) ? metadataConfig.getConfigValue() : "")
                .build();
    }

    @Override
    public boolean playerConfigSyncRequest(Long playerId, PlayerConfigCodeEnum configCodeEnum,
            PlayerConfigSyncRequest request) {
        final PlayerMetadataConfig config = new PlayerMetadataConfig();
        config.setPlayerId(playerId);
        config.setConfigCode(configCodeEnum.name());
        config.setConfigValue(request.getConfigValue());
        return playerConfigRepository.insertOrUpdate(config);
    }

    @Override
    public String getAccountMetadata(Long playerId) {
        final PlayerMetadataConfig metadataConfig = playerConfigRepository.getConfig(
                playerId, PlayerConfigCodeEnum.ACCOUNT_METADATA);
        return Objects.nonNull(metadataConfig) ? metadataConfig.getConfigValue() : "";
    }
}
