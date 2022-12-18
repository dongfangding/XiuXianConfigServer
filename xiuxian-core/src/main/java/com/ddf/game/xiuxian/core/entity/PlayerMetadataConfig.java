package com.ddf.game.xiuxian.core.entity;

/**
* <p>description</p >
*
* @author Snowball
* @version 1.0
* @date 2022/12/16 14:37
*/
import lombok.Data;

/**
    * 用户数据配置表
    */
@Data
public class PlayerMetadataConfig {
    private Long id;

    /**
    * 玩家ip
    */
    private Long playerId;

    /**
    * 配置代码
    */
    private String configCode;

    /**
    * 配置明细
    */
    private String configValue;
}
