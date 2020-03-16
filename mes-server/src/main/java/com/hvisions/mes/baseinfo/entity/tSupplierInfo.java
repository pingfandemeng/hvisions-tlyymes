package com.hvisions.mes.baseinfo.entity;

import com.hvisions.mes.prodplan.entity.SysBase;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import java.util.Date;

/**
 * Description:
 * Author:   ljj3hao
 * Time:     2019/10/16
 * Version:  1.0.0
 */
@EqualsAndHashCode(callSuper = true)
@Entity
@Data

public class tSupplierInfo extends SysBase {
     /**
     * 主键
     */
    private Integer id;

    /**
     * 供应商编号
     */
    private String number;

    /**
     * 供应商名称
     */
    private String name;

    /**
     * 供应商名称简称
     */
    private String nameShort;

    /**
     * 联系人
     */
    private String contact;

    /**
     * 联系电话
     */
    private String telephone;
    /**
    *供应商地址
     */
    private String address;

    /**
     *生产厂家
     */
    private String productFactory;

    /**
     * 创建人
     */
    private Integer creatorId;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改人
     */
    private Integer updaterId;

    /**
     * 修改时间
     */
    private Date updateTime;

    /**
     * 是否删除
     */
    private Integer isDel;
}

