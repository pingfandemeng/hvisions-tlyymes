package com.hvisions.mes.dto.stopcar;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * @description: 计划停车信息
 * @author: Bruce
 * @version:
 * @date: 2019-11-26 14:57
 */
@Data
@ApiModel(description = "计划停车信息")
public class PlanStopCarDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键（修改时填入）", example = "0" )
    private Integer id;

    @ApiModelProperty(value = "车间" )
    private Integer plant;

    @ApiModelProperty(value = "设备编号" )
    private String equipmentNumber;

    @ApiModelProperty(value = "设备型号" )
    private String equipmentType;

    @ApiModelProperty(value = "设备名称" )
    private String equipmentName;

    @ApiModelProperty(value = "设备位置" )
    private String equipmentPosition;

    @ApiModelProperty(value = "计划停车日期" )
    @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date planStopDate;

    @ApiModelProperty(value = "停车时长（天）" )
    private Integer stopLength;

    @ApiModelProperty(value = "停车提醒日期" )
    @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date stopRemindDate;
}
