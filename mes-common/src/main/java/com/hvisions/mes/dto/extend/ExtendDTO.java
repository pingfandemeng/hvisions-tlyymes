package com.hvisions.mes.dto.extend;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Map;

/**
 * @description: 扩展属性
 * @author: Bruce
 * @version:
 * @date: 2019-12-16 10:30
 */
@Data
@ApiModel(description = "扩展属性")
public class ExtendDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "扩展属性" )
    private Map<String, Object> extendMap;
}
