package com.hvisions.mes.stopcar.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 计划停车
 */
public class PlanStopCar implements Serializable {

    /**
     * 主键
     */
    private Integer id;

    /**
     * 车间
     */
    private Integer plant;

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
     * 设备位置
     */
    private String equipmentPosition;

    /**
     * 计划停车日期
     */
    private Date planStopDate;

    /**
     * 停车时长（天）
     */
    private Integer stopLength;

    /**
     * 停车提醒日期
     */
    private Date stopRemindDate;

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

    public Integer getPlant() {
        return plant;
    }

    public void setPlant(Integer plant) {
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

    public String getEquipmentPosition() {
        return equipmentPosition;
    }

    public void setEquipmentPosition(String equipmentPosition) {
        this.equipmentPosition = equipmentPosition == null ? null : equipmentPosition.trim();
    }

    public Date getPlanStopDate() {
        return planStopDate;
    }

    public void setPlanStopDate(Date planStopDate) {
        this.planStopDate = planStopDate;
    }

    public Integer getStopLength() {
        return stopLength;
    }

    public void setStopLength(Integer stopLength) {
        this.stopLength = stopLength;
    }

    public Date getStopRemindDate() {
        return stopRemindDate;
    }

    public void setStopRemindDate(Date stopRemindDate) {
        this.stopRemindDate = stopRemindDate;
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
        sb.append(", equipmentPosition=").append(equipmentPosition);
        sb.append(", planStopDate=").append(planStopDate);
        sb.append(", stopLength=").append(stopLength);
        sb.append(", stopRemindDate=").append(stopRemindDate);
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