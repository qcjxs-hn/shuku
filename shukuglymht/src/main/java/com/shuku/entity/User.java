package com.shuku.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.sql.Date;

@TableName("user")
@Data
public class User {

    @TableId(type = IdType.AUTO)
    private long  id;
    private String usercode;
    private String userpassword="";
    private String username;
    private String email;
    private int avatarnum;
    private int contribution;
    private Date creationdate;

}
