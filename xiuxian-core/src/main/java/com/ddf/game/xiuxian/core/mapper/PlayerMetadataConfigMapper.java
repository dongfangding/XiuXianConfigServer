package com.ddf.game.xiuxian.core.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ddf.game.xiuxian.core.entity.PlayerMetadataConfig;

/**
* <p>description</p >
*
* @author Snowball
* @version 1.0
* @date 2022/12/16 14:37
*/
public interface PlayerMetadataConfigMapper extends BaseMapper<PlayerMetadataConfig> {
    int deleteByPrimaryKey(Long id);

    int insert(PlayerMetadataConfig record);

    int insertSelective(PlayerMetadataConfig record);

    PlayerMetadataConfig selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(PlayerMetadataConfig record);

    int updateByPrimaryKey(PlayerMetadataConfig record);

    /**
     * 保存或更新
     *
     * @param record
     * @return
     */
    int insertOrUpdate(PlayerMetadataConfig record);
}
