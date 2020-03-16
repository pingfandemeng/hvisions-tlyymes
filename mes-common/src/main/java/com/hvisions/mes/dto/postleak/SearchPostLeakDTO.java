package com.hvisions.mes.dto.postleak;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.hvisions.common.dto.PageInfo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * @description: 搜索岗位漏点信息条件
 * @author: Bruce
 * @version:
 * @date: 2019-11-05 15:06
 */
@Data
@ApiModel(description = "搜索岗位漏点信息列表")
public class SearchPostLeakDTO extends PageInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "车间" )
    private String plant;

    @ApiModelProperty(value = "发现人" )
    private Integer findUser;

    @ApiModelProperty(value = "发现时间" )
    @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date findDate;

    @ApiModelProperty(value = "泄漏类型" )
    private String leakType;

    @ApiModelProperty(value = "处理责任人" )
    private Integer disposeUser;
}
