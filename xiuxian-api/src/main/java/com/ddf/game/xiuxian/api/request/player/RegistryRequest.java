package com.ddf.game.xiuxian.api.request.player;

import java.io.Serializable;
import javax.validation.constraints.NotBlank;
import lombok.Data;

/**
 * 玩家注册
 *
 * @author snowball
 * @date 2022/12/16 13:40
 **/
@Data
public class RegistryRequest implements Serializable {

    private static final long serialVersionUID = 1516322558409231083L;

    /**
     * 账号
     */
    @NotBlank(message = "账号不能为空")
    private String nickname;

    /**
     * 登录密码
     */
    @NotBlank(message = "登录密码不能为空")
    private String password;
}
