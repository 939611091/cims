package com.cims.entity;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Apply_pay {
    private Integer id;

    private Integer studentId;

    private Integer courseId;

    private String payStudent;

    private String payAmount;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date payTime;

    private Integer hour;

    private Integer surplusHour;

    private Date createTime;

    private Date updateTime;

    public Apply_pay(Integer id, Integer studentId, Integer courseId, String payStudent, String payAmount, Date payTime, Integer hour, Integer surplusHour, Date createTime, Date updateTime) {
        this.id = id;
        this.studentId = studentId;
        this.courseId = courseId;
        this.payStudent = payStudent;
        this.payAmount = payAmount;
        this.payTime = payTime;
        this.hour = hour;
        this.surplusHour = surplusHour;
        this.createTime = createTime;
        this.updateTime = updateTime;
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

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
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
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", studentId=").append(studentId);
        sb.append(", courseId=").append(courseId);
        sb.append(", payStudent=").append(payStudent);
        sb.append(", payAmount=").append(payAmount);
        sb.append(", payTime=").append(payTime);
        sb.append(", hour=").append(hour);
        sb.append(", surplusHour=").append(surplusHour);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append("]");
        return sb.toString();
    }
}