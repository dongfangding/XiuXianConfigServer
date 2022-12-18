package com.ddf.game.xiuxian.core.entity;

import java.io.Serializable;
import lombok.Data;

/**
* <p>description</p >
*
* @author Snowball
* @version 1.0
* @date 2022/12/18 14:40
*/
/**
    * cd key 兑换历史
    */
@Data
public class CdKeyHistory implements Serializable {
    private Long id;

    /**
    * 玩家id
    */
    private Long playerId;

    /**
    * 兑换key
    */
    private String cdKey;

    /**
    * 兑换key类型
    */
    private Object cdKeyType;

    /**
    * 兑换时间
    */
    private Long ctime;

    private static final long serialVersionUID = 1L;
}