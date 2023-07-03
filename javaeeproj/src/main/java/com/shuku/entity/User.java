package com.shuku.entity;

import java.io.Serializable;
import java.util.Date;

/*
    class(User) 用户实体类
    id： 编号
    usercode: 用户账号
    userpassword： 用户密码
    username： 用户密码
    email： 用户邮箱
    avatarNum： 头像编号
    contribution： 贡献积分
    creationdate： 创建日期
 */
public class User implements Serializable {
    
    private long  id;
    private String usercode;
    private String userpassword="";
    private String username;
    private String email;
    private int avatarnum;
    private int contribution;
    private Date creationdate;

    public User() {
    }

    public User(long id, String usercode, String userpassword,
                String username, String email, int avatar,
                int contribution, Date creationdate) {
        this.id = id;
        this.usercode = usercode;
        this.userpassword = userpassword;
        this.username = username;
        this.email = email;
        this.avatarnum = avatar;
        this.contribution = contribution;
        this.creationdate = creationdate;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsercode() {
        return usercode;
    }

    public void setUsercode(String usercode) {
        this.usercode = usercode;
    }

    public String getUserpassword() {
        return userpassword;
    }

    public void setUserpassword(String userpassword) {
        this.userpassword = userpassword;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAvatarnum() {
        return avatarnum;
    }

    public void setAvatarNum(int avatarNum) {  this.avatarnum = avatarNum; }

    public int getContribution() {
        return contribution;
    }

    public void setContribution(int contribution) {
        this.contribution = contribution;
    }

    public Date getCreationdate() {
        return creationdate;
    }

    public void setCreationdate(Date creationdate) {
        this.creationdate = creationdate;
    }
}
