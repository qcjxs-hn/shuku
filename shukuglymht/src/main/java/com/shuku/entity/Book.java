package com.shuku.entity;


import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
@TableName("book")
@Data
public class Book {
    private long id;
    private String booktitle;
    private String bookauthor;
    private String booksummary;
    private int typeid;
    private int downloadtimes;
    private String bookpubyear;
    private String bookfile;
    private String bookcover;
    private String bookformat;
}
