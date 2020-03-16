package com.hvisions.mes.qualitycontrol.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 来料检验（单件重量）
 */
public class IncomingInspectionSingleWeight implements Serializable {

    /**
     * 主键
     */
    private Integer id;

    /**
     * 共检查几件
     */
    private Integer checkCount;

    /**
     * 重量范围（最小值）
     */
    private BigDecimal weightRangeStart;

    /**
     * 重量范围（最大值）
     */
    private BigDecimal weightRangeEnd;

    /**
     * 平均重量
     */
    private BigDecimal meanWeight;

    /**
     * 重量单位
     */
    private String weightUnit;

    /**
     * 结果判断
     */
    private String resultConfirm;

    /**
     * 取样检测id
     */
    private Integer sampleCheckId;

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

    public Integer getCheckCount() {
        return checkCount;
    }

    public void setCheckCount(Integer checkCount) {
        this.checkCount = checkCount;
    }

    public BigDecimal getWeightRangeStart() {
        return weightRangeStart;
    }

    public void setWeightRangeStart(BigDecimal weightRangeStart) {
        this.weightRangeStart = weightRangeStart;
    }

    public BigDecimal getWeightRangeEnd() {
        return weightRangeEnd;
    }

    public void setWeightRangeEnd(BigDecimal weightRangeEnd) {
        this.weightRangeEnd = weightRangeEnd;
    }

    public BigDecimal getMeanWeight() {
        return meanWeight;
    }

    public void setMeanWeight(BigDecimal meanWeight) {
        this.meanWeight = meanWeight;
    }

    public String getWeightUnit() {
        return weightUnit;
    }

    public void setWeightUnit(String weightUnit) {
        this.weightUnit = weightUnit == null ? null : weightUnit.trim();
    }

    public String getResultConfirm() {
        return resultConfirm;
    }

    public void setResultConfirm(String resultConfirm) {
        this.resultConfirm = resultConfirm == null ? null : resultConfirm.trim();
    }

    public Integer getSampleCheckId() {
        return sampleCheckId;
    }

    public void setSampleCheckId(Integer sampleCheckId) {
        this.sampleCheckId = sampleCheckId;
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
        sb.append(", checkCount=").append(checkCount);
        sb.append(", weightRangeStart=").append(weightRangeStart);
        sb.append(", weightRangeEnd=").append(weightRangeEnd);
        sb.append(", meanWeight=").append(meanWeight);
        sb.append(", weightUnit=").append(weightUnit);
        sb.append(", resultConfirm=").append(resultConfirm);
        sb.append(", sampleCheckId=").append(sampleCheckId);
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