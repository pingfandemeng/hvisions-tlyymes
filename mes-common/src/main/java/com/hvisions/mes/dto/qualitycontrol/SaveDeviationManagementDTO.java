package com.hvisions.mes.dto.qualitycontrol;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @Author: Lau
 * @Description:保存偏差管理信息
 * @Date: Created in 15:27 2020/1/6
 * @Modified By:
 */
@Data
@ApiModel(description = "保存偏差管理信息")
public class SaveDeviationManagementDTO implements Serializable{

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键（修改时填入）", example = "0" )
    private Integer id;

    /**
     * 工单号
     */
    @ApiModelProperty(value = "工单号(仅保存时键入)")
    private String workOrderNum;

    /**
     * 生产批支号
     */
    @ApiModelProperty(value = "生产批支号(仅保存时键入)")
    private String productionBatchNum;

    /**
     * 产线
     */
    @ApiModelProperty(value = "产线(仅保存时键入)")
    private String productionLine;

    /**
     * 工段
     */
    @ApiModelProperty(value = "工段(仅保存时键入)")
    private String workshopSection;

    /**
     * 异常点编码
     */
    @ApiModelProperty(value = "异常点编码(仅保存时键入)")
    private String outlierCoding;

    /**
     * 异常点名称
     */
    @ApiModelProperty(value = "异常点名称(仅保存时键入)")
    private String exceptionName;

    /**
     * 实际值
     */
    @ApiModelProperty(value = "实际值(仅保存时键入)")
    private BigDecimal actualValue;

    /**
     * 下限值
     */
    @ApiModelProperty(value = "下限值(仅保存时键入)")
    private BigDecimal lowerValue;

    /**
     * 上限值
     */
    @ApiModelProperty(value = "上限值(仅保存时键入)")
    private BigDecimal upperValue;

    /**
     * 状态码
     */
    @ApiModelProperty(value = "状态码(0.新建(不需要传值)  1.已上报(上报时键入)  2.已复核(复核时键入) 3.已完成)")
    private Integer status;

    /**
     * 备注
     */
    @ApiModelProperty(value = "备注(完成时填写)")
    private String remark;

    /**
     * 偏差原因
     */
    @ApiModelProperty(value = "偏差原因(上报时填写)")
    private String reason;

}
