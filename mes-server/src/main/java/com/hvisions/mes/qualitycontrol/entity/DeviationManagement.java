package com.hvisions.mes.qualitycontrol.entity;

import com.hvisions.mes.prodplan.entity.SysBase;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;

/**
 * @Author: Lau
 * @Description: 偏差管理
 * @Date: Created in 15:36 2020/1/6
 * @Modified By:
 */
@Data
@Entity
@EqualsAndHashCode(callSuper = true)
@Table(name = "t_deviation_management")
public class DeviationManagement extends SysBase  {


    /**
     * 工单号
     */
    @Column(name="work_order_num",length = 20)
    private String workOrderNum;

    /**
     * 生产批支号
     */
    @Column(name="production_batch_num",length = 20)
    private String productionBatchNum;

    /**
     * 产线
     */
    @Column(name="production_line",length = 10)
    private String productionLine;

    /**
     * 工段
     */
    @Column(name="workshop_section",length = 10)
    private String workshopSection;

    /**
     * 异常点编码
     */
    @Column(name="outlier_coding",length = 20)
    private String outlierCoding;

    /**
     * 异常点名称
     */
    @Column(name="exception_name",length = 10)
    private String exceptionName;

    /**
     * 实际值
     */
    @Column(name="actual_value",precision = 8,scale = 3)
    private BigDecimal actualValue;

    /**
     * 下限值
     */
    @Column(name="lower_value",precision = 8,scale = 3)
    private BigDecimal lowerValue;

    /**
     * 上限值
     */
    @Column(name="upper_value",precision = 8,scale = 3)
    private BigDecimal upperValue;

    /**
     * 状态码 0.新建  1.已上报(上报时键入)  2.已复核(复核时键入)
     */
    private Integer status;

    /**
     * 备注
     */
    @Column(name="remark",length = 100)
    private String remark;

    /**
     *偏差原因
     */
    @Column(name="reason",length = 100)
    private String reason;

    /**
     * 删除
     */
    private Integer isDel;
}
