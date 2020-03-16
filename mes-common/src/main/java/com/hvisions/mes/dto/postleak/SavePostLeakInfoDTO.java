package com.hvisions.mes.dto.postleak;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * @description: 保存岗位漏点信息
 * @author: Bruce
 * @version:
 * @date: 2019-11-05 09:37
 */
@Data
@ApiModel(description = "保存岗位漏点信息")
public class SavePostLeakInfoDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键（修改时填入）", example = "0" )
    private Integer id;

    @ApiModelProperty(value = "漏点编号" )
    private String leakNum;

    @ApiModelProperty(value = "车间" )
    private String plant;

    @ApiModelProperty(value = "工段" )
    private String section;

    @ApiModelProperty(value = "位置" )
    private String position;

    @ApiModelProperty(value = "工艺介质" )
    private String medium;

    @ApiModelProperty(value = "漏点描述" )
    private String leakDescription;

    @ApiModelProperty(value = "泄漏类型" )
    private String leakType;

    @ApiModelProperty(value = "计划处理措施" )
    private String planMeasure;

    @ApiModelProperty(value = "计划处理时间" )
    @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date planDate;

    @ApiModelProperty(value = "备注" )
    private String backup;

}
