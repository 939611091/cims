package com.cims.entity;

import java.util.Date;

public class Student {
    private Integer studentId;

    private String username;

    private String password;

    private String name;

    private String pPhone;

    private String pName;

    private String school;

    private Date createTime;

    private Date updateTime;

    public Student(Integer studentId, String username, String password, String name, String pPhone, String pName, String school, Date createTime, Date updateTime) {
        this.studentId = studentId;
        this.username = username;
        this.password = password;
        this.name = name;
        this.pPhone = pPhone;
        this.pName = pName;
        this.school = school;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public Student() {
        super();
    }

    public Integer getstudentId() {
        return studentId;
    }

    public void setstudentId(Integer studentId) {
        this.studentId = studentId;
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

    public String getpPhone() {
        return pPhone;
    }

    public void setpPhone(String pPhone) {
        this.pPhone = pPhone == null ? null : pPhone.trim();
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName == null ? null : pName.trim();
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school == null ? null : school.trim();
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
        sb.append(", studentId=").append(studentId);
        sb.append(", username=").append(username);
        sb.append(", password=").append(password);
        sb.append(", name=").append(name);
        sb.append(", pPhone=").append(pPhone);
        sb.append(", pName=").append(pName);
        sb.append(", school=").append(school);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append("]");
        return sb.toString();
    }
}