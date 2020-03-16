package com.hvisions.mes.dto.dyb;

import com.hvisions.common.dto.PageInfo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @description: 电仪表校验记录条件
 * @author: Bruce
 * @version:
 * @date: 2019-11-25 17:39
 */
@Data
@ApiModel(description = "电仪表校验记录条件")
public class DybCheckLogParmDTO extends PageInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "电仪表id" )
    private Integer dybId;
}
