package com.ddf.game.xiuxian.core.repository;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.ddf.boot.common.api.util.DateUtils;
import com.ddf.game.xiuxian.core.entity.SysNotice;
import com.ddf.game.xiuxian.core.mapper.SysNoticeMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * <p>系统公告</p >
 *
 * @author Snowball
 * @version 1.0
 * @date 2022/12/18 17:08
 */
@Repository
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
@Slf4j
public class SysNoticeRepository {

    private final SysNoticeMapper sysNoticeMapper;

    /**
     * 查询最新一条公告
     *
     * @return
     */
    public SysNotice latestSysNotice() {
        final LambdaQueryWrapper<SysNotice> wrapper = Wrappers.lambdaQuery();
        wrapper.eq(SysNotice::getActiveFlag, Boolean.TRUE)
                .le(SysNotice::getEffectiveTime, DateUtils.currentTimeSeconds())
                .orderByDesc(SysNotice::getEffectiveTime)
                .last(" limit 1 ");
        return sysNoticeMapper.selectOne(wrapper);
    }
}
