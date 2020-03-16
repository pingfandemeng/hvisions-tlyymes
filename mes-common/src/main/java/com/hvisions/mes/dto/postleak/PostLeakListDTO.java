package com.hvisions.mes.dto.postleak;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * @description: 岗位漏点信息列表
 * @author: Bruce
 * @version:
 * @date: 2019-11-06 18:27
 */
@Data
@ApiModel(description = "岗位漏点信息列表")
public class PostLeakListDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键", example = "0" )
    private Integer id;

    @ApiModelProperty(value = "漏点编号" )
    private String leakNum;

    @ApiModelProperty(value = "车间编号" )
    private String plant;

    @ApiModelProperty(value = "车间名称" )
    private String plantName;

    @ApiModelProperty(value = "工段" )
    private String section;

    @ApiModelProperty(value = "发现人" )
    private String findUser;

    @ApiModelProperty(value = "发现时间" )
    @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date findDate;

    @ApiModelProperty(value = "位置" )
    private String position;

    @ApiModelProperty(value = "工艺介质" )
    private String medium;

    @ApiModelProperty(value = "漏点描述" )
    private String leakDescription;

    @ApiModelProperty(value = "泄漏类型code" )
    private String leakTypeCode;

    @ApiModelProperty(value = "泄漏类型名称" )
    private String leakTypeName;

    @ApiModelProperty(value = "计划处理措施" )
    private String planMeasure;

    @ApiModelProperty(value = "计划处理时间" )
    @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date planDate;

    @ApiModelProperty(value = "处理责任人" )
    private String disposeUser;

    @ApiModelProperty(value = "完成时间" )
    @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date doneDate;

    @ApiModelProperty(value = "完成情况" )
    private String doneCase;

    @ApiModelProperty(value = "复核人" )
    private String reviewUser;

    @ApiModelProperty(value = "复核时间" )
    @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date reviewDate;

    @ApiModelProperty(value = "备注" )
    private String backup;
}
