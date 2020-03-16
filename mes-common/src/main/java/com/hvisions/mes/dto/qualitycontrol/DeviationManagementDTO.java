package com.hvisions.mes.dto.qualitycontrol;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @Author: Lau
 * @Description: 偏差管理DTO
 * @Date: Created in 10:58 2020/1/8
 * @Modified By:
 */
@Data
@ApiModel(description = "偏差管理信息")
public class DeviationManagementDTO implements Serializable {

    private static final long serialVersionUID = 1L;


    @ApiModelProperty(value = "主键（修改时填入）", example = "0" )
    private Integer id;
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
     * 异常点编码
     */
    @ApiModelProperty(value = "异常点编码")
    private String outlierCoding;

    /**
     * 异常点名称
     */
    @ApiModelProperty(value = "异常点名称")
    private String exceptionName;

    /**
     * 实际值
     */
    @ApiModelProperty(value = "实际值")
    private BigDecimal actualValue;

    /**
     * 下限值
     */
    @ApiModelProperty(value = "下限值")
    private BigDecimal lowerValue;

    /**
     * 上限值
     */
    @ApiModelProperty(value = "上限值")
    private BigDecimal upperValue;

    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createTime;

    /**
     * 状态码 0.新建  1.已上报(上报时键入)  2.已复核 3.已完成(填写备注时键入)
     */
    @ApiModelProperty(value = "状态码 0.新建  1.已上报(上报时键入)  2.已复核(复核时键入) 3.已完成(填写备注时键入)")
    private Integer status;

    /**
     * 备注
     */
    @ApiModelProperty(value = "备注")
    private String remark;

    /**
     *偏差原因
     */
    @ApiModelProperty(value = "偏差原因")
    private String reason;
}
