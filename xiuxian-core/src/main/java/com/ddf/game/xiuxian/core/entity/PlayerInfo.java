package com.ddf.game.xiuxian.core.entity;

import java.io.Serializable;
import lombok.Data;

/**
* <p>description</p >
*
* @author Snowball
* @version 1.0
* @date 2022/12/17 23:04
*/


/**
 * 用户信息表
 */
@Data
public class PlayerInfo implements Serializable {
    private Long id;

    /**
     * 昵称
     */
    private String nickname;

    /**
     * 密码
     */
    private String password;

    /**
     * 注册Ip
     */
    private String registerIp;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 注册时间
     */
    private Long ctime;

    /**
     * 用户状态
     */
    private Object status;

    private static final long serialVersionUID = 1L;
}