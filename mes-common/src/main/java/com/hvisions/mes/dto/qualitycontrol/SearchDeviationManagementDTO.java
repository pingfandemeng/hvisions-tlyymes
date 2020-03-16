package com.hvisions.mes.dto.qualitycontrol;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.hvisions.common.dto.PageInfo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author: Lau
 * @Description: 搜索偏差管理条件
 * @Date: Created in 9:55 2020/1/8
 * @Modified By:
 */
@Data
@ApiModel(description = "搜索偏差管理的信息列表")
public class SearchDeviationManagementDTO extends PageInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 工单号
     */
    @ApiModelProperty(value = "工单号")
    private String workOrderNum;

    /**
     * 生产批支号
     */
    @ApiModelProperty(value = "生产批支号")
    private String productionBatchNum;

    /**
     * 产线
     */
    @ApiModelProperty(value = "产线")
    private String productionLine;

    /**
     * 工段
     */
    @ApiModelProperty(value = "工段")
    private String workshopSection;

    /**
     *   创建日期之前
     */
    @ApiModelProperty(value = "创建日期之前")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date createTimeBefore;

    /**
     *   创建日期之后
     */
    @ApiModelProperty(value = "创建日期之后")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date createTimeAfter;


    /**
     * 状态码
     */
    @ApiModelProperty(value = "状态码(0.新建  1.已上报  2.已复核)  不需要填写")
    private Integer status;



}
