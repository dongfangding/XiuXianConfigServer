package com.ddf.game.xiuxian.core.repository;

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
}
