package com.cims.vo;

import com.cims.entity.Apply_pay;
import com.cims.entity.Attendance_status;
import com.cims.entity.Teacher;

import java.util.Date;

public class AttendanceVo {
    private Integer id;

    private Attendance_status attendance_status;

    private Apply_pay apply_pay;

    private Date attendanceTime;

    private Integer state;

    private Integer TeacherState;

    private Date createTime;

    private Date updateTime;

    private Teacher teacher;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Attendance_status getAttendance_status() {
        return attendance_status;
    }

    public void setAttendance_status(Attendance_status attendance_status) {
        this.attendance_status = attendance_status;
    }

    public Apply_pay getApply_pay() {
        return apply_pay;
    }

    public void setApply_pay(Apply_pay apply_pay) {
        this.apply_pay = apply_pay;
    }

    public Date getAttendanceTime() {
        return attendanceTime;
    }

    public void setAttendanceTime(Date attendanceTime) {
        this.attendanceTime = attendanceTime;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getTeacherState() {
        return TeacherState;
    }

    public void setTeacherState(Integer teacherState) {
        TeacherState = teacherState;
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

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    @Override
    public String toString() {
        return "AttendanceVo{" +
                "id=" + id +
                ", attendance_status=" + attendance_status +
                ", apply_pay=" + apply_pay +
                ", attendanceTime=" + attendanceTime +
                ", state=" + state +
                ", TeacherState=" + TeacherState +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", teacher=" + teacher +
                '}';
    }
}
