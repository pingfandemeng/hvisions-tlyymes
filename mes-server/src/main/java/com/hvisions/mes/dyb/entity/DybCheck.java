package com.hvisions.mes.dyb.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 电仪表校验
 */
public class DybCheck implements Serializable {

    /**
     * 主键
     */
    private Integer id;

    /**
     * 电仪表名称
     */
    private Integer dybName;

    /**
     * 设备编号
     */
    private String dybNumber;

    /**
     * 校验周期
     */
    private String checkPeriod;

    /**
     * 校验方法
     */
    private String checkMethod;

    /**
     * 校验类型（1自检，2送检）
     */
    private Integer checkType;

    /**
     * 预计校验时间
     */
    private Date plantCheckTime;

    /**
     * 电仪表位置
     */
    private String dybPost;

    /**
     * 电仪表车间
     */
    private String dybPlant;

    /**
     * 备注
     */
    private String backup;

    /**
     * 状态（1新建，2校验中，3延期中，4完成校验）
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
     * 是否删除（0否，1是）
     */
    private Integer isDel;

    private static final long serialVersionUID = 1L;

    public String getDybNumber() {
        return dybNumber;
    }

    public void setDybNumber(String dybNumber) {
        this.dybNumber = dybNumber;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDybName() {
        return dybName;
    }

    public void setDybName(Integer dybName) {
        this.dybName = dybName;
    }

    public String getCheckPeriod() {
        return checkPeriod;
    }

    public void setCheckPeriod(String checkPeriod) {
        this.checkPeriod = checkPeriod == null ? null : checkPeriod.trim();
    }

    public String getCheckMethod() {
        return checkMethod;
    }

    public void setCheckMethod(String checkMethod) {
        this.checkMethod = checkMethod == null ? null : checkMethod.trim();
    }

    public Integer getCheckType() {
        return checkType;
    }

    public void setCheckType(Integer checkType) {
        this.checkType = checkType;
    }

    public Date getPlantCheckTime() {
        return plantCheckTime;
    }

    public void setPlantCheckTime(Date plantCheckTime) {
        this.plantCheckTime = plantCheckTime;
    }

    public String getDybPost() {
        return dybPost;
    }

    public void setDybPost(String dybPost) {
        this.dybPost = dybPost == null ? null : dybPost.trim();
    }

    public String getDybPlant() {
        return dybPlant;
    }

    public void setDybPlant(String dybPlant) {
        this.dybPlant = dybPlant == null ? null : dybPlant.trim();
    }

    public String getBackup() {
        return backup;
    }

    public void setBackup(String backup) {
        this.backup = backup == null ? null : backup.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
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
        sb.append(", dybName=").append(dybName);
        sb.append(", dybNumber=").append(dybNumber);
        sb.append(", checkPeriod=").append(checkPeriod);
        sb.append(", checkMethod=").append(checkMethod);
        sb.append(", checkType=").append(checkType);
        sb.append(", plantCheckTime=").append(plantCheckTime);
        sb.append(", dybPost=").append(dybPost);
        sb.append(", dybPlant=").append(dybPlant);
        sb.append(", backup=").append(backup);
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