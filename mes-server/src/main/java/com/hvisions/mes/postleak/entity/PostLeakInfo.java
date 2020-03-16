package com.hvisions.mes.postleak.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 岗位漏点信息
 */
public class PostLeakInfo implements Serializable {

    /**
     * 主键
     */
    private Integer id;

    /**
     * 漏点编号
     */
    private String leakNum;

    /**
     * 车间
     */
    private String plant;

    /**
     * 工段
     */
    private String section;

    /**
     * 发现人
     */
    private Integer findUserId;

    /**
     * 发现时间
     */
    private Date findDate;

    /**
     * 位置
     */
    private String position;

    /**
     * 工艺介质
     */
    private String medium;

    /**
     * 漏点描述
     */
    private String leakDescription;

    /**
     * 泄漏类型
     */
    private String leakType;

    /**
     * 计划处理措施
     */
    private String planMeasure;

    /**
     * 计划处理时间
     */
    private Date planDate;

    /**
     * 复核人
     */
    private Integer reviewUserId;

    /**
     * 复核时间
     */
    private Date reviewDate;

    /**
     * 创建人
     */
    private Integer creatorId;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新人
     */
    private Integer updaterId;

    /**
     * 更新时间
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

    public String getLeakNum() {
        return leakNum;
    }

    public void setLeakNum(String leakNum) {
        this.leakNum = leakNum == null ? null : leakNum.trim();
    }

    public String getPlant() {
        return plant;
    }

    public void setPlant(String plant) {
        this.plant = plant == null ? null : plant.trim();
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section == null ? null : section.trim();
    }

    public Integer getFindUserId() {
        return findUserId;
    }

    public void setFindUserId(Integer findUserId) {
        this.findUserId = findUserId;
    }

    public Date getFindDate() {
        return findDate;
    }

    public void setFindDate(Date findDate) {
        this.findDate = findDate;
    }

    public String getPostion() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position == null ? null : position.trim();
    }

    public String getMedium() {
        return medium;
    }

    public void setMedium(String medium) {
        this.medium = medium == null ? null : medium.trim();
    }

    public String getLeakDescription() {
        return leakDescription;
    }

    public void setLeakDescription(String leakDescription) {
        this.leakDescription = leakDescription == null ? null : leakDescription.trim();
    }

    public String getLeakType() {
        return leakType;
    }

    public void setLeakType(String leakType) {
        this.leakType = leakType == null ? null : leakType.trim();
    }

    public String getPlanMeasure() {
        return planMeasure;
    }

    public void setPlanMeasure(String planMeasure) {
        this.planMeasure = planMeasure == null ? null : planMeasure.trim();
    }

    public Date getPlanDate() {
        return planDate;
    }

    public void setPlanDate(Date planDate) {
        this.planDate = planDate;
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
        sb.append(", leakNum=").append(leakNum);
        sb.append(", plant=").append(plant);
        sb.append(", section=").append(section);
        sb.append(", findUserId=").append(findUserId);
        sb.append(", findDate=").append(findDate);
        sb.append(", position=").append(position);
        sb.append(", medium=").append(medium);
        sb.append(", leakDescription=").append(leakDescription);
        sb.append(", leakType=").append(leakType);
        sb.append(", planMeasure=").append(planMeasure);
        sb.append(", planDate=").append(planDate);
        sb.append(", reviewUserId=").append(reviewUserId);
        sb.append(", reviewDate=").append(reviewDate);
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