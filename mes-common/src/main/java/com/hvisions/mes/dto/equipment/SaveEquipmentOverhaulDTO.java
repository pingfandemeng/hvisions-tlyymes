package com.hvisions.mes.dto.equipment;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * @description: 设备检修计划
 * @author: Bruce
 * @version:
 * @date: 2020-01-14 17:05
 */
@Data
@ApiModel(description = "设备检修计划")
public class SaveEquipmentOverhaulDTO implements Serializable {

    private static final long serialVersionUID = 1L;


    @ApiModelProperty(value = "主键（修改时必填）" )
    private Integer id;

    @ApiModelProperty(value = "车间" )
    private String plant;

    @ApiModelProperty(value = "车间编码" )
    private String plantCode;

    @ApiModelProperty(value = "设备编号" )
    private String equipmentNumber;

    @ApiModelProperty(value = "设备型号" )
    private String equipmentType;

    @ApiModelProperty(value = "设备名称" )
    private String equipmentName;

    @ApiModelProperty(value = "设备名称code")
    private String equipmentNameCode;

    @ApiModelProperty(value = "预计检修时长（时）" )
    private Integer overhaulTime;

    @ApiModelProperty(value = "停机时长（时）" )
    private Integer stopTime;

    @ApiModelProperty(value = "周期（天）" )
    private Integer cycle;

    @ApiModelProperty(value = "预计检修日期" )
    @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date overhaulDate;

    @ApiModelProperty(value = "提前提醒天数" )
    private Integer remindDays;

    @ApiModelProperty(value = "实际检修日期（做详情展示用）" )
    @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date actualDate;

    @ApiModelProperty(value = "状态（仅作数据展示使用，1新建，2开始检修中，3完成检修，4延期中）" )
    private String status;

}
