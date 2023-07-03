package com.shuku.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@TableName("avatar")
@Data
public class Tx {
    private int id;
    private String  avatartxt;
    private String avatarimg;
}
