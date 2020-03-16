package com.hvisions.mes.equipment.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 设备检修计划
 */
public class EquipmentOverhaulPostpone implements Serializable {

    /**
     * 主键
     */
    private Integer id;

    /**
     * 设备检修id
     */
    private Integer equipmentOverhaulId;

    /**
     * 检修延后日期
     */
    private Date postponeDate;

    /**
     * 延期备注
     */
    private String postponeBackup;

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
     * 是否删除（1是，0否）
     */
    private Integer isDel;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getEquipmentOverhaulId() {
        return equipmentOverhaulId;
    }

    public void setEquipmentOverhaulId(Integer equipmentOverhaulId) {
        this.equipmentOverhaulId = equipmentOverhaulId;
    }

    public Date getPostponeDate() {
        return postponeDate;
    }

    public void setPostponeDate(Date postponeDate) {
        this.postponeDate = postponeDate;
    }

    public String getPostponeBackup() {
        return postponeBackup;
    }

    public void setPostponeBackup(String postponeBackup) {
        this.postponeBackup = postponeBackup == null ? null : postponeBackup.trim();
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
        sb.append(", equipmentOverhaulId=").append(equipmentOverhaulId);
        sb.append(", postponeDate=").append(postponeDate);
        sb.append(", postponeBackup=").append(postponeBackup);
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