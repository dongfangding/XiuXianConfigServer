package com.ddf.game.xiuxian.core.strategy.login;

import cn.hutool.core.collection.CollUtil;
import com.ddf.boot.common.api.model.common.RequestContext;
import com.ddf.boot.common.api.util.DateUtils;
import com.ddf.boot.common.authentication.model.AuthenticateToken;
import com.ddf.boot.common.authentication.model.UserClaim;
import com.ddf.boot.common.authentication.util.TokenUtil;
import com.ddf.boot.common.authentication.util.UserContextUtil;
import com.ddf.boot.common.core.util.PreconditionUtil;
import com.ddf.boot.common.core.util.WebUtil;
import com.ddf.game.xiuxian.api.enume.LoginTypeEnum;
import com.ddf.game.xiuxian.api.enume.PlayerConfigCodeEnum;
import com.ddf.game.xiuxian.api.enume.XiuXianExceptionCode;
import com.ddf.game.xiuxian.api.event.PlayerLoginEventPayload;
import com.ddf.game.xiuxian.api.request.player.LoginRequest;
import com.ddf.game.xiuxian.api.response.player.LoginResponse;
import com.ddf.game.xiuxian.core.application.event.PlayerLoginEvent;
import com.ddf.game.xiuxian.core.entity.PlayerInfo;
import com.ddf.game.xiuxian.core.entity.PlayerMetadataConfig;
import com.ddf.game.xiuxian.core.repository.PlayerConfigRepository;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import javax.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

/**
 * <p>登录策略上下文</p >
 *
 * @author Snowball
 * @version 1.0
 * @date 2022/05/23 23:36
 */
@Component
@Slf4j
@RequiredArgsConstructor(onConstructor_={@Autowired})
public class LoginStrategyContext implements ApplicationContextAware {

    private ApplicationContext applicationContext;
    private final PlayerConfigRepository playerConfigRepository;
    private final Map<LoginTypeEnum, LoginStrategy> loginStrategyMap = new HashMap<>();
    private final ApplicationEventPublisher applicationEventPublisher;


    @PostConstruct
    public void init() {
        final Map<String, LoginStrategy> strategyMap = applicationContext.getBeansOfType(LoginStrategy.class);
        if (CollUtil.isEmpty(strategyMap)) {
            return;
        }
        strategyMap.forEach((beanName, clazz) -> {
            loginStrategyMap.put(clazz.getLoginType(), clazz);
        });
    }

    /**
     * 执行登录
     *
     * @param loginRequest
     * @return
     */
    public LoginResponse login(LoginRequest loginRequest) {
        final LoginTypeEnum loginType = loginRequest.getLoginType();
        final LoginStrategy loginStrategy = loginStrategyMap.get(loginType);
        PreconditionUtil.checkArgument(Objects.nonNull(loginStrategy), XiuXianExceptionCode.LOGIN_STRATEGY_MAPPING_ERROR);
        // 登录策略， 校验通过后返回的玩家信息
        final PlayerInfo playerInfo = loginStrategy.login(loginRequest);

        String token = loginRequest.getCredential();
        if (loginType.shouldCreateToken()) {
            // 生成token
            final UserClaim userClaim = new UserClaim();
            userClaim.setUserId(playerInfo.getId().toString());
            userClaim.setUsername(playerInfo.getNickname());
            userClaim.setCredit(WebUtil.getUserAgent());
            final AuthenticateToken authenticateToken = TokenUtil.createToken(userClaim);
            token = authenticateToken.getToken();
        }
        // 发布登录事件
        final RequestContext requestContext = UserContextUtil.getRequestContext();
        final PlayerLoginEventPayload playerLoginEventPayload = new PlayerLoginEventPayload();
        playerLoginEventPayload.setPlayerId(playerInfo.getId());
        playerLoginEventPayload.setLoginType(loginType.name());
        playerLoginEventPayload.setLoginIp(requestContext.getClientIp());
        playerLoginEventPayload.setLoginTime(DateUtils.currentTimeSeconds());
        playerLoginEventPayload.setImei(requestContext.getImei());
        playerLoginEventPayload.setOs(requestContext.getOs().name());
        playerLoginEventPayload.setLongitude(requestContext.getLongitude());
        playerLoginEventPayload.setLatitude(requestContext.getLatitude());
        playerLoginEventPayload.setVersion(requestContext.getVersion());
        applicationEventPublisher.publishEvent(new PlayerLoginEvent(this, playerLoginEventPayload));

        final PlayerMetadataConfig metadataConfig = playerConfigRepository.getConfig(
                playerInfo.getId(), PlayerConfigCodeEnum.ACCOUNT_METADATA);
        return LoginResponse.builder()
                .playerId(playerInfo.getId())
                .token(token)
                .accountMetadata(Objects.nonNull(metadataConfig) ? metadataConfig.getConfigValue() : "")
                .build();
    }

    @Override
    public void setApplicationContext(ApplicationContext context) throws BeansException {
        this.applicationContext = context;
    }
}
