package com.hvisions.mes.prodplan.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>Title: DemoEntityController</p>
 * <p>Description: JPA,Mybatis 示例。推荐单表操作使用JPA，多表查询使用mybatis,JPA可以实现自动根据代码生成对应的数据库表</p>
 * <p>Company: www.h-visions.com</p>
 * <p>create date: 2019/08/03</p>
 *
 * @author :yangfan
 * @version :1.0.0
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class DemoUser extends SysBase {
    /**
     * 名称(实体保存时会校验此字段，异常统一处理此信息)
     */
    private String name;
    /**
     * 描述
     */
    private String description;

}