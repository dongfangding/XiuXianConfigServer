package com.ddf.game.xiuxian.api.event;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <p>用户登录数据载荷</p >
 *
 * @author Snowball
 * @version 1.0
 * @date 2022/12/17 22:10
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PlayerLoginEventPayload implements Serializable {
    private static final long serialVersionUID = 1516322558409231083L;



}
