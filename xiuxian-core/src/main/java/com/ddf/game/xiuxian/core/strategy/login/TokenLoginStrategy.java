package com.ddf.game.xiuxian.core.strategy.login;

import com.ddf.boot.common.authentication.model.AuthenticateCheckResult;
import com.ddf.boot.common.authentication.model.UserClaim;
import com.ddf.boot.common.authentication.util.TokenUtil;
import com.ddf.boot.common.authentication.util.UserContextUtil;
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
 * <p>使用token登录， 校验token， 续token</p >
 *
 * @author Snowball
 * @version 1.0
 * @date 2022/12/17 11:54
 */
@Service
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
@Slf4j
public class TokenLoginStrategy implements LoginStrategy {

    private final PlayerRepository playerRepository;

    @Override
    public LoginTypeEnum getLoginType() {
        return LoginTypeEnum.TOKEN;
    }

    @Override
    public PlayerInfo login(LoginRequest loginRequest) {
        Long currentPlayerId = UserContextUtil.getLongUserId();
        final String token = loginRequest.getCredential();
        // 校验并且解析token
        final AuthenticateCheckResult checkResult = TokenUtil.checkToken(token);
        final UserClaim userClaim = checkResult.getUserClaim();
        PreconditionUtil.checkArgument( Objects.equals(currentPlayerId.toString(), userClaim.getUserId()),
                XiuXianExceptionCode.IDENTITY_MISMATCH);
        // 刷新token
        TokenUtil.refreshToken(currentPlayerId + "", token);
        return playerRepository.getById(currentPlayerId);
    }
}
