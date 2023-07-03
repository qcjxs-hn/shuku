package com.shuku.entity;

import java.io.Serializable;
import java.sql.Timestamp;


/*
    class(Feedback) 反馈实体类
    id: 反馈编号
    loginedUser： 反馈用户（已登陆）
    contact： 联系方式
    suggestion： 建议
    postTime： 提交时间
    status: 状态
 */
public class Feedback implements Serializable {
    private int id;
    private long logineduser;
    private String contact;
    private String suggestion;
    private Timestamp posttime;
    private int status;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getLoginedUser() {
        return logineduser;
    }

    public void setLoginedUser(long loginedUser) {
        this.logineduser = loginedUser;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getSuggestion() {
        return suggestion;
    }

    public void setSuggestion(String suggestion) {
        this.suggestion = suggestion;
    }

    public Timestamp getPostTime() {
        return posttime;
    }

    public void setPostTime(Timestamp postTime) {
        this.posttime = postTime;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

}
