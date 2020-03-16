package com.hvisions.mes.dto.qualitycontrol;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @description: 保存取样检测（来料检验）
 * @author: Bruce
 * @version:
 * @date: 2019-10-18 16:53
 */
@Data
@ApiModel(description = "保存取样检测（来料检验）")
public class SaveIncomingInspectionSampleDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "取样点" )
    private String sampleAddress;

    @ApiModelProperty(value = "取样时间" )
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date sampleDate;

    @ApiModelProperty(value = "取样件数", example = "0")
    private Integer sampleNumber;

    @ApiModelProperty(value = "取样量", example = "0" )
    private Integer sampleAmount;

    @ApiModelProperty(value = "报告日期" )
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date reportDate;

    @ApiModelProperty(value = "检验单号" )
    private String checkNumbers;

    @ApiModelProperty(value = "基础信息id", required = true, example = "0")
    private Integer baseInfoId;

    @ApiModelProperty(value = "共检查几件", example = "0" )
    private Integer checkCount;

    @ApiModelProperty(value = "重量范围（最小值）" )
    private BigDecimal weightRangeStart;

    @ApiModelProperty(value = "重量范围（最大值）" )
    private BigDecimal weightRangeEnd;

    @ApiModelProperty(value = "平均重量" )
    private BigDecimal meanWeight;

    @ApiModelProperty(value = "重量单位" )
    private String weightUnit;

    @ApiModelProperty(value = "单件重量结果判断" )
    private String resultConfirm;

    @ApiModelProperty(value = "来料检验结论" )
    private String result;

    @ApiModelProperty(value = "检测项目（外观性状）" )
    private List<IncomingInspectionSampleItemDTO> outwardList;

    @ApiModelProperty(value = "检测项目（理化指标）" )
    private List<IncomingInspectionSampleItemDTO> lhIndexList;

}
