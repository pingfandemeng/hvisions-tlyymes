package com.hvisions.mes.dto.equipment;

import com.hvisions.common.dto.PageInfo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @description: 设备检修查询
 * @author: Bruce
 * @version:
 * @date: 2020-01-20 10:13
 */
@Data
@ApiModel(description = "设备检修查询")
public class OverhaulLogParamsDTO extends PageInfo implements Serializable {

    @ApiModelProperty(value = "设备检修id" )
    private Integer equipmentId;
}
