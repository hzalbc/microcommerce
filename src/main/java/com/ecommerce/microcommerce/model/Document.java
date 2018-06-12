package com.ecommerce.microcommerce.model;

import java.util.Date;

public class Document {

    String id;
    String idOwner;
    Date uploadDate;
    String content;

    public Document(String id, String idOwner, Date uploadDate, String content) {
        this.id = id;
        this.idOwner = idOwner;
        this.uploadDate = uploadDate;
        this.content = content;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdOwner() {
        return idOwner;
    }

    public void setIdOwner(String idOwner) {
        this.idOwner = idOwner;
    }

    public Date getUploadDate() {
        return uploadDate;
    }

    public void setUploadDate(Date uploadDate) {
        this.uploadDate = uploadDate;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Document{" +
                "id='" + id + '\'' +
                ", idOwner='" + idOwner + '\'' +
                ", uploadDate=" + uploadDate +
                ", content='" + content + '\'' +
                '}';
    }
}
