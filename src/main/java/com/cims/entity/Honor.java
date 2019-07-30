package com.cims.entity;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Honor {
    private Integer id;

    private Integer studentId;

    private String name;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date time;

    private String info;

    private String hPhoto;

    private Date createTime;

    private Date updateTime;

    public Honor(Integer id, Integer studentId, String name, Date time, String info, String hPhoto, Date createTime, Date updateTime) {
        this.id = id;
        this.studentId = studentId;
        this.name = name;
        this.time = time;
        this.info = info;
        this.hPhoto = hPhoto;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public Honor() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String gethPhoto() {
        return hPhoto;
    }

    public void sethPhoto(String hPhoto) {
        this.hPhoto = hPhoto;
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
        sb.append(", id=").append(id);
        sb.append(", studentId=").append(studentId);
        sb.append(", name=").append(name);
        sb.append(", time=").append(time);
        sb.append(", info=").append(info);
        sb.append(", hPhoto=").append(hPhoto);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append("]");
        return sb.toString();
    }
}