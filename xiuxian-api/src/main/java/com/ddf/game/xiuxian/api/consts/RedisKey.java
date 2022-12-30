package com.ddf.game.xiuxian.api.consts;

import com.ddf.game.xiuxian.api.enume.CdKeyEnum;

/**
 * <p>redis key</p >
 *
 * @author Snowball
 * @version 1.0
 * @date 2022/12/18 14:41
 */
public interface RedisKey {

    /**
     * cd key
     * %s cd key类型
     */
    String CD_KEY = "xiu_xian:cd_key:%s";

    /**
     * 广告点击次数统计
     */
    String AD_CLICK_TIMES = "statistics:ad_click_times";

    /**
     * 获取cd key的key
     *
     * @param cdKeyEnum
     * @return
     */
    static String getCdKey(CdKeyEnum cdKeyEnum) {
        return String.format(CD_KEY, cdKeyEnum.name());
    }
}
