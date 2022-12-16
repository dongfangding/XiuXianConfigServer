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
    ;

    private final String code;

    private final String desc;

    XiuXianExceptionCode(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public String getDescription() {
        return desc;
    }
}
