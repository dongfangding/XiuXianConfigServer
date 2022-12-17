package com.ddf.game.xiuxian.core.mapper;

import com.ddf.game.xiuxian.core.entity.PlayerLoginHistory;

/**
* <p>description</p >
*
* @author Snowball
* @version 1.0
* @date 2022/12/17 22:08
*/
public interface PlayerLoginHistoryMapper {
    int deleteByPrimaryKey(Long id);

    int insert(PlayerLoginHistory record);

    int insertSelective(PlayerLoginHistory record);

    PlayerLoginHistory selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(PlayerLoginHistory record);

    int updateByPrimaryKey(PlayerLoginHistory record);
}