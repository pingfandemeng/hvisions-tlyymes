package com.hvisions.mes.dto.prodplan;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Date;


/**
 * Description: 月度计划DTO
 * @author dyxie
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ApiModel(description = "monthlyPlan DTO")
public class MonthlyPlanDTO extends SysBaseDTO {

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
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date userDate;

    /**
     * 计划开始时间
     */
    @ApiModelProperty(value = "计划开始时间")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date planStartTime;

    /**
     * 计划结束时间
     */
    @ApiModelProperty(value = "计划结束时间")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    @DateTimeFormat(pattern="yyyy-MM-dd")
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

    /**
     * 转换时间
     */
    @ApiModelProperty(value = "用来拆分获取前端给的年和月")
    private String formatDate;

    /**
     * 物料名称
     */
    @ApiModelProperty(value = "前端展示物料名称")
    private String productName;

//    @Override
//    public Integer getObjectType() {
//        return DemoObjectTypeEnum.DEMO_DTO.getCode();
//    }
}
