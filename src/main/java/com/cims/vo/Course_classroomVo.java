package com.cims.vo;

import com.cims.entity.Classroom;
import com.cims.entity.Course;

import java.util.Date;

public class Course_classroomVo {
    private Course course;

    private Classroom classroom;

    private Date createTime;

    private Date updateTime;

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Classroom getClassroom() {
        return classroom;
    }

    public void setClassroom(Classroom classroom) {
        this.classroom = classroom;
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
        return "Course_classroomVo{" +
                "course=" + course +
                ", classroom=" + classroom +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}
