package com.hvisions.mes.qualitycontrol.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 来料检验（取样检测）
 */
public class IncomingInspectionSampleCheck implements Serializable {

    /**
     * 主键
     */
    private Integer id;

    /**
     * 取样点
     */
    private String sampleAddress;

    /**
     * 取样时间
     */
    private Date sampleDate;

    /**
     * 取样件数
     */
    private Integer sampleNumber;

    /**
     * 取样量
     */
    private Integer sampleAmount;

    /**
     * 取样人
     */
    private Integer sampleUserId;

    /**
     * 报告日期
     */
    private Date reportDate;

    /**
     * 检验单号
     */
    private String checkNumbers;

    /**
     * 基础信息id
     */
    private Integer baseInfoId;

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

    public String getSampleAddress() {
        return sampleAddress;
    }

    public void setSampleAddress(String sampleAddress) {
        this.sampleAddress = sampleAddress == null ? null : sampleAddress.trim();
    }

    public Date getSampleDate() {
        return sampleDate;
    }

    public void setSampleDate(Date sampleDate) {
        this.sampleDate = sampleDate;
    }

    public Integer getSampleNumber() {
        return sampleNumber;
    }

    public void setSampleNumber(Integer sampleNumber) {
        this.sampleNumber = sampleNumber;
    }

    public Integer getSampleAmount() {
        return sampleAmount;
    }

    public void setSampleAmount(Integer sampleAmount) {
        this.sampleAmount = sampleAmount;
    }

    public Integer getSampleUserId() {
        return sampleUserId;
    }

    public void setSampleUserId(Integer sampleUserId) {
        this.sampleUserId = sampleUserId;
    }

    public Date getReportDate() {
        return reportDate;
    }

    public void setReportDate(Date reportDate) {
        this.reportDate = reportDate;
    }

    public String getCheckNumbers() {
        return checkNumbers;
    }

    public void setCheckNumbers(String checkNumbers) {
        this.checkNumbers = checkNumbers == null ? null : checkNumbers.trim();
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
        sb.append(", sampleAddress=").append(sampleAddress);
        sb.append(", sampleDate=").append(sampleDate);
        sb.append(", sampleNumber=").append(sampleNumber);
        sb.append(", sampleAmount=").append(sampleAmount);
        sb.append(", sampleUserId=").append(sampleUserId);
        sb.append(", reportDate=").append(reportDate);
        sb.append(", checkNumbers=").append(checkNumbers);
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