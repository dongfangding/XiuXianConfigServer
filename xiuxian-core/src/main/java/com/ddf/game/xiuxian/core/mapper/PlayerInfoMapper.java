package com.ddf.game.xiuxian.core.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ddf.game.xiuxian.core.entity.PlayerInfo;

/**
 * <p>description</p >
 *
 * @author Snowball
 * @version 1.0
 * @date 2022/12/17 23:04
 */
public interface PlayerInfoMapper extends BaseMapper<PlayerInfo> {
    int deleteByPrimaryKey(Long id);

    int insert(PlayerInfo record);

    int insertSelective(PlayerInfo record);

    PlayerInfo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(PlayerInfo record);

    int updateByPrimaryKey(PlayerInfo record);
}
