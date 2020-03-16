package com.hvisions.mes.dto.equipment;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * @description: 延期检修
 * @author: Bruce
 * @version:
 * @date: 2020-01-16 17:14
 */
@Data
@ApiModel(description = "设备检修计划")
public class PostponeOverhaulDTO implements Serializable {

    @ApiModelProperty(value = "设备检修id" )
    private Integer equipmentId;

    @ApiModelProperty(value = "延期日期" )
    @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date postponeDate;

    @ApiModelProperty(value = "延期备注" )
    private String postponeBackup;
}
