package com.ddf.game.xiuxian.core.repository;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.ddf.game.xiuxian.core.entity.PlayerInfo;
import com.ddf.game.xiuxian.core.mapper.PlayerInfoMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * <p>玩家仓储</p >
 *
 * @author Snowball
 * @version 1.0
 * @date 2022/12/16 14:57
 */
@Repository
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
@Slf4j
public class PlayerRepository {

    private final PlayerInfoMapper playerInfoMapper;

    public PlayerInfo getById(Long playerId) {
        return playerInfoMapper.selectByPrimaryKey(playerId);
    }

    /**
     * 根据登录账号查询用户
     *
     * @param nickname
     * @return
     */
    public PlayerInfo getByAccountName(String nickname) {
        final LambdaQueryWrapper<PlayerInfo> wrapper = Wrappers.lambdaQuery();
        wrapper.eq(PlayerInfo::getNickname, nickname);
        return playerInfoMapper.selectOne(wrapper);
    }

    /**
     * 昵称是否存在
     *
     * @param nickname
     * @return
     */
    public boolean nicknameExists(String nickname) {
        final LambdaQueryWrapper<PlayerInfo> wrapper = Wrappers.lambdaQuery();
        wrapper.eq(PlayerInfo::getNickname, nickname);
        return playerInfoMapper.selectCount(wrapper) > 0;
    }

    /**
     * 插入玩家信息
     *
     * @param playerInfo
     * @return
     */
    public boolean insertPlayerInfo(PlayerInfo playerInfo) {
        return playerInfoMapper.insertSelective(playerInfo) > 0;
    }


    /**
     * 更新玩家信息
     *
     * @param playerInfo
     * @return
     */
    public boolean updatePlayerInfo(PlayerInfo playerInfo) {
        return playerInfoMapper.updateByPrimaryKey(playerInfo) > 0;
    }
}
