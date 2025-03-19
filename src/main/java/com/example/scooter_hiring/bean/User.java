package com.example.scooter_hiring.bean;

import java.util.Date;

public class User {
    private Long id;
    private String userName;
    private String mobile;
    private String password;
    private Date registerDate;
    private Date lastLoginDate;
    private Integer loginCount;

    // 获取id
    public Long getId() {
        return id;
    }

    // 设置id
    public void setId(Long id) {
        this.id = id;
    }

    // 获取用户名
    public String getUserName() {
        return userName;
    }

    // 设置用户名
    public void setUserName(String userName) {
        this.userName = userName;
    }

    // 获取手机号
    public String getMobile() {
        return mobile;
    }

    // 设置手机号
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    // 获取密码
    public String getPassword() {
        return password;
    }

    // 设置密码
    public void setPassword(String password) {
        this.password = password;
    }

    // 获取注册时间
    public Date getRegisterDate() {
        return registerDate;
    }

    // 设置注册时间
    public void setRegisterDate(Date registerDate) {
        this.registerDate = registerDate;
    }

    // 获取最后登录时间
    public Date getLastLoginDate() {
        return lastLoginDate;
    }

    // 设置最后登录时间
    public void setLastLoginDate(Date lastLoginDate) {
        this.lastLoginDate = lastLoginDate;
    }

    // 获取登录次数
    public Integer getLoginCount() {
        return loginCount;
    }

    // 设置登录次数
    public void setLoginCount(Integer loginCount) {
        this.loginCount = loginCount;
    }
}
