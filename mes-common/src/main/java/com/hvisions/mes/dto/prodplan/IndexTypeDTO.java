package com.hvisions.mes.dto.prodplan;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @description: 指标类型
 * @author: Bruce
 * @version:
 * @date: 2019-09-17 15:31
 */
@Data
@ApiModel(description = "指标类型")
public class IndexTypeDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "类型id", readOnly = true, example = "0")
    private Integer id;

    @ApiModelProperty(value = "类型名称（能源，物料）", readOnly = true)
    private String typeName;

    @ApiModelProperty(value = "产线（山梨醇，海藻糖）", readOnly = true)
    private String prodLine;

    @ApiModelProperty(value = "指标list", readOnly = true)
    private List<IndexInfoDTO> dtoList;
}
