package com.hvisions.mes.stopcar.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 计划停车审批
 */
public class PlanStopCarApprove implements Serializable {

    /**
     * 主键
     */
    private Integer id;

    /**
     * 计划停车id
     */
    private Integer planStopId;

    /**
     * 审批人
     */
    private Integer approveUserId;

    /**
     * 审批意见
     */
    private String approveIdea;

    /**
     * 审批状态
     */
    private Integer approveStatus;

    /**
     * 创建人
     */
    private Integer creatorId;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改人
     */
    private Integer updaterId;

    /**
     * 修改时间
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

    public Integer getPlanStopId() {
        return planStopId;
    }

    public void setPlanStopId(Integer planStopId) {
        this.planStopId = planStopId;
    }

    public Integer getApproveUserId() {
        return approveUserId;
    }

    public void setApproveUserId(Integer approveUserId) {
        this.approveUserId = approveUserId;
    }

    public String getApproveIdea() {
        return approveIdea;
    }

    public void setApproveIdea(String approveIdea) {
        this.approveIdea = approveIdea == null ? null : approveIdea.trim();
    }

    public Integer getApproveStatus() {
        return approveStatus;
    }

    public void setApproveStatus(Integer approveStatus) {
        this.approveStatus = approveStatus;
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
        sb.append(", planStopId=").append(planStopId);
        sb.append(", approveUserId=").append(approveUserId);
        sb.append(", approveIdea=").append(approveIdea);
        sb.append(", approveStatus=").append(approveStatus);
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