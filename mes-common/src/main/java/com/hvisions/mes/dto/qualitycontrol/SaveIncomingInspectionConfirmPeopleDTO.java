package com.hvisions.mes.dto.qualitycontrol;

import com.hvisions.common.interfaces.IObjectType;
import com.hvisions.mes.dto.prodplan.SysBaseDTO;
import com.hvisions.mes.enums.DemoObjectTypeEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;
@Data
@ApiModel(description = "保存检验确认信息")
public class SaveIncomingInspectionConfirmPeopleDTO extends SysBaseDTO implements IObjectType {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键（修改时填入）" )
    private Integer id;

    @ApiModelProperty(value = "报检人")
    private Integer bjUserId;

    @ApiModelProperty(value = "报检时间")
    private Date bjDate;

    @ApiModelProperty(value = "接报人")
    private Integer jbUserId;

    @ApiModelProperty(value = "接报时间")
    private Date jbDate;

    @ApiModelProperty(value = "检测人")
    private Integer checkUserId;

    @ApiModelProperty(value = "检测时间")
    private Date checkUserDate;

    @ApiModelProperty(value = "复核人")
    private Integer reviewUserId;

    @ApiModelProperty(value = "复核时间")
    private Date reviewDate;

    @ApiModelProperty(value = "放行人")
    private Integer fxUserId;

    @ApiModelProperty(value = "放行时间")
    private Date fxDate;

    @ApiModelProperty(value = "放行结论（0否，1是）")
    private Integer fxResult;

    @ApiModelProperty(value = "来料检验结论")
    private String result;

    @ApiModelProperty(value = "基础信息id")
    private Integer baseInfoId;

    @ApiModelProperty(value = "创建人")
    private Integer creatorId;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    @ApiModelProperty(value = "修改人")
    private Integer updaterId;

    @ApiModelProperty(value = "修改时间")
    private Date updateTime;

    @ApiModelProperty(value = "是否删除（0否，1是）" )
    private Integer isDel;

//    @ApiModelProperty(value = "基础数据ID")
//    private Integer baseInfoId;

    @Override
    public Integer getObjectType() {
        return DemoObjectTypeEnum.DEMO_DTO.getCode();
    }
}

