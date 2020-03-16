package com.hvisions.mes.dto.qualitycontrol;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.hvisions.mes.dto.prodplan.SysBaseDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Data
@ApiModel(description = "查询基础信息的详情")
public class IncomingInspectionBaseInfoDetailDTO extends SysBaseDTO {

    private static final long serialVersionUID = 1L;


    @ApiModelProperty(value = "主键（修改时填入）" )
    private Integer id;

    @ApiModelProperty(value = "货物id")
    private Integer cargoId;

    @ApiModelProperty(value = "货物名称")
    private String cargoName;

    @ApiModelProperty(value = "供货单位")
    private String supplier;

    @ApiModelProperty(value = "供货单位名称")
    private String supplierName;

    @ApiModelProperty(value = "产地")
    private String source;

    @ApiModelProperty(value = "生产厂家")
    private String manufacturer;

    @ApiModelProperty(value = "货物编号")
    private String cargoNumber;

    @ApiModelProperty(value = "货物规格")
    private String cargoSpec;

    @ApiModelProperty(value = "供方批号")
    private String supplierBatchNumber;

    @ApiModelProperty(value = "生产日期（开始日期）")
    @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date prodDateStart;

    @ApiModelProperty(value = "生产日期（结束日期）")
    @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date prodDateEnd;

    @ApiModelProperty(value = "有效期")
    private String periodOfValidity;

    @ApiModelProperty(value = "到货日期")
    @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date arrivalDate;

    @ApiModelProperty(value = "货物批号")
    private String cargoBatchNumber;

    @ApiModelProperty(value = "批量")
    private Integer batch;

    @ApiModelProperty(value = "是否合格供应商（0否，1是）")
    private Integer isQualifiedSupplier;

    @ApiModelProperty(value = "报检人")
    private String bjUser;

    @ApiModelProperty(value = "报检时间")
    @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date bjDate;

    @ApiModelProperty(value = "接报人")
    private String jbUser;

    @ApiModelProperty(value = "接报时间")
    @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date jbDate;

    @ApiModelProperty(value = "检测人")
    private String checkUser;

    @ApiModelProperty(value = "检测时间")
    @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date checkUserDate;

    @ApiModelProperty(value = "复核人")
    private String reviewUser;

    @ApiModelProperty(value = "复核时间")
    @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date reviewDate;

    @ApiModelProperty(value = "放行人")
    private String fxUser;

    @ApiModelProperty(value = "放行时间")
    @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date fxDate;

    @ApiModelProperty(value = "放行结论（0否，1是）")
    private Integer fxResult;

    @ApiModelProperty(value = "来料检验结论")
    private String result;

    @ApiModelProperty(value = "基础信息id")
    private Integer baseInfoId;

    @ApiModelProperty(value = "卫生情况（0不卫生，1卫生）" )
    private Integer healthStatus;

    @ApiModelProperty(value = "虫害情况（0无，1有" )
    private Integer insectAttackStatus;

    @ApiModelProperty(value = "防护措施（0不齐全，1齐全）" )
    private Integer safeguardProceduresStatus;

    @ApiModelProperty(value = "拼车（0否，1是）    ")
    private Integer shareCarStatus;

    @ApiModelProperty(value = "若拼车（0有污染，1无污染）" )
    private Integer polluteStatus;

    @ApiModelProperty(value = "规格，型号，数量是否与采购通知单一致（0否，1是）" )
    private Integer isInfoAndNotice;

    @ApiModelProperty(value = "外包装是否规范，卫生，无虫害（0否，1是）" )
    private Integer isPackStandard;

    @ApiModelProperty(value = "标签内容是否完整清晰（0否，1是）" )
    private Integer isLabelContentOk;

    @ApiModelProperty(value = "其他" )
    private String other;

    @ApiModelProperty(value = "车辆检查人" )
    private String checkUserCar;

    @ApiModelProperty(value = "取样点" )
    private String sampleAddress;

    @ApiModelProperty(value = "取样人" )
    private String sampleUser;

    @ApiModelProperty(value = "取样时间" )
    @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date sampleDate;

    @ApiModelProperty(value = "取样件数", example = "0")
    private Integer sampleNumber;

    @ApiModelProperty(value = "取样量", example = "0" )
    private Integer sampleAmount;

    @ApiModelProperty(value = "报告日期" )
    @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date reportDate;

    @ApiModelProperty(value = "检验单号" )
    private String checkNumbers;

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

    @ApiModelProperty(value = "检测项目（外观性状）" )
    private List<IncomingInspectionSampleItemDTO> outwardList;

    @ApiModelProperty(value = "检测项目（理化指标）" )
    private List<IncomingInspectionSampleItemDTO> lhIndexList;

    @ApiModelProperty(value = "查看供方COA信息与包装信息是否一致（0否，1是）")
    private Integer isCoaAndInfo;

    @ApiModelProperty(value = "检测实际结果")
    private Integer checkActualResult;

    @ApiModelProperty(value = "检测结果判定")
    private Integer checkResultConfirm;

}
