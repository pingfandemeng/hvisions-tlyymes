package com.hvisions.mes.dto.baseinfo;

import com.hvisions.common.dto.PageInfo;
import com.hvisions.mes.enums.Constant;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * Description:
 * Author:   ljj3hao
 * Time:     2019/10/16
 * Version:  1.0.0
 */
@Data
@ApiModel(description = "搜索供应商信息列表")
public class SearchSupplierInfoDTO extends PageInfo {

    private static final long serialVersionUID = 1L;

    /**
     *   年份
     */
    @ApiModelProperty(value = "供应商名称")
    private String name;
    /**
     *   产品
     */
    @ApiModelProperty(value = "供应商简称")
    private String nameShort;

    private Integer isDel = Constant.NO_DEL.getCode();

}
