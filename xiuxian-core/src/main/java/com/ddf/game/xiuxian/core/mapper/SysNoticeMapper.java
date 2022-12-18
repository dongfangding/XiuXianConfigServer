package com.ddf.game.xiuxian.core.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ddf.game.xiuxian.core.entity.SysNotice;

/**
* <p>description</p >
*
* @author Snowball
* @version 1.0
* @date 2022/12/17 23:04
*/
public interface SysNoticeMapper extends BaseMapper<SysNotice> {
    int deleteByPrimaryKey(Long id);

    int insert(SysNotice record);

    int insertSelective(SysNotice record);

    SysNotice selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SysNotice record);

    int updateByPrimaryKey(SysNotice record);
}
