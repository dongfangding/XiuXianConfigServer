package com.ddf.game.xiuxian.core.entity;

/**
* <p>description</p >
*
* @author Snowball
* @version 1.0
* @date 2022/12/16 14:37
*/
/**
    * 用户数据配置表
    */
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPlayerId() {
        return playerId;
    }

    public void setPlayerId(Long playerId) {
        this.playerId = playerId;
    }

    public String getConfigCode() {
        return configCode;
    }

    public void setConfigCode(String configCode) {
        this.configCode = configCode;
    }

    public String getConfigValue() {
        return configValue;
    }

    public void setConfigValue(String configValue) {
        this.configValue = configValue;
    }
}