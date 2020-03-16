package com.hvisions.mes.postleak.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 漏点问题处理记录
 */
public class PostLeakInfoLog implements Serializable {

    /**
     * 主键
     */
    private Integer id;

    /**
     * 处理责任人
     */
    private Integer disposeUserId;

    /**
     * 完成时间
     */
    private Date doneDate;

    /**
     * 完成情况
     */
    private String doneCase;

    /**
     * 备注
     */
    private String backup;

    /**
     * 岗位漏点id
     */
    private Integer postLeakInfoId;

    /**
     * 创建人
     */
    private Integer creatorId;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新人
     */
    private Integer updaterId;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 是否删除（0否，1是）
     */
    private Integer isDel;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDisposeUserId() {
        return disposeUserId;
    }

    public void setDisposeUserId(Integer disposeUserId) {
        this.disposeUserId = disposeUserId;
    }

    public Date getDoneDate() {
        return doneDate;
    }

    public void setDoneDate(Date doneDate) {
        this.doneDate = doneDate;
    }

    public String getDoneCase() {
        return doneCase;
    }

    public void setDoneCase(String doneCase) {
        this.doneCase = doneCase == null ? null : doneCase.trim();
    }

    public String getBackup() {
        return backup;
    }

    public void setBackup(String backup) {
        this.backup = backup == null ? null : backup.trim();
    }

    public Integer getPostLeakInfoId() {
        return postLeakInfoId;
    }

    public void setPostLeakInfoId(Integer postLeakInfoId) {
        this.postLeakInfoId = postLeakInfoId;
    }

    public Integer getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(Integer creatorId) {
        this.creatorId = creatorId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getUpdaterId() {
        return updaterId;
    }

    public void setUpdaterId(Integer updaterId) {
        this.updaterId = updaterId;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getIsDel() {
        return isDel;
    }

    public void setIsDel(Integer isDel) {
        this.isDel = isDel;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", disposeUserId=").append(disposeUserId);
        sb.append(", doneDate=").append(doneDate);
        sb.append(", doneCase=").append(doneCase);
        sb.append(", backup=").append(backup);
        sb.append(", postLeakInfoId=").append(postLeakInfoId);
        sb.append(", creatorId=").append(creatorId);
        sb.append(", createTime=").append(createTime);
        sb.append(", updaterId=").append(updaterId);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", isDel=").append(isDel);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}