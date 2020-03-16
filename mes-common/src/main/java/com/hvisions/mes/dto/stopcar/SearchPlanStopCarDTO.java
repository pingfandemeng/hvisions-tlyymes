package com.hvisions.mes.dto.stopcar;

import com.hvisions.common.dto.PageInfo;
import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.io.Serializable;

/**
 * @description: 搜索计划停车条件
 * @author: Bruce
 * @version:
 * @date: 2019-11-26 15:21
 */
@Data
@ApiModel(description = "搜索计划停车条件")
public class SearchPlanStopCarDTO extends PageInfo implements Serializable {

    private static final long serialVersionUID = 1L;
}
