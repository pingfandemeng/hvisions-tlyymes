package com.hvisions.mes.dto.prodplan;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @description: 指标信息
 * @author: Bruce
 * @version:
 * @date: 2019-09-17 15:35
 */
@Data
@ApiModel(description = "指标信息")
public class IndexInfoDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "指标id", readOnly = true, example = "0")
    private Integer id;

    @ApiModelProperty(value = "指标名称", readOnly = true)
    private String indexKey;

    @ApiModelProperty(value = "指标值", readOnly = true)
    private BigDecimal indexValue;

    @ApiModelProperty(value = "规格", readOnly = true)
    private String spec;

}
