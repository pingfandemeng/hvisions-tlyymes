package com.hvisions.mes.equipment.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 设备检修记录
 */
public class EquipmentOverhaulLog implements Serializable {

    /**
     * 主键
     */
    private Integer id;

    /**
     * 设备检修id
     */
    private Integer equipmentOverhaulId;

    /**
     * 检修开始时间
     */
    private Date overhaulStartTime;

    /**
     * 检修内容
     */
    private String overhaulContent;

    /**
     * 检修完成时间
     */
    private Date overhaulEndTime;

    /**
     * 检修人员
     */
    private Integer overhaulUserId;

    /**
     * 检修费用
     */
    private BigDecimal overhaulAmount;

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

    public Date getOverhaulStartTime() {
        return overhaulStartTime;
    }

    public void setOverhaulStartTime(Date overhaulStartTime) {
        this.overhaulStartTime = overhaulStartTime;
    }

    public String getOverhaulContent() {
        return overhaulContent;
    }

    public void setOverhaulContent(String overhaulContent) {
        this.overhaulContent = overhaulContent == null ? null : overhaulContent.trim();
    }

    public Date getOverhaulEndTime() {
        return overhaulEndTime;
    }

    public void setOverhaulEndTime(Date overhaulEndTime) {
        this.overhaulEndTime = overhaulEndTime;
    }

    public Integer getOverhaulUserId() {
        return overhaulUserId;
    }

    public void setOverhaulUserId(Integer overhaulUserId) {
        this.overhaulUserId = overhaulUserId;
    }

    public BigDecimal getOverhaulAmount() {
        return overhaulAmount;
    }

    public void setOverhaulAmount(BigDecimal overhaulAmount) {
        this.overhaulAmount = overhaulAmount;
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
        sb.append(", overhaulStartTime=").append(overhaulStartTime);
        sb.append(", overhaulContent=").append(overhaulContent);
        sb.append(", overhaulEndTime=").append(overhaulEndTime);
        sb.append(", overhaulUserId=").append(overhaulUserId);
        sb.append(", overhaulAmount=").append(overhaulAmount);
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