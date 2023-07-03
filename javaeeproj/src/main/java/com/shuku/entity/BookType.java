package com.shuku.entity;

import java.io.Serializable;


/*
    class(BookType) 书籍类型实体类
    id: 书籍类型编号
    booklargetype： 主类型编号
    booksmalltype: 子类型编号
    largetypename: 主类型名称
    smalltypename: 子类型名称
 */
public class BookType implements Serializable{
    private int id;
    private int booklargetype;
    private int booksmalltype;
    private String largetypename;
    private String smalltypename;

    public BookType() {
    }

    public BookType(int id, int booklargetype, int booksmalltype,
                    String largetypename, String smalltypename) {
        this.id = id;
        this.booklargetype = booklargetype;
        this.booksmalltype = booksmalltype;
        this.largetypename = largetypename;
        this.smalltypename = smalltypename;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBooklargetype() {
        return booklargetype;
    }

    public void setBooklargetype(int booklargetype) {
        this.booklargetype = booklargetype;
    }

    public int getBooksmalltype() {
        return booksmalltype;
    }

    public void setBooksmalltype(int booksmalltype) {
        this.booksmalltype = booksmalltype;
    }

    public String getLargetypename() {
        return largetypename;
    }

    public void setLargetypename(String largetypename) {
        this.largetypename = largetypename;
    }

    public String getSmalltypename() {
        return smalltypename;
    }

    public void setSmalltypename(String smalltypename) {
        this.smalltypename = smalltypename;
    }
}
