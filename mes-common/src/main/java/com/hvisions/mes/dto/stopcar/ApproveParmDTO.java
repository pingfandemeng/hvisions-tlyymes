package com.hvisions.mes.dto.stopcar;

import com.hvisions.common.dto.PageInfo;
import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.io.Serializable;

/**
 * @description: 审核列表查询
 * @author: Bruce
 * @version:
 * @date: 2019-11-27 14:27
 */
@Data
@ApiModel(description = "审核列表查询")
public class ApproveParmDTO extends PageInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer approveStatus;
}
