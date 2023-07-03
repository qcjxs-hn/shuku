package com.shuku.entity;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
@TableName("contribution")
@Data
public class Contribution {
    private int id;
    private String leveltxt;
    private int lowerlimit;
    private int upperlimit;
    private String levelimg;
}
