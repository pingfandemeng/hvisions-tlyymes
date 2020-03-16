package com.hvisions.mes.dto.prodplan;

import com.hvisions.mes.enums.Constant;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * Description:
 * Author:   ljj3hao
 * Time:     2019/9/17
 * Version:  1.0.0
 */
@Data
@ApiModel(value = "test DTO")
public class YearPlanDTO implements Serializable {

    @ApiModelProperty(value = "主键（修改时填入）" )
    private Integer id;
    @ApiModelProperty(value = "年份,非空" )
    private String year;
    @ApiModelProperty(value = "产品，非空" )
    private String production;
    @ApiModelProperty(value = "产品名称" )
    private String productionName;
    @ApiModelProperty(value = "数量，非空", example = "0" )
    private Integer num;
    @ApiModelProperty(value = "备注" )
    private String description;
    @ApiModelProperty(value = "是否排产" )
    private Integer isPc = Constant.NO_PC.getCode();


}
