package com.hvisions.mes.prodplan.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 消耗指标
 */
public class Tindex implements Serializable {

    /**
     * 主键
     */
    private Integer id;

    /**
     * 指标名称
     */
    private String indexKey;

    /**
     * 指标值
     */
    private BigDecimal indexValue;

    /**
     * 规格
     */
    private String spec;

    /**
     * 类型id
     */
    private Integer typeId;

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

    public String getIndexKey() {
        return indexKey;
    }

    public void setIndexKey(String indexKey) {
        this.indexKey = indexKey == null ? null : indexKey.trim();
    }

    public BigDecimal getIndexValue() {
        return indexValue;
    }

    public void setIndexValue(BigDecimal indexValue) {
        this.indexValue = indexValue;
    }

    public String getSpec() {
        return spec;
    }

    public void setSpec(String spec) {
        this.spec = spec == null ? null : spec.trim();
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
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
        sb.append(", indexKey=").append(indexKey);
        sb.append(", indexValue=").append(indexValue);
        sb.append(", spec=").append(spec);
        sb.append(", typeId=").append(typeId);
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