package com.ddf.game.xiuxian.core.controller;

import com.ddf.boot.common.api.model.common.response.response.ResponseData;
import com.ddf.game.xiuxian.api.response.sysnotice.SysNoticeDTO;
import com.ddf.game.xiuxian.core.application.SysNoticeApplication;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>系统公告控制器</p >
 *
 * @author Snowball
 * @version 1.0
 * @date 2022/12/18 17:45
 */
@RestController
@RequestMapping("/sysNotice")
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
@Slf4j
public class SysNoticeController {

    private final SysNoticeApplication sysNoticeApplication;

    /**
     * 最新一条通告查询
     *
     * @return
     */
    @GetMapping("latestSysNotice")
    public ResponseData<SysNoticeDTO> latestSysNotice() {
        return ResponseData.success(sysNoticeApplication.latestSysNotice());
    }
}
