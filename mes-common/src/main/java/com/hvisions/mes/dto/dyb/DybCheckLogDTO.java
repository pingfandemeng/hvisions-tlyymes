package com.hvisions.mes.dto.dyb;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * @description: 电仪表校验记录
 * @author: Bruce
 * @version:
 * @date: 2019-11-25 16:20
 */
@Data
@ApiModel(description = "电仪表校验记录")
public class DybCheckLogDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "预计校验时间" )
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date plantCheckTime;

    @ApiModelProperty(value = "实际校验时间" )
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date realityCheckTime;

    @ApiModelProperty(value = "检测结果" )
    private String checkResult;

    @ApiModelProperty(value = "责任人" )
    private String user;

}
