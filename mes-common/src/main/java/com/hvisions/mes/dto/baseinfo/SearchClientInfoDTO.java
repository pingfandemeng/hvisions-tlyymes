package com.hvisions.mes.dto.baseinfo;

import com.hvisions.common.dto.PageInfo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @description: 搜索客户信息列表
 * @author: Bruce
 * @version:
 * @date: 2019-10-15 11:08
 */
@Data
@ApiModel(description = "搜索客户信息列表")
public class SearchClientInfoDTO extends PageInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "客户名称")
    private String clientName;
}
