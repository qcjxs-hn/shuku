package com.shuku.entity;

import java.io.Serializable;

/*
    class(Contribution) 等级信息实体类
    id: 等级类别编号
    lowerLimit: 每种等级最低分数
    upperLimit: 每种等级最高分数
    level_txt： 等级名称
    level_img： 等级标识图片
 */
public class Contribution implements Serializable{
    private int id;
    private int lowerlimit;
    private int upperlimit;
    private String leveltxt;
    private String levelimg;

    public Contribution() {
    }

    public Contribution(int id, int lowerlimit, int upperlimit, String leveltxt, String levelimg) {
        this.id = id;
        this.lowerlimit = lowerlimit;
        this.upperlimit = upperlimit;
        this.leveltxt = leveltxt;
        this.levelimg = levelimg;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getLowerlimit() {
        return lowerlimit;
    }

    public void setLowerlimit(int lowerlimit) {
        this.lowerlimit = lowerlimit;
    }

    public int getUpperlimit() {
        return upperlimit;
    }

    public void setUpperlimit(int upperlimit) {
        this.upperlimit = upperlimit;
    }

    public String getLeveltxt() {
        return leveltxt;
    }

    public void setLeveltxt(String leveltxt) {
        this.leveltxt = leveltxt;
    }

    public String getLevelimg() {
        return levelimg;
    }

    public void setLevelimg(String levelimg) {
        this.levelimg = levelimg;
    }
}
