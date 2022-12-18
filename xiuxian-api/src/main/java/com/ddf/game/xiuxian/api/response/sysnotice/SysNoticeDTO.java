package com.ddf.game.xiuxian.api.response.sysnotice;

import java.io.Serializable;
import lombok.Data;


/**
    * 系统公告
    */
@Data
public class SysNoticeDTO implements Serializable {

    private static final long serialVersionUID = -563835119519883464L;

    /**
    * 标题
    */
    private String title;

    /**
    * 公告详细内容
    */
    private String content;

    /**
    * 创建时间
    */
    private Long ctime;

    /**
    * 生效时间
    */
    private Long effectiveTime;
}
