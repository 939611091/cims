package com.cims.vo;

import com.cims.entity.Student;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class HonorVo {
    private Integer id;

    private Student student;

    private String name;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date time;

    private String info;

    private String hPhoto;

    private Date createTime;

    private Date updateTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
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
        return "HonorVo{" +
                "id=" + id +
                ", student=" + student +
                ", name='" + name + '\'' +
                ", time=" + time +
                ", info='" + info + '\'' +
                ", hPhoto='" + hPhoto + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}
