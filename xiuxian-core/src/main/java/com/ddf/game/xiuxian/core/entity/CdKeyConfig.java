package com.ddf.game.xiuxian.core.entity;

import java.io.Serializable;
import lombok.Data;

/**
* <p>description</p >
*
* @author Snowball
* @version 1.0
* @date 2022/12/18 15:32
*/


/**
 * cd key配置
 */
@Data
public class CdKeyConfig implements Serializable {
    private Long id;

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

    /**
     * 是否已被使用
     */
    private Boolean usedFlag;

    private static final long serialVersionUID = 1L;
}
