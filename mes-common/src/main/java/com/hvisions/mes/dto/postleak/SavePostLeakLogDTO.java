package com.hvisions.mes.dto.postleak;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @description: 保存处理结果
 * @author: Bruce
 * @version:
 * @date: 2019-11-06 18:59
 */
@Data
@ApiModel(description = "保存岗位漏点信息")
public class SavePostLeakLogDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "完成情况")
    private String doneCase;

    @ApiModelProperty(value = "备注" )
    private String backup;

    @ApiModelProperty(value = "岗位漏点id" )
    private Integer postLeakInfoId;
}
