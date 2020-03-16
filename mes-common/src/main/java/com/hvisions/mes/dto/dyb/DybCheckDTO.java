package com.hvisions.mes.dto.dyb;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * @description: 电仪表列表信息
 * @author: Bruce
 * @version:
 * @date: 2019-12-09 11:22
 */
@Data
@ApiModel(description = "保存电仪表校验信息")
public class DybCheckDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键（修改时填入）", example = "0" )
    private Integer id;

    @ApiModelProperty(value = "电仪表名称" )
    private String dybName;

    @ApiModelProperty(value = "设备编号" )
    private String dybNumber;

    @ApiModelProperty(value = "校验周期" )
    private String checkPeriod;

    @ApiModelProperty(value = "校验方法" )
    private String checkMethod;

    @ApiModelProperty(value = "校验类型（1自检，2送检）" )
    private String checkType;

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

    @ApiModelProperty(value = "状态（1新建，2校验中，3延期中，4完成校验）" )
    private Integer status;

    @ApiModelProperty(value = "扩展属性" )
    private Object extend;

}
