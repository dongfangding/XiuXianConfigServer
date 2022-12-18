package com.ddf.game.xiuxian.core.mapper;

import com.ddf.game.xiuxian.core.entity.CdKeyHistory;

/**
* <p>description</p >
*
* @author Snowball
* @version 1.0
* @date 2022/12/18 14:40
*/
public interface CdKeyHistoryMapper {
    int deleteByPrimaryKey(Long id);

    int insert(CdKeyHistory record);

    int insertSelective(CdKeyHistory record);

    CdKeyHistory selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(CdKeyHistory record);

    int updateByPrimaryKey(CdKeyHistory record);
}