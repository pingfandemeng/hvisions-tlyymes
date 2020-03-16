package com.hvisions.mes.dto.dict;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @description: 数据字典列表
 * @author: Bruce
 * @version:
 * @date: 2019-11-08 15:00
 */
@Data
@ApiModel(description = "保存客户信息")
public class DictListDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键", example = "0" )
    private Integer id;

    @ApiModelProperty(value = "父类id")
    private Integer parentId;

    @ApiModelProperty(value = "代码")
    private String code;

    @ApiModelProperty(value = "名称")
    private String name;
}
