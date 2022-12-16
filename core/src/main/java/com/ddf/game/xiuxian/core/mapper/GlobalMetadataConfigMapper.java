package com.ddf.game.xiuxian.core.mapper;

import com.ddf.game.xiuxian.core.entity.GlobalMetadataConfig;

/**
* <p>description</p >
*
* @author Snowball
* @version 1.0
* @date 2022/12/16 14:37
*/
public interface GlobalMetadataConfigMapper {
    int deleteByPrimaryKey(Long id);

    int insert(GlobalMetadataConfig record);

    int insertSelective(GlobalMetadataConfig record);

    GlobalMetadataConfig selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(GlobalMetadataConfig record);

    int updateByPrimaryKey(GlobalMetadataConfig record);
}