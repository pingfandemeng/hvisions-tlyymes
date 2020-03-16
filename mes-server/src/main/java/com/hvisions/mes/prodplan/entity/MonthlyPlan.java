package com.hvisions.mes.prodplan.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import java.math.BigDecimal;
import java.util.Date;


/**
 * Description: 月度计划信息
 * @author dyxie
 */
@EqualsAndHashCode(callSuper = true)
@Entity
@Data
//@Table(uniqueConstraints = @UniqueConstraint(columnNames = "year",name = "实体名称不能为空"))
public class MonthlyPlan extends SysBase {
    /**
     * 年份
     */
    // @NotBlank(message = "年份不能为空")
    private Integer year;

    /**
     * 月份
     */
    private Integer month;

    /**
     * 用户输入的时间
     */
    private Date userDate;

    /**
     * 计划开始时间
     */
    private Date planStartTime;

    /**
     * 计划结束时间
     */
    private Date planEndTime;

    /**
     * 产品
     */
    private String product;

    /**
     * 计划量
     */
    private BigDecimal amount;

    /**
     * 月度计划状态（0：未审核 1：已审核） PS：审核以后生成生产工单后需要生产工单撤回才能修改
     */
    private Integer type;

}
