package com.hvisions.mes.dto.qualitycontrol;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.hvisions.common.dto.PageInfo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * Description:
 * Author:   ljj3hao
 * Time:     2019/10/18
 * Version:  1.0.0
 */
@Data
@ApiModel(description = "搜索来料检验的信息列表")
public class SearchIncomingInspectionBaseInfoDTO extends PageInfo {

    private static final long serialVersionUID = 1L;

    /**
     *   货物名称id
     */
    @ApiModelProperty(value = "货物名称id")
    private String cargoId;
    /**
     *   供货单位
     */
    @ApiModelProperty(value = "供货单位")
    private String supplier;

    /**
     *   到货日期之前
     */
    @ApiModelProperty(value = "到货日期之前")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date arrivalDataBefore;

    /**
     *   到货日期之后
     */
    @ApiModelProperty(value = "到货日期之后")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date arrivalDataAfter;





}
