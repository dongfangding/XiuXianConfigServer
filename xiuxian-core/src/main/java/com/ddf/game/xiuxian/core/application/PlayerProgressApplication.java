package com.ddf.game.xiuxian.core.application;

import com.ddf.game.xiuxian.api.request.player.PlayerProgressSyncRequest;

/**
 * <p>玩家进度应用层接口</p >
 *
 * @author Snowball
 * @version 1.0
 * @date 2022/12/27 13:59
 */
public interface PlayerProgressApplication {

    /**
     * 同步玩家进度
     *
     * @param playerId
     * @param request
     * @return
     */
    boolean sync(Long playerId, PlayerProgressSyncRequest request);
}
