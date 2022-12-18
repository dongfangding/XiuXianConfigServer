package com.ddf.game.xiuxian.core.application;

import com.ddf.game.xiuxian.api.response.sysnotice.SysNoticeDTO;

/**
 * <p>系统通告</p >
 *
 * @author Snowball
 * @version 1.0
 * @date 2022/12/17 23:10
 */
public interface SysNoticeApplication {

    /**
     * 最新一条通告查询
     *
     * @return
     */
    SysNoticeDTO latestSysNotice();
}
