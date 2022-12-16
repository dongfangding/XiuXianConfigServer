package com.ddf.game.xiuxian.core.entity;

/**
* <p>description</p >
*
* @author Snowball
* @version 1.0
* @date 2022/12/16 14:37
*/


/**
 * 用户信息表
 */
public class PlayerInfo {
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

    /**
     * 最近一次账号密码登录时间
     */
    private Long latestLoginTime;

    /**
     * 最近一次token登录时间，心跳
     */
    private Long latestTokenLoginTime;

    /**
     * 最近一次账号密码登录ip
     */
    private String latestLoginIp;

    /**
     * 最近一次token登录Ip
     */
    private String latestTokenLoginIp;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRegisterIp() {
        return registerIp;
    }

    public void setRegisterIp(String registerIp) {
        this.registerIp = registerIp;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getCtime() {
        return ctime;
    }

    public void setCtime(Long ctime) {
        this.ctime = ctime;
    }

    public Object getStatus() {
        return status;
    }

    public void setStatus(Object status) {
        this.status = status;
    }

    public Long getLatestLoginTime() {
        return latestLoginTime;
    }

    public void setLatestLoginTime(Long latestLoginTime) {
        this.latestLoginTime = latestLoginTime;
    }

    public Long getLatestTokenLoginTime() {
        return latestTokenLoginTime;
    }

    public void setLatestTokenLoginTime(Long latestTokenLoginTime) {
        this.latestTokenLoginTime = latestTokenLoginTime;
    }

    public String getLatestLoginIp() {
        return latestLoginIp;
    }

    public void setLatestLoginIp(String latestLoginIp) {
        this.latestLoginIp = latestLoginIp;
    }

    public String getLatestTokenLoginIp() {
        return latestTokenLoginIp;
    }

    public void setLatestTokenLoginIp(String latestTokenLoginIp) {
        this.latestTokenLoginIp = latestTokenLoginIp;
    }
}