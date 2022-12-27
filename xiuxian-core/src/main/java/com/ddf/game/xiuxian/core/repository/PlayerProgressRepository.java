package com.ddf.game.xiuxian.core.repository;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.ddf.boot.common.api.util.DateUtils;
import com.ddf.game.xiuxian.core.entity.PlayerProgress;
import com.ddf.game.xiuxian.core.mapper.PlayerProgressMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * <p>玩家进度条仓储</p >
 *
 * @author Snowball
 * @version 1.0
 * @date 2022/12/17 23:06
 */
@Repository
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
@Slf4j
public class PlayerProgressRepository {

    private final PlayerProgressMapper playerProgressMapper;

    /**
     * 保存记录
     *
     * @param playerProgress
     * @return
     */
    public int insertPlayerProgress(PlayerProgress playerProgress) {
        return playerProgressMapper.insertSelective(playerProgress);
    }

    /**
     * 获取玩家进度
     *
     * @param playerId
     * @return
     */
    public PlayerProgress getPlayerProgress(Long playerId) {
        final LambdaQueryWrapper<PlayerProgress> wrapper = Wrappers.lambdaQuery();
        wrapper.eq(PlayerProgress::getPlayerId, playerId);
        return playerProgressMapper.selectOne(wrapper);
    }

    /**
     * 更新玩家最后读公告时间
     *
     * @param playerId
     * @return
     */
    public boolean updateLatestReadNoticeTime(Long playerId) {
        final LambdaUpdateWrapper<PlayerProgress> wrapper = Wrappers.lambdaUpdate();
        wrapper.eq(PlayerProgress::getPlayerId, playerId);
        wrapper.set(PlayerProgress::getLatestReadNoticeTime, DateUtils.currentTimeSeconds());
        return playerProgressMapper.update(null, wrapper) > 0;
    }
}
