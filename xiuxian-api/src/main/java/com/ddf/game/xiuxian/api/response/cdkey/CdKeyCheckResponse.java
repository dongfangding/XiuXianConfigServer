package com.ddf.game.xiuxian.api.response.cdkey;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <p>cd key 兑换响应</p >
 *
 * @author Snowball
 * @version 1.0
 * @date 2022/12/18 15:17
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CdKeyCheckResponse implements Serializable {

    private static final long serialVersionUID = 1516322558409231083L;

    /**
     * 兑换key
     */
    private String cdKey;

    /**
     * 兑换key类型
     */
    private String cdKeyType;

    /**
     * 过期时间，永久类型的cd key该字段无效
     */
    private Long expiredTime;

    /**
     * cd key 内容
     */
    private String cdKeyValue;
}
