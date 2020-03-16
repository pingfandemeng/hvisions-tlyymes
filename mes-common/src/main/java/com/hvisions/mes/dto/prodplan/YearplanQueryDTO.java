package com.hvisions.mes.dto.prodplan;

import com.hvisions.common.dto.PageInfo;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * Description:
 * Author:   ljj3hao
 * Time:     2019/9/17
 * Version:  1.0.0
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class YearplanQueryDTO extends PageInfo {
    /**
     *   年份
     */
    @ApiModelProperty(value = "年份")
    private String year;
    /**
     *   产品
     */
    @ApiModelProperty(value = "产品")
    private String production;

    /**
     *   创建时间在此之前
     */
    @ApiModelProperty(value = "创建时间在此之前")
    private Date createTimeBefore;
    /**
     *   创建时间在此之后
     */
    @ApiModelProperty(value = "创建时间在此之后")
    private Date createTimeAfter;

}
