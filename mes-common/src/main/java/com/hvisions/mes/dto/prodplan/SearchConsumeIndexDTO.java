package com.hvisions.mes.dto.prodplan;

import com.hvisions.common.dto.PageInfo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * @description: 搜索消耗指标条件
 * @author: Bruce
 * @version:
 * @date: 2019-09-17 17:08
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ApiModel(description = "搜索消耗指标条件")
public class SearchConsumeIndexDTO extends PageInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "年份（不用传）", hidden = true)
    private String year;

    @ApiModelProperty(value = "月份（不用传）", hidden = true)
    private String month;

    @ApiModelProperty(value = "日期（必填）", required = true)
    private String date;
}
