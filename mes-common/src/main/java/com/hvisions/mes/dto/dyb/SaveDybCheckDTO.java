package com.hvisions.mes.dto.dyb;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.hvisions.mes.dto.extend.ExtendDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * @description: 保存电仪表校验信息
 * @author: Bruce
 * @version:
 * @date: 2019-11-25 14:09
 */
@Data
@ApiModel(description = "保存电仪表校验信息")
public class SaveDybCheckDTO extends ExtendDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键（修改时填入）", example = "0" )
    private Integer id;

    @ApiModelProperty(value = "电仪表名称" )
    private Integer dybName;

    @ApiModelProperty(value = "设备编号" )
    private String dybNumber;

    @ApiModelProperty(value = "校验周期（1一周，2一个月，3半年，4一年）" )
    private String checkPeriod;

    @ApiModelProperty(value = "校验方法" )
    private String checkMethod;

    @ApiModelProperty(value = "校验类型（1自检，2送检）" )
    private Integer checkType;

    @ApiModelProperty(value = "预计校验时间" )
    @JsonFormat(pattern="yyyy-MM-dd HH:mm",timezone="GMT+8")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm")
    private Date plantCheckTime;

    @ApiModelProperty(value = "电仪表位置" )
    private String dybPost;

    @ApiModelProperty(value = "电仪表车间" )
    private String dybPlant;

    @ApiModelProperty(value = "备注" )
    private String backup;
}
