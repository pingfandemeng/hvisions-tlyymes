package com.hvisions.mes.prodplan.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

/**
 * <p>Title: DemoEntity</p>
 * <p>Description: Demo数据库实体示例,使用MybatisPlus实现数据库操作</p>
 * <p>Company: www.h-visions.com</p>
 * <p>create date: 2018/10/23</p>
 *
 * @author :leiming
 * @version :1.0.0
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = "name",name = "实体名称不能为空"))
public class DemoEntity extends SysBase {
    /**
     * 名称(实体保存时会校验此字段，异常统一处理此信息)
     */
    @NotNull(message = "实体名称不能为空")
    private String name;
    /**
     * 描述
     */
    private String description;

    private Integer userId;


}
