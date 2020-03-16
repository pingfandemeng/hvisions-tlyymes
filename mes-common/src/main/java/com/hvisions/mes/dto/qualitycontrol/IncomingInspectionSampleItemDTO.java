package com.hvisions.mes.dto.qualitycontrol;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @description: 检测项目（来料检验）
 * @author: Bruce
 * @version:
 * @date: 2019-10-29 16:51
 */
@Data
@ApiModel(description = "检测项目（来料检验）")
public class IncomingInspectionSampleItemDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "检测项目id" )
    private Integer checkItemId;

    @ApiModelProperty(value = "检测项目" )
    private String checkItem;

    @ApiModelProperty(value = "检测实际结果" )
    private String checkActualResult;

    @ApiModelProperty(value = "检测结果判定" )
    private String checkResultConfirm;
}
