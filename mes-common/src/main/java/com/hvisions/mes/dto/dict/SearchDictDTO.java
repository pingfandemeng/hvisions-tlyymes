package com.hvisions.mes.dto.dict;

import com.hvisions.common.dto.PageInfo;
import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.io.Serializable;

/**
 * @description: 搜索数据字典条件
 * @author: Bruce
 * @version:
 * @date: 2019-11-08 15:51
 */
@Data
@ApiModel(description = "搜索数据字典条件")
public class SearchDictDTO extends PageInfo implements Serializable {

    private static final long serialVersionUID = 1L;
}
