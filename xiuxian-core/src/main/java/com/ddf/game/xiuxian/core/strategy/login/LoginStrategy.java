package com.ddf.game.xiuxian.core.strategy.login;


import com.ddf.game.xiuxian.api.enume.LoginTypeEnum;
import com.ddf.game.xiuxian.api.request.player.LoginRequest;
import com.ddf.game.xiuxian.core.entity.PlayerInfo;

/**
 * <p>登录策略接口</p >
 *
 * @author Snowball
 * @version 1.0
 * @date 2022/05/23 23:38
 */
public interface LoginStrategy {

    /**
     * 登录类型
     * @return
     */
    LoginTypeEnum getLoginType();

    /**
     * 登录
     *
     * @param loginRequest
     * @return
     */
    PlayerInfo login(LoginRequest loginRequest);

}
