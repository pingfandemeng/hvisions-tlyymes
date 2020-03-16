package com.hvisions.mes.dyb.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 电仪表校验记录
 */
public class DybCheckLog implements Serializable {

    /**
     * 主键
     */
    private Integer id;

    /**
     * 电仪表校验id
     */
    private Integer dybCheckId;

    /**
     * 预计校验时间
     */
    private Date plantCheckTime;

    /**
     * 实际校验时间
     */
    private Date realityCheckTime;

    /**
     * 校验结果
     */
    private String checkResult;

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

    public String getCheckResult() {
        return checkResult;
    }

    public void setCheckResult(String checkResult) {
        this.checkResult = checkResult;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDybCheckId() {
        return dybCheckId;
    }

    public void setDybCheckId(Integer dybCheckId) {
        this.dybCheckId = dybCheckId;
    }

    public Date getPlantCheckTime() {
        return plantCheckTime;
    }

    public void setPlantCheckTime(Date plantCheckTime) {
        this.plantCheckTime = plantCheckTime;
    }

    public Date getRealityCheckTime() {
        return realityCheckTime;
    }

    public void setRealityCheckTime(Date realityCheckTime) {
        this.realityCheckTime = realityCheckTime;
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
        sb.append(", dybCheckId=").append(dybCheckId);
        sb.append(", plantCheckTime=").append(plantCheckTime);
        sb.append(", realityCheckTime=").append(realityCheckTime);
        sb.append(", checkResult=").append(checkResult);
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