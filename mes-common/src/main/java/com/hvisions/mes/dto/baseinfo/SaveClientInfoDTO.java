package com.hvisions.mes.dto.baseinfo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @description: 客户信息
 * @author: Bruce
 * @version:
 * @date: 2019-10-14 16:35
 */
@Data
@ApiModel(description = "保存客户信息")
public class SaveClientInfoDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键（修改时填入）", example = "0" )
    private Integer id;

    @ApiModelProperty(value = "客户编号", required = true)
    private String number;

    @ApiModelProperty(value = "客户名称", required = true)
    private String name;

    @ApiModelProperty(value = "客户名称简称", required = true)
    private String nameShort;

    @ApiModelProperty(value = "联系人", required = true)
    private String contact;

    @ApiModelProperty(value = "联系电话", required = true)
    private String telephone;

}
