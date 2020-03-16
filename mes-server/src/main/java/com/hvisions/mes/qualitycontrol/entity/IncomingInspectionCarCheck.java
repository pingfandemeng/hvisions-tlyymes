package com.hvisions.mes.qualitycontrol.entity;

import java.io.Serializable;
import java.util.Date;

public class IncomingInspectionCarCheck implements Serializable {
    private Integer id;

    private Integer healthStatus;

    private Integer insectAttackStatus;

    private Integer safeguardProceduresStatus;

    private Integer shareCarStatus;

    private Integer polluteStatus;

    private Integer isInfoAndNotice;

    private Integer isPackStandard;

    private Integer isLabelContentOk;

    private String other;

    private Integer checkUserId;

    private Integer baseInfoId;

    private Integer creatorId;

    private Date createTime;

    private Integer updaterId;

    private Date updateTime;

    private Integer isDel;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getHealthStatus() {
        return healthStatus;
    }

    public void setHealthStatus(Integer healthStatus) {
        this.healthStatus = healthStatus;
    }

    public Integer getInsectAttackStatus() {
        return insectAttackStatus;
    }

    public void setInsectAttackStatus(Integer insectAttackStatus) {
        this.insectAttackStatus = insectAttackStatus;
    }

    public Integer getSafeguardProceduresStatus() {
        return safeguardProceduresStatus;
    }

    public void setSafeguardProceduresStatus(Integer safeguardProceduresStatus) {
        this.safeguardProceduresStatus = safeguardProceduresStatus;
    }

    public Integer getShareCarStatus() {
        return shareCarStatus;
    }

    public void setShareCarStatus(Integer shareCarStatus) {
        this.shareCarStatus = shareCarStatus;
    }

    public Integer getPolluteStatus() {
        return polluteStatus;
    }

    public void setPolluteStatus(Integer polluteStatus) {
        this.polluteStatus = polluteStatus;
    }

    public Integer getIsInfoAndNotice() {
        return isInfoAndNotice;
    }

    public void setIsInfoAndNotice(Integer isInfoAndNotice) {
        this.isInfoAndNotice = isInfoAndNotice;
    }

    public Integer getIsPackStandard() {
        return isPackStandard;
    }

    public void setIsPackStandard(Integer isPackStandard) {
        this.isPackStandard = isPackStandard;
    }

    public Integer getIsLabelContentOk() {
        return isLabelContentOk;
    }

    public void setIsLabelContentOk(Integer isLabelContentOk) {
        this.isLabelContentOk = isLabelContentOk;
    }

    public String getOther() {
        return other;
    }

    public void setOther(String other) {
        this.other = other == null ? null : other.trim();
    }

    public Integer getCheckUserId() {
        return checkUserId;
    }

    public void setCheckUserId(Integer checkUserId) {
        this.checkUserId = checkUserId;
    }

    public Integer getBaseInfoId() {
        return baseInfoId;
    }

    public void setBaseInfoId(Integer baseInfoId) {
        this.baseInfoId = baseInfoId;
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
        sb.append(", healthStatus=").append(healthStatus);
        sb.append(", insectAttackStatus=").append(insectAttackStatus);
        sb.append(", safeguardProceduresStatus=").append(safeguardProceduresStatus);
        sb.append(", shareCarStatus=").append(shareCarStatus);
        sb.append(", polluteStatus=").append(polluteStatus);
        sb.append(", isInfoAndNotice=").append(isInfoAndNotice);
        sb.append(", isPackStandard=").append(isPackStandard);
        sb.append(", isLabelContentOk=").append(isLabelContentOk);
        sb.append(", other=").append(other);
        sb.append(", checkUserId=").append(checkUserId);
        sb.append(", baseInfoId=").append(baseInfoId);
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