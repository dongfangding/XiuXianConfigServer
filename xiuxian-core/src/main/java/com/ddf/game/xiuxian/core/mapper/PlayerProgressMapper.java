package com.ddf.game.xiuxian.core.mapper;

import com.ddf.game.xiuxian.core.entity.PlayerProgress;

/**
* <p>description</p >
*
* @author Snowball
* @version 1.0
* @date 2022/12/17 23:04
*/
public interface PlayerProgressMapper {
    int deleteByPrimaryKey(Long id);

    int insert(PlayerProgress record);

    int insertSelective(PlayerProgress record);

    PlayerProgress selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(PlayerProgress record);

    int updateByPrimaryKey(PlayerProgress record);
}