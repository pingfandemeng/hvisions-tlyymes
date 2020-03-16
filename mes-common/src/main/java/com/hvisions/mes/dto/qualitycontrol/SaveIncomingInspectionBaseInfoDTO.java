package com.hvisions.mes.dto.qualitycontrol;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * Description:
 * Author:   ljj3hao
 * Time:     2019/10/18
 * Version:  1.0.0
 */
@Data
@ApiModel(description = "保存货物基础信息")
public class SaveIncomingInspectionBaseInfoDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键（修改时填入）" )
    private Integer id;

    @ApiModelProperty(value = "货物id")
    private Integer cargoId;

    @ApiModelProperty(value = "货物名称")
    private String cargoName;

    @ApiModelProperty(value = "供货单位")
    private String supplier;

    @ApiModelProperty(value = "供货单位名称")
    private String supplierName;

    @ApiModelProperty(value = "产地")
    private String source;

    @ApiModelProperty(value = "生产厂家")
    private String manufacturer;

    @ApiModelProperty(value = "货物编号")
    private String cargoNumber;

    @ApiModelProperty(value = "货物规格")
    private String cargoSpec;

    @ApiModelProperty(value = "供方批号")
    private String supplierBatchNumber;

    @ApiModelProperty(value = "生产日期（开始日期）")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date prodDateStart;

    @ApiModelProperty(value = "生产日期（结束日期）")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date prodDateEnd;

    @ApiModelProperty(value = "有效期")
    private String periodOfValidity;

    @ApiModelProperty(value = "到货日期")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date arrivalDate;

    @ApiModelProperty(value = "货物批号")
    private String cargoBatchNumber;

    @ApiModelProperty(value = "批量")
    private Integer batch;

    @ApiModelProperty(value = "是否合格供应商（0否，1是）")
    private Integer isQualifiedSupplier;

    @ApiModelProperty(value = "查看供方COA信息与包装信息是否一致（0否，1是）")
    private Integer isCoaAndInfo;

    @ApiModelProperty(value = "创建人")
    private Integer creatorId;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    @ApiModelProperty(value = "修改人")
    private Integer updaterId;

    @ApiModelProperty(value = "修改时间")
    private Date updateTime;

    @ApiModelProperty(value = "是否删除（0否，1是）" )
    private Integer isDel;

    @ApiModelProperty(value = "是否删除（0新建基础信息，1车辆检验 2取样检验 3确认检验 4确认放行" )
    private Integer state;

}
