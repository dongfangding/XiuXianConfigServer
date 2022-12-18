package com.ddf.game.xiuxian.core.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ddf.game.xiuxian.core.entity.CdKeyConfig;

/**
 * <p>description</p >
 *
 * @author Snowball
 * @version 1.0
 * @date 2022/12/18 15:32
 */
public interface CdKeyConfigMapper extends BaseMapper<CdKeyConfig> {
    int deleteByPrimaryKey(Long id);

    int insert(CdKeyConfig record);

    int insertSelective(CdKeyConfig record);

    CdKeyConfig selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(CdKeyConfig record);

    int updateByPrimaryKey(CdKeyConfig record);
}
