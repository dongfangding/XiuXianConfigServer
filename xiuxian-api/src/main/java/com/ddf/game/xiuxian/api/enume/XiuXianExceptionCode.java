package com.ddf.game.xiuxian.api.enume;

import com.ddf.boot.common.api.exception.BaseCallbackCode;

/**
 * <p>错误枚举</p >
 *
 * @author Snowball
 * @version 1.0
 * @date 2022/12/16 15:07
 */
public enum XiuXianExceptionCode implements BaseCallbackCode {

    /**
     * 错误枚举
     */
    ACCOUNT_EXISTS("ACCOUNT_EXISTS", "账号已存在"),
    PASSWORD_ERROR("PASSWORD_ERROR", "密码错误"),
    ACCOUNT_NOT_EXISTS("ACCOUNT_NOT_EXISTS", "账号不存在"),
    ACCOUNT_IN_BLACK("ACCOUNT_IN_BLACK", "账号已被封禁"),
    LOGIN_STRATEGY_MAPPING_ERROR("LOGIN_STRATEGY_MAPPING_ERROR", "登录策略异常~", "服务器开小差了~"),
    IDENTITY_MISMATCH("IDENTITY_MISMATCH", "身份不匹配~"),
    CD_KEY_ERROR("CD_KEY_ERROR", "兑换码无效~"),
    CD_KEY_EXPIRED("CD_KEY_EXPIRED", "兑换码已失效~"),
    CD_KEY_USED("CD_KEY_USED", "兑换码已被使用~"),
    CD_KEY_REPEAT_DRAW("CD_KEY_REPEAT_DRAW", "兑换码只能领取一次~"),
    ;

    private final String code;

    private final String desc;

    private final String bizMessage;

    XiuXianExceptionCode(String code, String desc) {
        this.code = code;
        this.desc = desc;
        this.bizMessage = desc;
    }

    XiuXianExceptionCode(String code, String desc, String bizMessage) {
        this.code = code;
        this.desc = desc;
        this.bizMessage = bizMessage;
    }


    @Override
    public String getCode() {
        return code;
    }

    @Override
    public String getDescription() {
        return desc;
    }

    @Override
    public String getBizMessage() {
        return bizMessage;
    }
}
