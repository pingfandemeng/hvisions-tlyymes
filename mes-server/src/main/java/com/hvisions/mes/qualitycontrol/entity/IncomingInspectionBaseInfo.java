package com.hvisions.mes.qualitycontrol.entity;

import java.io.Serializable;
import java.util.Date;

public class IncomingInspectionBaseInfo implements Serializable {
    private Integer id;

    private Integer cargoId;

    private String cargoName;

    private String supplier;

    private String source;

    private String manufacturer;

    private String cargoNumber;

    private String cargoSpec;

    private String supplierBatchNumber;

    private Date prodDateStart;

    private Date prodDateEnd;

    private String periodOfValidity;

    private Date arrivalDate;

    private String cargoBatchNumber;

    private Integer batch;

    private Integer isQualifiedSupplier;

    private Integer isCoaAndInfo;

    private Integer creatorId;

    private Date createTime;

    private Integer updaterId;

    private Date updateTime;

    private Integer state;

    private Integer isDel;

    private String supplierName;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCargoName() {
        return cargoName;
    }

    public void setCargoName(String cargoName) {
        this.cargoName = cargoName == null ? null : cargoName.trim();
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier == null ? null : supplier.trim();
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source == null ? null : source.trim();
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer == null ? null : manufacturer.trim();
    }

    public String getCargoNumber() {
        return cargoNumber;
    }

    public void setCargoNumber(String cargoNumber) {
        this.cargoNumber = cargoNumber == null ? null : cargoNumber.trim();
    }

    public String getCargoSpec() {
        return cargoSpec;
    }

    public void setCargoSpec(String cargoSpec) {
        this.cargoSpec = cargoSpec == null ? null : cargoSpec.trim();
    }

    public String getSupplierBatchNumber() {
        return supplierBatchNumber;
    }

    public void setSupplierBatchNumber(String supplierBatchNumber) {
        this.supplierBatchNumber = supplierBatchNumber == null ? null : supplierBatchNumber.trim();
    }

    public Date getProdDateStart() {
        return prodDateStart;
    }

    public void setProdDateStart(Date prodDateStart) {
        this.prodDateStart = prodDateStart;
    }

    public Date getProdDateEnd() {
        return prodDateEnd;
    }

    public void setProdDateEnd(Date prodDateEnd) {
        this.prodDateEnd = prodDateEnd;
    }

    public String getPeriodOfValidity() {
        return periodOfValidity;
    }

    public void setPeriodOfValidity(String periodOfValidity) {
        this.periodOfValidity = periodOfValidity == null ? null : periodOfValidity.trim();
    }

    public Date getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(Date arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public String getCargoBatchNumber() {
        return cargoBatchNumber;
    }

    public void setCargoBatchNumber(String cargoBatchNumber) {
        this.cargoBatchNumber = cargoBatchNumber == null ? null : cargoBatchNumber.trim();
    }

    public Integer getBatch() {
        return batch;
    }

    public void setBatch(Integer batch) {
        this.batch = batch;
    }

    public Integer getIsQualifiedSupplier() {
        return isQualifiedSupplier;
    }

    public void setIsQualifiedSupplier(Integer isQualifiedSupplier) {
        this.isQualifiedSupplier = isQualifiedSupplier;
    }

    public Integer getIsCoaAndInfo() {
        return isCoaAndInfo;
    }

    public void setIsCoaAndInfo(Integer isCoaAndInfo) {
        this.isCoaAndInfo = isCoaAndInfo;
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
        sb.append(", cargoName=").append(cargoName);
        sb.append(", supplier=").append(supplier);
        sb.append(", source=").append(source);
        sb.append(", manufacturer=").append(manufacturer);
        sb.append(", cargoNumber=").append(cargoNumber);
        sb.append(", cargoSpec=").append(cargoSpec);
        sb.append(", supplierBatchNumber=").append(supplierBatchNumber);
        sb.append(", prodDateStart=").append(prodDateStart);
        sb.append(", prodDateEnd=").append(prodDateEnd);
        sb.append(", periodOfValidity=").append(periodOfValidity);
        sb.append(", arrivalDate=").append(arrivalDate);
        sb.append(", cargoBatchNumber=").append(cargoBatchNumber);
        sb.append(", batch=").append(batch);
        sb.append(", isQualifiedSupplier=").append(isQualifiedSupplier);
        sb.append(", isCoaAndInfo=").append(isCoaAndInfo);
        sb.append(", creatorId=").append(creatorId);
        sb.append(", createTime=").append(createTime);
        sb.append(", updaterId=").append(updaterId);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", isDel=").append(isDel);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getCargoId() {
        return cargoId;
    }

    public void setCargoId(Integer cargoId) {
        this.cargoId = cargoId;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }
}