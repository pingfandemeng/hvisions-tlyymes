package com.hvisions.mes.qualitycontrol.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 来料检验（检测项目）
 */
public class IncomingInspectionSampleCheckItem implements Serializable {

    /**
     * 主键
     */
    private Integer id;

    /**
     * 检测项目id
     */
    private Integer checkItemId;

    /**
     * 检测类型
     */
    private String checkType;

    /**
     * 检测项目
     */
    private String checkItem;

    /**
     * 检测实际结果
     */
    private String checkActualResult;

    /**
     * 检测结果判定
     */
    private String checkResultConfirm;

    /**
     * 取样检测人
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

    public String getCheckType() {
        return checkType;
    }

    public void setCheckType(String checkType) {
        this.checkType = checkType;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCheckItemId() {
        return checkItemId;
    }

    public void setCheckItemId(Integer checkItemId) {
        this.checkItemId = checkItemId;
    }

    public String getCheckItem() {
        return checkItem;
    }

    public void setCheckItem(String checkItem) {
        this.checkItem = checkItem == null ? null : checkItem.trim();
    }

    public String getCheckActualResult() {
        return checkActualResult;
    }

    public void setCheckActualResult(String checkActualResult) {
        this.checkActualResult = checkActualResult == null ? null : checkActualResult.trim();
    }

    public String getCheckResultConfirm() {
        return checkResultConfirm;
    }

    public void setCheckResultConfirm(String checkResultConfirm) {
        this.checkResultConfirm = checkResultConfirm == null ? null : checkResultConfirm.trim();
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
        sb.append(", checkItemId=").append(checkItemId);
        sb.append(", checkType=").append(checkType);
        sb.append(", checkItem=").append(checkItem);
        sb.append(", checkActualResult=").append(checkActualResult);
        sb.append(", checkResultConfirm=").append(checkResultConfirm);
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