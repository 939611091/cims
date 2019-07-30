package com.cims.entity;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Course {
    private Integer id;

    private Integer courseCategoryId;

    private Integer teacherId;

    private String cName;

    private String cDescription;

    private String cPhoto;

    private String period;

    private Integer cPeriod;

    private String price;

    private Integer number;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date beginTime;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date overTime;

    private String schoolTime;

    private Integer surplusNumber;

    private Date createTime;

    private Date updateTime;

    public Course(Integer id, Integer courseCategoryId, Integer teacherId, String cName, String cDescription, String cPhoto, String period, Integer cPeriod, String price, Integer number, Date beginTime, Date overTime, String schoolTime, Integer surplusNumber, Date createTime, Date updateTime) {
        this.id = id;
        this.courseCategoryId = courseCategoryId;
        this.teacherId = teacherId;
        this.cName = cName;
        this.cDescription = cDescription;
        this.cPhoto = cPhoto;
        this.period = period;
        this.cPeriod = cPeriod;
        this.price = price;
        this.number = number;
        this.beginTime = beginTime;
        this.overTime = overTime;
        this.schoolTime = schoolTime;
        this.surplusNumber = surplusNumber;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }



    public Course() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCourseCategoryId() {
        return courseCategoryId;
    }

    public void setCourseCategoryId(Integer courseCategoryId) {
        this.courseCategoryId = courseCategoryId;
    }

    public Integer getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Integer teacherId) {
        this.teacherId = teacherId;
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }

    public String getcDescription() {
        return cDescription;
    }

    public void setcDescription(String cDescription) {
        this.cDescription = cDescription;
    }

    public String getcPhoto() {
        return cPhoto;
    }

    public void setcPhoto(String cPhoto) {
        this.cPhoto = cPhoto;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public Integer getcPeriod() {
        return cPeriod;
    }

    public void setcPeriod(Integer cPeriod) {
        this.cPeriod = cPeriod;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Date getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(Date beginTime) {
        this.beginTime = beginTime;
    }

    public Date getOverTime() {
        return overTime;
    }

    public void setOverTime(Date overTime) {
        this.overTime = overTime;
    }

    public String getSchoolTime() {
        return schoolTime;
    }

    public void setSchoolTime(String schoolTime) {
        this.schoolTime = schoolTime;
    }

    public Integer getSurplusNumber() {
        return surplusNumber;
    }

    public void setSurplusNumber(Integer surplusNumber) {
        this.surplusNumber = surplusNumber;
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
        return "Course{" +
                "id=" + id +
                ", courseCategoryId=" + courseCategoryId +
                ", teacherId=" + teacherId +
                ", cName='" + cName + '\'' +
                ", cDescription='" + cDescription + '\'' +
                ", cPhoto='" + cPhoto + '\'' +
                ", period='" + period + '\'' +
                ", cPeriod=" + cPeriod +
                ", price='" + price + '\'' +
                ", number=" + number +
                ", beginTime=" + beginTime +
                ", overTime=" + overTime +
                ", schoolTime='" + schoolTime + '\'' +
                ", surplusNumber=" + surplusNumber +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}