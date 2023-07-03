package com.shuku.entity;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@TableName("book_type")
@Data
public class Booktype {
    private int id;
    private int booklargetype;
    private int booksmalltype;
    private String largetypename;
    private String smalltypename;
}
