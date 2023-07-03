package com.shuku.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.sql.Timestamp;

@TableName("feedback")
@Data
public class Feedback {
    @TableId(type = IdType.AUTO)
    private int id;
    private long logineduser;
    private String contact;
    private String suggestion;
    private Timestamp posttime;
    private int status;
}
