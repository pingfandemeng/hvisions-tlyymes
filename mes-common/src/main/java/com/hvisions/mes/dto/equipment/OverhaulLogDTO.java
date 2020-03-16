package com.hvisions.mes.dto.equipment;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * @description: 设备检修记录
 * @author: Bruce
 * @version:
 * @date: 2020-01-19 17:20
 */
@Data
@ApiModel(description = "设备检修记录")
public class OverhaulLogDTO implements Serializable {


    @ApiModelProperty(value = "检修开始时间" )
    @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date overhaulStartTime;

    @ApiModelProperty(value = "检修内容" )
    private String overhaulContent;

    @ApiModelProperty(value = "检修完成时间" )
    @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date overhaulEndTime;

    @ApiModelProperty(value = "检修人员" )
    private String overhaulUser;

    @ApiModelProperty(value = "检修费用" )
    private Long overhaulAmount;
}
