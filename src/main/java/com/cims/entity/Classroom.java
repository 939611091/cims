package com.cims.entity;

import java.util.Date;

public class Classroom {
    private Integer id;

    private String classroomName;

    private Integer capacity;

    private Date createTime;

    private Date updateTime;

    public Classroom(Integer id, String classroomName, Integer capacity, Date createTime, Date updateTime) {
        this.id = id;
        this.classroomName = classroomName;
        this.capacity = capacity;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public Classroom() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getClassroomName() {
        return classroomName;
    }

    public void setClassroomName(String classroomName) {
        this.classroomName = classroomName == null ? null : classroomName.trim();
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
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
        sb.append(", classroomName=").append(classroomName);
        sb.append(", capacity=").append(capacity);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append("]");
        return sb.toString();
    }
}