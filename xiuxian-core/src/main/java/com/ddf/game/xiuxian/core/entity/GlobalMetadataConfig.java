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
    * 服务配置中心
    */
@Data
public class GlobalMetadataConfig {

    private String cdkey;


    private Long id;

    /**
    * 配置代码
    */
    private String configCode;

    /**
    * 配置值
    */
    private String configValue;

}
