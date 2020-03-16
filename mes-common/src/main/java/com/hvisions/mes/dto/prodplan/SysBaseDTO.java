package com.hvisions.mes.dto.prodplan;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * <p>Title: SysBaseDTO</p>
 * <p>Description: Dto尽量继承，可以做出自己的更改</p>
 * <p>Company: www.h-visions.com</p>
 * <p>create date: 2018/11/09</p>
 *
 * @author :leiming
 * @version :1.0.0
 */
@Data
@ApiModel(description = "底层DTO")
public class SysBaseDTO {

    /**
     * 主键
     */
    @ApiModelProperty(value = "主键", example = "0")
    protected Integer id;

    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间,此字段不必传递")
    @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    protected Date createTime;

    /**
     * 修改时间
     */
    @ApiModelProperty(value = "更新时间,此字段不必传递")
    @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    protected Date updateTime;

    /**
     * 创建人
     */
    @ApiModelProperty(value = "创建用户Id", notes = "创建记录时传递,默认为当前登录用户", example = "0")
    protected Integer creatorId;

    /**
     * 修改人
     */
    @ApiModelProperty(value = "更新用户Id", notes = "更新记录时传递,默认为当前登录用户", example = "0")
    protected Integer updaterId;

}
