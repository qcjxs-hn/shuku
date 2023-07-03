package com.shuku.entity;

import java.io.Serializable;

/*
    class(Avatar) 用户头像实体类
    id:
    avatar_txt: 头像名称
    avatar_img: 头像地址
 */
public class Avatar implements Serializable{
    private int id;
    private String  avatartxt;
    private String avatarimg;

    public Avatar() {
    }

    public Avatar(int id, String avatartxt, String avatarimg) {
        this.id = id;
        this.avatartxt = avatartxt;
        this.avatarimg = avatarimg;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAvatartxt() {
        return avatartxt;
    }

    public void setAvatartxt(String avatartxt) {
        this.avatartxt = avatartxt;
    }

    public String getAvatarimg() {
        return avatarimg;
    }

    public void setAvatarimg(String avatarimg) {
        this.avatarimg = avatarimg;
    }
}
