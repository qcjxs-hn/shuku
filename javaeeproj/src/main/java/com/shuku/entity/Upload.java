package com.shuku.entity;

import java.io.Serializable;
import java.util.Date;

/*
    class(Upload) 上传信息实体类
    id： 编号
    uploader: 上传用户id
    uploadedbook: 上传书籍id
    uploadeddate: 上传日期
 */
public class Upload implements Serializable{
    private int id;
    private long uploader;
    private long uploadedbook;
    private Date uploadeddate;

    public Upload() {
    }

    public Upload(int id, long uploader, long uploadedbook, Date uploadeddate) {
        this.id = id;
        this.uploader = uploader;
        this.uploadedbook = uploadedbook;
        this.uploadeddate = uploadeddate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getUploader() {
        return uploader;
    }

    public void setUploader(long uploader) {
        this.uploader = uploader;
    }

    public long getUploadedbook() {
        return uploadedbook;
    }

    public void setUploadedbook(long uploadedbook) {
        this.uploadedbook = uploadedbook;
    }

    public Date getUploadeddate() {
        return uploadeddate;
    }

    public void setUploadeddate(Date uploadeddate) {
        this.uploadeddate = uploadeddate;
    }
}
