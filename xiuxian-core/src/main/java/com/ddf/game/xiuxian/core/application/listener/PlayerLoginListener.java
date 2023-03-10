package com.ddf.game.xiuxian.core.application.listener;

import com.ddf.boot.common.core.util.BeanCopierUtils;
import com.ddf.game.xiuxian.api.event.PlayerLoginEventPayload;
import com.ddf.game.xiuxian.core.application.event.PlayerLoginEvent;
import com.ddf.game.xiuxian.core.entity.PlayerLoginHistory;
import com.ddf.game.xiuxian.core.mapper.PlayerLoginHistoryMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Component;

/**
 * <p>玩家登录事件监听</p >
 *
 * @author Snowball
 * @version 1.0
 * @date 2023/01/02 00:33
 */
@Component
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
@Slf4j
public class PlayerLoginListener implements ApplicationListener<PlayerLoginEvent> {
    private final ThreadPoolTaskExecutor loginPoolTaskExecutor;
    private final PlayerLoginHistoryMapper playerLoginHistoryMapper;

    @Override
    public void onApplicationEvent(PlayerLoginEvent event) {
        loginPoolTaskExecutor.execute(() -> {
            final PlayerLoginEventPayload payload = event.getPayload();
            final PlayerLoginHistory loginHistory = BeanCopierUtils.copy(payload, PlayerLoginHistory.class);
            playerLoginHistoryMapper.insertSelective(loginHistory);
        });
    }
}
