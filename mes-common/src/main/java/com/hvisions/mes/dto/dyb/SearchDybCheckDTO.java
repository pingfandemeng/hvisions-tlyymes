package com.hvisions.mes.dto.dyb;

import com.hvisions.common.dto.PageInfo;
import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.io.Serializable;

/**
 * @description: 搜索电仪表校验信息条件
 * @author: Bruce
 * @version:
 * @date: 2019-11-25 14:41
 */
@Data
@ApiModel(description = "搜索电仪表校验信息条件")
public class SearchDybCheckDTO extends PageInfo implements Serializable {

    private static final long serialVersionUID = 1L;
}
