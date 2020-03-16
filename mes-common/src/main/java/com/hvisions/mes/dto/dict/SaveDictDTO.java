package com.hvisions.mes.dto.dict;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @description: 保存数据字典信息
 * @author: Bruce
 * @version:
 * @date: 2019-11-08 14:53
 */
@Data
@ApiModel(description = "保存客户信息")
public class SaveDictDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键（修改时填入）", example = "0" )
    private Integer id;

    @ApiModelProperty(value = "类型代码")
    private String typeCode;

    @ApiModelProperty(value = "类型名称")
    private String typeName;

    @ApiModelProperty(value = "类型值代码")
    private Integer valueCode;

    @ApiModelProperty(value = "类型值名称")
    private String valueName;
}
