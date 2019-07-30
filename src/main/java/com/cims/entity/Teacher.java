package com.cims.entity;

import java.util.Date;

public class Teacher {
    private Integer teacherId;

    private String username;

    private String password;

    private String name;

    private String phone;

    private String tDescription;

    private String tPhoto;

    private Date createTime;

    private Date updateTime;

    public Teacher(Integer teacherId, String username, String password, String name, String phone, String tDescription, String tPhoto, Date createTime, Date updateTime) {
        this.teacherId = teacherId;
        this.username = username;
        this.password = password;
        this.name = name;
        this.phone = phone;
        this.tDescription = tDescription;
        this.tPhoto = tPhoto;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public Teacher() {
        super();
    }

    public Integer getteacherId() {
        return teacherId;
    }

    public void setteacherId(Integer teacherId) {
        this.teacherId = teacherId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String gettDescription() {
        return tDescription;
    }

    public void settDescription(String tDescription) {
        this.tDescription = tDescription == null ? null : tDescription.trim();
    }

    public String gettPhoto() {
        return tPhoto;
    }

    public void settPhoto(String tPhoto) {
        this.tPhoto = tPhoto == null ? null : tPhoto.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", teacherId=").append(teacherId);
        sb.append(", username=").append(username);
        sb.append(", password=").append(password);
        sb.append(", name=").append(name);
        sb.append(", phone=").append(phone);
        sb.append(", tDescription=").append(tDescription);
        sb.append(", tPhoto=").append(tPhoto);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append("]");
        return sb.toString();
    }
}