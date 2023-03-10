package com.ddf.game.xiuxian.core.strategy.login;

import com.ddf.boot.common.core.encode.BCryptPasswordEncoder;
import com.ddf.boot.common.core.util.PreconditionUtil;
import com.ddf.game.xiuxian.api.enume.LoginTypeEnum;
import com.ddf.game.xiuxian.api.enume.XiuXianExceptionCode;
import com.ddf.game.xiuxian.api.request.player.LoginRequest;
import com.ddf.game.xiuxian.core.entity.PlayerInfo;
import com.ddf.game.xiuxian.core.repository.PlayerRepository;
import java.util.Objects;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>密码登录</p >
 *
 * @author Snowball
 * @version 1.0
 * @date 2022/12/17 11:51
 */
@Service
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
@Slf4j
public class PasswordLoginStrategy implements LoginStrategy {

    private final PlayerRepository playerRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public LoginTypeEnum getLoginType() {
        return LoginTypeEnum.PASSWORD;
    }

    @Override
    public PlayerInfo login(LoginRequest loginRequest) {
        final String nickname = loginRequest.getLoginIdentity();
        final PlayerInfo playerInfo = playerRepository.getByAccountName(nickname);
        PreconditionUtil.checkArgument(Objects.nonNull(playerInfo), XiuXianExceptionCode.ACCOUNT_NOT_EXISTS);

        String password = loginRequest.getCredential();
        final boolean matches = bCryptPasswordEncoder.matches(password, playerInfo.getPassword());
        PreconditionUtil.checkArgument(matches, XiuXianExceptionCode.PASSWORD_ERROR);
        return playerInfo;
    }
}
