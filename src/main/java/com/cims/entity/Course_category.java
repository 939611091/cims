package com.cims.entity;

import java.util.Date;

public class Course_category {
    private Integer id;

    private String categoryName;

    private Date createTime;

    private Date updateTime;

    public Course_category(Integer id, String categoryName, Date createTime, Date updateTime) {
        this.id = id;
        this.categoryName = categoryName;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public Course_category() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getcategoryName() {
        return categoryName;
    }

    public void setcategoryName(String categoryName) {
        this.categoryName = categoryName == null ? null : categoryName.trim();
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
        sb.append(", categoryName=").append(categoryName);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append("]");
        return sb.toString();
    }
}