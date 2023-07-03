package com.shuku.entity;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@TableName("upload")
@Data
public class Upload {
    private int id;
    private long uploader;
    private long uploadedbook;
    private String uploadeddate;

}
