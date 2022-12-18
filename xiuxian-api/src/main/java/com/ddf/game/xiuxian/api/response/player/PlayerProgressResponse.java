package com.ddf.game.xiuxian.api.response.player;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <p>玩家进度响应</p >
 *
 * @author Snowball
 * @version 1.0
 * @date 2022/12/18 17:25
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PlayerProgressResponse implements Serializable {

    private static final long serialVersionUID = 1516322558409231083L;

    /**
     * 是否有新公告
     */
    private boolean newNotice;
}
