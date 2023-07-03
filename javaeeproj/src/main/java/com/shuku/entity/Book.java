package com.shuku.entity;

import java.io.Serializable;
import java.util.Date;

/*
    class(Book) 书籍实体类
    id: 书籍编号
    booktitle: 书籍标题
    bookauthor: 书籍作者
    bookpubyear: 出版时间
    booksummary: 书籍摘要
    typeid: 类型编号
    bookformat: 书籍格式
    downloadtimes: 下载次数
    bookfile: 书籍存储地址
    bookcover: 封面存储地址
 */
public class Book implements Serializable {
    private long id;
    private String booktitle;
    private String bookauthor;
    private String bookpubyear;
    private String booksummary;
    private int typeid;
    private String bookformat;
    private int downloadtimes;
    private String bookfile;
    private String bookcover;

    public Book() {
    }

    public Book(long id, String booktitle, String bookauthor, String bookpubyear, String booksummary, int typeid, String bookformat, int downloadtimes, String bookfile, String bookcover) {
        this.id = id;
        this.booktitle = booktitle;
        this.bookauthor = bookauthor;
        this.bookpubyear = bookpubyear;
        this.booksummary = booksummary;
        this.typeid = typeid;
        this.bookformat = bookformat;
        this.downloadtimes = downloadtimes;
        this.bookfile = bookfile;
        this.bookcover = bookcover;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getBooktitle() {
        return booktitle;
    }

    public void setBooktitle(String booktitle) {
        this.booktitle = booktitle;
    }

    public String getBookauthor() {
        return bookauthor;
    }

    public void setBookauthor(String bookauthor) {
        this.bookauthor = bookauthor;
    }

    public String getBookpubyear() {
        return bookpubyear;
    }

    public void setBookpubyear(String bookpubyear) {
        this.bookpubyear = bookpubyear;
    }

    public String getBooksummary() {
        return booksummary;
    }

    public void setBooksummary(String booksummary) {
        this.booksummary = booksummary;
    }

    public int getTypeid() {
        return typeid;
    }

    public void setTypeid(int typeid) {
        this.typeid = typeid;
    }

    public String getBookformat() {
        return bookformat;
    }

    public void setBookformat(String bookformat) {
        this.bookformat = bookformat;
    }

    public int getDownloadtimes() {
        return downloadtimes;
    }

    public void setDownloadtimes(int downloadtimes) {
        this.downloadtimes = downloadtimes;
    }

    public String getBookfile() {
        return bookfile;
    }

    public void setBookfile(String bookfile) {
        this.bookfile = bookfile;
    }

    public String getBookcover() {
        return bookcover;
    }

    public void setBookcover(String bookcover) {
        this.bookcover = bookcover;
    }

}
