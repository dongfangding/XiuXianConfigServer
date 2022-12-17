package com.ddf.game.xiuxian.core.entity;

import java.io.Serializable;
import lombok.Data;

/**
* <p>description</p >
*
* @author Snowball
* @version 1.0
* @date 2022/12/17 23:04
*/
/**
    * 系统公告
    */
@Data
public class SysNotice implements Serializable {
    private Long id;

    /**
    * 标题
    */
    private String title;

    /**
    * 公告详细内容
    */
    private String content;

    /**
    * 是否有效
    */
    private Boolean activeFlag;

    /**
    * 创建时间
    */
    private Long ctime;

    /**
    * 生效时间
    */
    private Long effectiveTime;

    private static final long serialVersionUID = 1L;
}