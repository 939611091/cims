package com.cims.vo;

import com.cims.entity.Course_category;
import com.cims.entity.Teacher;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class CourseDetailsVo {
    private Integer id;

    private String categoryName;

    private String teacherName;

    private String cName;

    private String cDescription;

    private String cPhoto;

    private Integer period;

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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
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

    public Integer getPeriod() {
        return period;
    }

    public void setPeriod(Integer period) {
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
        return "CourseDetailsVo{" +
                "id=" + id +
                ", categoryName='" + categoryName + '\'' +
                ", teacherName='" + teacherName + '\'' +
                ", cName='" + cName + '\'' +
                ", cDescription='" + cDescription + '\'' +
                ", cPhoto='" + cPhoto + '\'' +
                ", period=" + period +
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
