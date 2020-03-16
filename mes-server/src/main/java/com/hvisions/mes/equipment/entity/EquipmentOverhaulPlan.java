package com.hvisions.mes.equipment.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 设备检修计划
 */
public class EquipmentOverhaulPlan implements Serializable {

    /**
     * 主键
     */
    private Integer id;

    /**
     * 车间编号
     */
    private String plant;

    /**
     * 设备编号
     */
    private String equipmentNumber;

    /**
     * 设备型号
     */
    private String equipmentType;

    /**
     * 设备名称
     */
    private String equipmentName;

    /**
     * 预计检修时长（时）
     */
    private Integer overhaulTime;

    /**
     * 停机时长（时）
     */
    private Integer stopTime;

    /**
     * 周期（天）
     */
    private Integer cycle;

    /**
     * 预计检修日期
     */
    private Date overhaulDate;

    /**
     * 提前提醒天数
     */
    private Integer remindDays;

    /**
     * 实际检修日期
     */
    private Date actualDate;

    /**
     * 状态（1新建，2开始检修中，3完成检修，4延期中）
     */
    private Integer status;

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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPlant() {
        return plant;
    }

    public void setPlant(String plant) {
        this.plant = plant;
    }

    public String getEquipmentNumber() {
        return equipmentNumber;
    }

    public void setEquipmentNumber(String equipmentNumber) {
        this.equipmentNumber = equipmentNumber == null ? null : equipmentNumber.trim();
    }

    public String getEquipmentType() {
        return equipmentType;
    }

    public void setEquipmentType(String equipmentType) {
        this.equipmentType = equipmentType == null ? null : equipmentType.trim();
    }

    public String getEquipmentName() {
        return equipmentName;
    }

    public void setEquipmentName(String equipmentName) {
        this.equipmentName = equipmentName == null ? null : equipmentName.trim();
    }

    public Integer getOverhaulTime() {
        return overhaulTime;
    }

    public void setOverhaulTime(Integer overhaulTime) {
        this.overhaulTime = overhaulTime;
    }

    public Integer getStopTime() {
        return stopTime;
    }

    public void setStopTime(Integer stopTime) {
        this.stopTime = stopTime;
    }

    public Integer getCycle() {
        return cycle;
    }

    public void setCycle(Integer cycle) {
        this.cycle = cycle;
    }

    public Date getOverhaulDate() {
        return overhaulDate;
    }

    public void setOverhaulDate(Date overhaulDate) {
        this.overhaulDate = overhaulDate;
    }

    public Integer getRemindDays() {
        return remindDays;
    }

    public void setRemindDays(Integer remindDays) {
        this.remindDays = remindDays;
    }

    public Date getActualDate() {
        return actualDate;
    }

    public void setActualDate(Date actualDate) {
        this.actualDate = actualDate;
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
        sb.append(", plant=").append(plant);
        sb.append(", equipmentNumber=").append(equipmentNumber);
        sb.append(", equipmentType=").append(equipmentType);
        sb.append(", equipmentName=").append(equipmentName);
        sb.append(", overhaulTime=").append(overhaulTime);
        sb.append(", stopTime=").append(stopTime);
        sb.append(", cycle=").append(cycle);
        sb.append(", overhaulDate=").append(overhaulDate);
        sb.append(", remindDays=").append(remindDays);
        sb.append(", actualDate=").append(actualDate);
        sb.append(", status=").append(status);
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