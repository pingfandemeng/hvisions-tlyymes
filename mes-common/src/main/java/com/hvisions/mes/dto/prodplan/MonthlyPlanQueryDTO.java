package com.hvisions.mes.dto.prodplan;/**
 * Description:
 * Author:   29698
 * Time:     2019/9/16
 * Version:  1.0.0
 */

import com.hvisions.common.dto.PageInfo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;
import java.math.BigDecimal;
/**
 * Description: 
 * @author: dyxie
 * Time:     2019/9/16
 * Version:  1.0.0
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ApiModel(description = "MonthlyPlan查询对象")
public class MonthlyPlanQueryDTO extends PageInfo {
//    public MonthlyPlanQueryDTO(){
//        year = "";
//        product = "";
//        startTime = "";
//    }

    /**
     * 年份
     */
    @ApiModelProperty(value = "年份,非空", example = "0" )
    private Integer year;

    /**
     * 月份
    */
    @ApiModelProperty(value = "月份", example = "0")
    private Integer month;

    /**
     * 用户输入的时间
     */
    @ApiModelProperty(value = "用户输入的时间")
    private Date userDate;

    /**
     * 计划开始时间
     */
    @ApiModelProperty(value = "计划开始时间")
    private Date planStartTime;

    /**
     * 计划结束时间
     */
    @ApiModelProperty(value = "计划结束时间")
    private Date planEndTime;

    /**
     * 产品
     */
    @ApiModelProperty(value = "产品")
    private String product;

    /**
     * 计划量
     */
    @ApiModelProperty(value = "计划量")
    private BigDecimal amount;

    /**
     * 月度计划状态（0：未确认 1：确认） PS：确认以后生成生产工单后需要生产工单撤回才能修改
     */
    @ApiModelProperty(value = "月度计划状态", example = "0")
    private Integer type;

    @ApiModelProperty(value = "获取年月拆分")
    private String yearAndMonth;

}
