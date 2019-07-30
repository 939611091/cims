package com.cims.entity;

import java.util.Date;

public class Course_classroom {
    private Integer courseId;

    private Integer classroomId;

    private Date createTime;

    private Date updateTime;

    public Course_classroom(Integer courseId, Integer classroomId, Date createTime, Date updateTime) {
        this.courseId = courseId;
        this.classroomId = classroomId;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public Course_classroom() {
        super();
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public Integer getClassroomId() {
        return classroomId;
    }

    public void setClassroomId(Integer classroomId) {
        this.classroomId = classroomId;
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
        sb.append(", courseId=").append(courseId);
        sb.append(", classroomId=").append(classroomId);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append("]");
        return sb.toString();
    }
}