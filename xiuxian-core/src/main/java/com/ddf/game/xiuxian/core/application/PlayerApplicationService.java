package com.ddf.game.xiuxian.core.application;

import com.ddf.game.xiuxian.api.enume.PlayerConfigCodeEnum;
import com.ddf.game.xiuxian.api.request.player.LoginRequest;
import com.ddf.game.xiuxian.api.request.player.PlayerConfigSyncRequest;
import com.ddf.game.xiuxian.api.request.player.RegistryRequest;
import com.ddf.game.xiuxian.api.response.player.LoginResponse;

/**
 * <p>玩家</p >
 *
 * @author Snowball
 * @version 1.0
 * @date 2022/12/16 14:39
 */
public interface PlayerApplicationService {

    /**
     * 注册账号
     *
     * @param request
     */
    void registry(RegistryRequest request);

    /**
     * 登录
     *
     * @param loginRequest
     * @return
     */
    LoginResponse login(LoginRequest loginRequest);

    /**
     * 玩家配置同步
     *
     * @param playerId       玩家Id
     * @param configCodeEnum
     * @param request
     * @return
     */
    boolean playerConfigSyncRequest(Long playerId, PlayerConfigCodeEnum configCodeEnum,
            PlayerConfigSyncRequest request);

    /**
     * 获取账号元数据
     *
     * @param playerId
     * @return
     */
    String getAccountMetadata(Long playerId);
}
