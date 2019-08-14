package com.cims.vo;

import com.cims.entity.Apply_pay;
import com.cims.entity.Attendance_status;
import com.cims.entity.Student;
import com.cims.entity.Teacher;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class AttendanceDetailsVo {
    private Integer id;

    private Attendance_status attendance_status;

    private Apply_pay apply_pay;

    private String courseName;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date attendanceTime;

    private Integer state;

    private Integer teacherState;

    private Integer studentState;

    private Date createTime;

    private Date updateTime;

    private Teacher teacher;

    private Student student;

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

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
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
        return teacherState;
    }

    public void setTeacherState(Integer teacherState) {
        this.teacherState = teacherState;
    }

    public Integer getStudentState() {
        return studentState;
    }

    public void setStudentState(Integer studentState) {
        this.studentState = studentState;
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

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @Override
    public String toString() {
        return "AttendanceDetailsVo{" +
                "id=" + id +
                ", attendance_status=" + attendance_status +
                ", apply_pay=" + apply_pay +
                ", courseName='" + courseName + '\'' +
                ", attendanceTime=" + attendanceTime +
                ", state=" + state +
                ", teacherState=" + teacherState +
                ", studentState=" + studentState +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", teacher=" + teacher +
                ", student=" + student +
                '}';
    }
}
