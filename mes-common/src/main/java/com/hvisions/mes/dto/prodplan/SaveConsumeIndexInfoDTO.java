package com.hvisions.mes.dto.prodplan;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @description: 保存消耗指标信息
 * @author: Bruce
 * @version:
 * @date: 2019-09-17 15:20
 */
@Data
@ApiModel(description = "保存消耗指标信息")
public class SaveConsumeIndexInfoDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "类型id（修改时填入）", example = "0" )
    private Integer typeId;

    @ApiModelProperty(value = "年月", required = true)
    private String date;

    @ApiModelProperty(value = "类型名称（能源，物料）", required = true)
    private String typeName;

    @ApiModelProperty(value = "产线（山梨醇，海藻糖）", required = true)
    private String prodLine;

    @ApiModelProperty(value = "消耗指标id（修改时填入）", example = "0")
    private Integer indexId;

    @ApiModelProperty(value = "指标名称", required = true)
    private String indexKey;

    @ApiModelProperty(value = "指标值", required = true)
    private BigDecimal indexValue;

    @ApiModelProperty(value = "单位", required = true)
    private String spec;

}
