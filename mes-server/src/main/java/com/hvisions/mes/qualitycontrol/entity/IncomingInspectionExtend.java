package com.hvisions.mes.qualitycontrol.entity;

import java.io.Serializable;

public class IncomingInspectionExtend implements Serializable {
    private Integer id;

    private Integer baseInfoId;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getBaseInfoId() {
        return baseInfoId;
    }

    public void setBaseInfoId(Integer baseInfoId) {
        this.baseInfoId = baseInfoId;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", baseInfoId=").append(baseInfoId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}