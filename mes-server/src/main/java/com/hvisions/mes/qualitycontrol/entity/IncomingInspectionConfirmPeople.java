package com.hvisions.mes.qualitycontrol.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 来料检验（检验确认人）
 */
public class IncomingInspectionConfirmPeople implements Serializable {

    /**
     * 主键
     */
    private Integer id;

    /**
     * 报检人
     */
    private Integer bjUserId;

    /**
     * 报检时间
     */
    private Date bjDate;

    /**
     * 接报人
     */
    private Integer jbUserId;

    /**
     * 接报时间
     */
    private Date jbDate;

    /**
     * 检测人
     */
    private Integer checkUserId;

    /**
     * 检测时间
     */
    private Date checkUserDate;

    /**
     * 复核人
     */
    private Integer reviewUserId;

    /**
     * 复核时间
     */
    private Date reviewDate;

    /**
     * 放行人
     */
    private Integer fxUserId;

    /**
     * 放行时间
     */
    private Date fxDate;

    /**
     * 放行结论（0否，1是）
     */
    private Integer fxResult;

    /**
     * 来料检验结论
     */
    private String result;

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

    public Integer getBjUserId() {
        return bjUserId;
    }

    public void setBjUserId(Integer bjUserId) {
        this.bjUserId = bjUserId;
    }

    public Date getBjDate() {
        return bjDate;
    }

    public void setBjDate(Date bjDate) {
        this.bjDate = bjDate;
    }

    public Integer getJbUserId() {
        return jbUserId;
    }

    public void setJbUserId(Integer jbUserId) {
        this.jbUserId = jbUserId;
    }

    public Date getJbDate() {
        return jbDate;
    }

    public void setJbDate(Date jbDate) {
        this.jbDate = jbDate;
    }

    public Integer getCheckUserId() {
        return checkUserId;
    }

    public void setCheckUserId(Integer checkUserId) {
        this.checkUserId = checkUserId;
    }

    public Date getCheckUserDate() {
        return checkUserDate;
    }

    public void setCheckUserDate(Date checkUserDate) {
        this.checkUserDate = checkUserDate;
    }

    public Integer getReviewUserId() {
        return reviewUserId;
    }

    public void setReviewUserId(Integer reviewUserId) {
        this.reviewUserId = reviewUserId;
    }

    public Date getReviewDate() {
        return reviewDate;
    }

    public void setReviewDate(Date reviewDate) {
        this.reviewDate = reviewDate;
    }

    public Integer getFxUserId() {
        return fxUserId;
    }

    public void setFxUserId(Integer fxUserId) {
        this.fxUserId = fxUserId;
    }

    public Date getFxDate() {
        return fxDate;
    }

    public void setFxDate(Date fxDate) {
        this.fxDate = fxDate;
    }

    public Integer getFxResult() {
        return fxResult;
    }

    public void setFxResult(Integer fxResult) {
        this.fxResult = fxResult;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result == null ? null : result.trim();
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
        sb.append(", bjUserId=").append(bjUserId);
        sb.append(", bjDate=").append(bjDate);
        sb.append(", jbUserId=").append(jbUserId);
        sb.append(", jbDate=").append(jbDate);
        sb.append(", checkUserId=").append(checkUserId);
        sb.append(", checkUserDate=").append(checkUserDate);
        sb.append(", reviewUserId=").append(reviewUserId);
        sb.append(", reviewDate=").append(reviewDate);
        sb.append(", fxUserId=").append(fxUserId);
        sb.append(", fxDate=").append(fxDate);
        sb.append(", fxResult=").append(fxResult);
        sb.append(", result=").append(result);
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