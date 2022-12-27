package com.ddf.game.xiuxian.api.request.player;

import com.ddf.game.xiuxian.api.enume.ProgressTypeEnum;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <p>玩家进度同步请求</p >
 *
 * @author Snowball
 * @version 1.0
 * @date 2022/12/27 13:46
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PlayerProgressSyncRequest implements Serializable {

    private static final long serialVersionUID = 1516322558409231083L;

    /**
     * 进度类型
     */
    private ProgressTypeEnum progressType;

}
