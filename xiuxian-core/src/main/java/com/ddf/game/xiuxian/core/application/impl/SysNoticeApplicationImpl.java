package com.ddf.game.xiuxian.core.application.impl;

import com.ddf.boot.common.core.util.BeanCopierUtils;
import com.ddf.game.xiuxian.api.response.sysnotice.SysNoticeDTO;
import com.ddf.game.xiuxian.core.application.SysNoticeApplication;
import com.ddf.game.xiuxian.core.entity.SysNotice;
import com.ddf.game.xiuxian.core.repository.SysNoticeRepository;
import java.util.Objects;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>系统通告</p >
 *
 * @author Snowball
 * @version 1.0
 * @date 2022/12/18 17:22
 */
@Service
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
@Slf4j
public class SysNoticeApplicationImpl implements SysNoticeApplication {

    private final SysNoticeRepository sysNoticeRepository;

    @Override
    public SysNoticeDTO latestSysNotice() {
        final SysNotice notice = sysNoticeRepository.latestSysNotice();
        if (Objects.isNull(notice)) {
            return null;
        }
        return BeanCopierUtils.copy(notice, SysNoticeDTO.class);
    }
}
