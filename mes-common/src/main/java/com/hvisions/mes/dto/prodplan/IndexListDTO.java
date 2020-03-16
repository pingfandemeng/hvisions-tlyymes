package com.hvisions.mes.dto.prodplan;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @description: 消耗指标列表信息
 * @author: Bruce
 * @version:
 * @date: 2019-09-19 09:56
 */
@Data
@ApiModel(description = "消耗指标列表信息")
public class IndexListDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "类型id", readOnly = true, example = "0")
    private Integer typeId;

    @ApiModelProperty(value = "年份", readOnly = true)
    private String year;

    @ApiModelProperty(value = "月份", readOnly = true)
    private String month;

    @ApiModelProperty(value = "产线（山梨醇，海藻糖）", readOnly = true)
    private String prodLine;

    @ApiModelProperty(value = "产线code", readOnly = true)
    private String prodLineCode;

    @ApiModelProperty(value = "类型名称", readOnly = true)
    private String typeName;

    @ApiModelProperty(value = "消耗指标id", readOnly = true, example = "0")
    private Integer indexId;

    @ApiModelProperty(value = "消耗指标名称", readOnly = true)
    private String indexKey;

    @ApiModelProperty(value = "消耗指标code", readOnly = true)
    private String indexKeyCode;

    @ApiModelProperty(value = "消耗指标值", readOnly = true)
    private BigDecimal indexValue;

    @ApiModelProperty(value = "消耗指标规格", readOnly = true)
    private String spec;
}
