package com.ddf.game.xiuxian.core.repository;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.ddf.game.xiuxian.core.entity.CdKeyConfig;
import com.ddf.game.xiuxian.core.entity.CdKeyHistory;
import com.ddf.game.xiuxian.core.mapper.CdKeyConfigMapper;
import com.ddf.game.xiuxian.core.mapper.CdKeyHistoryMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * <p>cd key仓储</p >
 *
 * @author Snowball
 * @version 1.0
 * @date 2022/12/18 14:53
 */
@Component
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
@Slf4j
public class CdKeyRepository {

    private final CdKeyConfigMapper cdKeyConfigMapper;
    private final CdKeyHistoryMapper cdKeyHistoryMapper;

    /**
     * 根据cd key 查询记录
     *
     * @param cdKey
     * @return
     */
    public CdKeyConfig getByCdKey(String cdKey) {
        final LambdaQueryWrapper<CdKeyConfig> wrapper = Wrappers.lambdaQuery();
        wrapper.eq(CdKeyConfig::getCdKey, cdKey);
        return cdKeyConfigMapper.selectOne(wrapper);
    }

    /**
     * 使用一次性的cd key
     *
     * @param cdKey
     * @return
     */
    public boolean usedOnceCdKey(String cdKey) {
        final LambdaUpdateWrapper<CdKeyConfig> wrapper = Wrappers.lambdaUpdate();
        wrapper.eq(CdKeyConfig::getCdKey, cdKey)
                .eq(CdKeyConfig::getUsedFlag, Boolean.FALSE);
        wrapper.set(CdKeyConfig::getUsedFlag, Boolean.TRUE);
        return cdKeyConfigMapper.update(null, wrapper) > 0;
    }

    /**
     * 插入cd key 历史记录
     *
     * @param cdKeyHistory
     * @return
     */
    public int insertCdKeyHistory(CdKeyHistory cdKeyHistory) {
        return cdKeyHistoryMapper.insert(cdKeyHistory);
    }

}
