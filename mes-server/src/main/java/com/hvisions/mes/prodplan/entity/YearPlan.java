package com.hvisions.mes.prodplan.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * Description:
 * Author:   ljj3hao
 * Time:     2019/9/17
 * Version:  1.0.0
 */
@EqualsAndHashCode(callSuper = true)
@Entity
@Data
/*@Table(uniqueConstraints = @UniqueConstraint(name = "年份不能重复", columnNames = "year"))*/
public class YearPlan extends SysBase {
    /**
     * 年份
     */
    @NotBlank(message = "年份不能为空")
    private String year;

    /**
     * 产品
     */
    @NotBlank(message = "产品为空")
    private String production;

    /**
     * 产品名称
     */
    private String productionName;


    /**
     * 产量
     */
    @NotNull(message = "产量不能为空")
    private Integer num;

    /**
     * 备注
     */
    private String description;

    /**
     * 是否已排产
     */
    private Integer isPc;

}

