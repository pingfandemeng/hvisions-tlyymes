package com.hvisions.mes.dto.equipment;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.hvisions.common.dto.PageInfo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * @description: 设备检修搜索条件
 * @author: Bruce
 * @version:
 * @date: 2020-01-14 17:26
 */
@Data
@ApiModel(description = "设备检修搜索条件")
public class SearchEquipmentOverhaulDTO extends PageInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "开始日期" )
    @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date startTime;

    @ApiModelProperty(value = "结束日期" )
    @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date endTime;
}
