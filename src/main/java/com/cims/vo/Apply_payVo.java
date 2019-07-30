package com.cims.vo;

import com.cims.entity.Course;
import com.cims.entity.Student;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Apply_payVo {
    private Integer id;

    private Student student;

    private Course course;

    private String payStudent;

    private String payAmount;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date payTime;

    private Integer hour;

    private Integer surplusHour;

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

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public String getPayStudent() {
        return payStudent;
    }

    public void setPayStudent(String payStudent) {
        this.payStudent = payStudent;
    }

    public String getPayAmount() {
        return payAmount;
    }

    public void setPayAmount(String payAmount) {
        this.payAmount = payAmount;
    }

    public Date getPayTime() {
        return payTime;
    }

    public void setPayTime(Date payTime) {
        this.payTime = payTime;
    }

    public Integer getHour() {
        return hour;
    }

    public void setHour(Integer hour) {
        this.hour = hour;
    }

    public Integer getSurplusHour() {
        return surplusHour;
    }

    public void setSurplusHour(Integer surplusHour) {
        this.surplusHour = surplusHour;
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
        return "Apply_payVo{" +
                "id=" + id +
                ", student=" + student +
                ", course=" + course +
                ", payStudent='" + payStudent + '\'' +
                ", payAmount='" + payAmount + '\'' +
                ", payTime='" + payTime + '\'' +
                ", hour=" + hour +
                ", surplusHour=" + surplusHour +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}
