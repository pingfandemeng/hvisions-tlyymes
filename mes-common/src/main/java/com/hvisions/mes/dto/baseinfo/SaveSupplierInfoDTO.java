package com.hvisions.mes.dto.baseinfo;

import com.hvisions.mes.enums.Constant;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * Description:
 * Author:   ljj3hao
 * Time:     2019/10/16
 * Version:  1.0.0
 */
@Data
@ApiModel(description = "保存供应商信息")
public class SaveSupplierInfoDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键（修改时填入）", example = "0" )
    private Integer id;

    @ApiModelProperty(value = "供应商编号", required = true)
    private String number;

    @ApiModelProperty(value = "供应商名称", required = true)
    private String name;

    @ApiModelProperty(value = "供应商名称简称", required = true)
    private String nameShort;

    @ApiModelProperty(value = "联系人", required = true)
    private String contact;

    @ApiModelProperty(value = "联系电话", required = true)
    private String telephone;

    @ApiModelProperty(value = "生产厂家", required = true)
    private String productFactory;

    @ApiModelProperty(value = "供应商地址", required = true)
    private String address;

    private Integer isDel = Constant.NO_DEL.getCode();
}
