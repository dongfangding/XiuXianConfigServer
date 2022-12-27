package com.ddf.game.xiuxian.core.application.impl;

import com.ddf.game.xiuxian.api.request.player.PlayerProgressSyncRequest;
import com.ddf.game.xiuxian.core.application.PlayerProgressApplication;
import com.ddf.game.xiuxian.core.repository.PlayerProgressRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>description</p >
 *
 * @author Snowball
 * @version 1.0
 * @date 2022/12/27 14:00
 */
@Service
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
@Slf4j
public class PlayerProgressApplicationImpl implements PlayerProgressApplication {
    private final PlayerProgressRepository playerProgressRepository;

    @Override
    public boolean sync(Long playerId, PlayerProgressSyncRequest request) {
        switch (request.getProgressType()) {
            case SYS_NOTICE:
                return playerProgressRepository.updateLatestReadNoticeTime(playerId);
            default:
                break;
        }
        return false;
    }
}
