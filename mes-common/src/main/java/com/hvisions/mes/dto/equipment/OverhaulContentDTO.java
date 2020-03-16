package com.hvisions.mes.dto.equipment;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @description: 检修内容
 * @author: Bruce
 * @version:
 * @date: 2020-01-16 18:05
 */
@Data
@ApiModel(description = "检修内容")
public class OverhaulContentDTO implements Serializable {

    @ApiModelProperty(value = "设备检修id" )
    private Integer id;

    @ApiModelProperty(value = "检修内容" )
    private String content;
}
