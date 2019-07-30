package com.cims.vo;

import com.cims.entity.Course_category;
import com.cims.entity.Teacher;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * 把类别和教师合到一起
 */
public class CourseVo {
    private Integer id;

    private Course_category course_category;

    private Teacher teacher;

    private String cName;

    private String cDescription;

    private String cPhoto;

    private String period;

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


    @Override
    public String toString() {
        return "CourseVo{" +
                "id=" + id +
                ", course_category=" + course_category +
                ", teacher=" + teacher +
                ", cName='" + cName + '\'' +
                ", cDescription='" + cDescription + '\'' +
                ", cPhoto='" + cPhoto + '\'' +
                ", period='" + period + '\'' +
                ", price='" + price + '\'' +
                ", number='" + number + '\'' +
                ", beginTime=" + beginTime +
                ", overTime=" + overTime +
                ", schoolTime='" + schoolTime + '\'' +
                ", surplusNumber=" + surplusNumber +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Course_category getCourse_category() {
        return course_category;
    }

    public void setCourse_category(Course_category course_category) {
        this.course_category = course_category;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
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
}
