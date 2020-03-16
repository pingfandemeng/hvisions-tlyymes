package com.hvisions.mes.dto.qualitycontrol;

import com.hvisions.mes.dto.prodplan.SysBaseDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Description: 来料车辆外观检验DTO
 *
 * @author: dyxie
 * Time:     2019/10/18
 * Version:  1.0.0
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ApiModel(description = "carCheck DTO")
public class CarCheckDTO extends SysBaseDTO {

    @ApiModelProperty(value = "id", example = "0" )
    private Integer id;

    @ApiModelProperty(value = "卫生情况（0不卫生，1卫生）", example = "0" )
    private Integer healthStatus;

    @ApiModelProperty(value = "虫害情况（0无，1有", example = "0" )
    private Integer insectAttackStatus;

    @ApiModelProperty(value = "防护措施（0不齐全，1齐全）", example = "0" )
    private Integer safeguardProceduresStatus;

    @ApiModelProperty(value = "拼车（0否，1是）", example = "0")
    private Integer shareCarStatus;

    @ApiModelProperty(value = "若拼车（0有污染，1无污染）", example = "0" )
    private Integer polluteStatus;

    @ApiModelProperty(value = "规格，型号，数量是否与采购通知单一致（0否，1是）", example = "0" )
    private Integer isInfoAndNotice;

    @ApiModelProperty(value = "外包装是否规范，卫生，无虫害（0否，1是）", example = "0" )
    private Integer isPackStandard;

    @ApiModelProperty(value = "标签内容是否完整清晰（0否，1是）", example = "0" )
    private Integer isLabelContentOk;

    @ApiModelProperty(value = "其他" )
    private String other;

    @ApiModelProperty(value = "检查人", example = "0" )
    private Integer checkUserId;

    @ApiModelProperty(value = "基础信息id", example = "0" )
    private Integer baseInfoId;

//    @ApiModelProperty(value = "创建人", example = "0" )
//    private Integer creatorId;
//
//    @ApiModelProperty(value = "创建时间" )
//    private Date createTime;
//
//    @ApiModelProperty(value = "修改人", example = "0" )
//    private Integer updaterId;
//
//    @ApiModelProperty(value = "修改时间" )
//    private Date updateTime;
//
//    @ApiModelProperty(value = "是否删除（0否，1是）", example = "0" )
//    private Integer isDel;
}
