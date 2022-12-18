package com.ddf.game.xiuxian.core.application.event;

import com.ddf.game.xiuxian.api.event.PlayerLoginEventPayload;
import lombok.Getter;
import org.springframework.context.ApplicationEvent;

/**
 * <p>description</p >
 *
 * @author Snowball
 * @version 1.0
 * @date 2022/12/18 13:38
 */
public class PlayerLoginEvent extends ApplicationEvent {

    @Getter
    private final PlayerLoginEventPayload payload;

    public PlayerLoginEvent(Object source, PlayerLoginEventPayload payload) {
        super(source);
        this.payload = payload;
    }
}
