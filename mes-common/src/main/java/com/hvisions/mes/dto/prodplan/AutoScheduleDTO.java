package com.hvisions.mes.dto.prodplan;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * <p>Title: AutoScheduleDTO</p >
 * <p>Description: 自动排产dto</p >
 * <p>Company: www.h-visions.com</p >
 * <p>create date: 2020/1/6</p >
 *
 * @author :rujiacheng
 * @version :1.0.0
 */
@Data
@ApiModel(description = "自动排产dto")
public class AutoScheduleDTO {
    /**
     * 数量
     */
    @ApiModelProperty(value = "数量,非空")
    private Integer quantity;
    /**
     * 年份
     */
    @ApiModelProperty(value = "年份,非空")
    private Integer year;
    /**
     * 产品id
     */
    @ApiModelProperty(value = "产品id,非空")
    private Integer materialId;
    /**
     * 计划id
     */
    @ApiModelProperty(value = "计划id,非空")
    private Integer planId;
    /**
     * 工艺路线id
     */
    @ApiModelProperty(value = "工艺路线id,非空")
    private Integer routeId;
    /**
     * 车间id
     */
    @ApiModelProperty(value = "车间id,非空")
    private Integer areaId;
    /**
     * 产线id
     */
    @ApiModelProperty(value = "产线id,非空")
    private Integer cellId;
    /**
     * 产品名称
     */
    @ApiModelProperty(value = "产品名称")
    private String productionName;
    /**
     * 工艺路线名称
     */
    @ApiModelProperty(value = "工艺路线名称")
    private String routeName;
    /**
     * 车间名称
     */
    @ApiModelProperty(value = "车间名称")
    private String areaName;
    /**
     * 产线名称
     */
    @ApiModelProperty(value = "产线名称")
    private String cellName;

    /**
     * 产线编码
     */
    @ApiModelProperty(value = "产线编码")
    private String cellCode;
}