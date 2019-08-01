package com.cims.entity;

import java.util.Date;

public class Attendance {
    private Integer id;

    private Integer attendanceStatusId;

    private Integer applyPayId;

    private Date attendanceTime;

    private Integer state;

    private Integer TeacherState;

    private Date createTime;

    private Date updateTime;

    private Integer teacherId;



    public Attendance() {
        super();
    }


    public Attendance(Integer id, Integer attendanceStatusId, Integer applyPayId, Date attendanceTime, Integer state, Integer teacherState, Date createTime, Date updateTime, Integer teacherId) {
        this.id = id;
        this.attendanceStatusId = attendanceStatusId;
        this.applyPayId = applyPayId;
        this.attendanceTime = attendanceTime;
        this.state = state;
        TeacherState = teacherState;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.teacherId = teacherId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAttendanceStatusId() {
        return attendanceStatusId;
    }

    public void setAttendanceStatusId(Integer attendanceStatusId) {
        this.attendanceStatusId = attendanceStatusId;
    }

    public Integer getApplyPayId() {
        return applyPayId;
    }

    public void setApplyPayId(Integer applyPayId) {
        this.applyPayId = applyPayId;
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

    public Integer getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Integer teacherId) {
        this.teacherId = teacherId;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", attendanceStatusId=").append(attendanceStatusId);
        sb.append(", applyPayId=").append(applyPayId);
        sb.append(", attendanceTime=").append(attendanceTime);
        sb.append(", state=").append(state);
        sb.append(", TeacherState=").append(TeacherState);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", teacherId=").append(teacherId);
        sb.append("]");
        return sb.toString();
    }
}