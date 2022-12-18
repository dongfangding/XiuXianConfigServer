package com.ddf.game.xiuxian.api.enume;

/**
 * <p>cd key类型</p >
 *
 * @author Snowball
 * @version 1.0
 * @date 2022/12/18 14:46
 */
public enum CdKeyEnum {

    /**
     * 永久有效，每人可兑换一次
     */
    FOREVER_EVERYONE,
    /**
     * 有效期内有效， 每人可兑换一次
     */
    DURING_EVERYONE,
    /**
     * 永久有效，只能兑换一次
     */
    FOREVER_ONCE
}
