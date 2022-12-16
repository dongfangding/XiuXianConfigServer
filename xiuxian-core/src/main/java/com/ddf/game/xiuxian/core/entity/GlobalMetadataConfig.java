package com.ddf.game.xiuxian.core.entity;

/**
* <p>description</p >
*
* @author Snowball
* @version 1.0
* @date 2022/12/16 14:37
*/
/**
    * 服务配置中心
    */
public class GlobalMetadataConfig {
    private Long id;

    /**
    * 配置代码
    */
    private String configCode;

    /**
    * 配置值
    */
    private String configValue;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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