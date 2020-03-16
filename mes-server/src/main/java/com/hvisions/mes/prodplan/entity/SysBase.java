package com.hvisions.mes.prodplan.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;
/**
 * <p>Title: SysBase</p>
 * <p>Description: </p>
 * <p>Company: www.h-visions.com</p>
 * <p>create date: 2018/11/7</p>
 *
 * @author :leiming
 * @version :1.0.0
 */
@Data
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class SysBase {

    /**
     * 主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @TableId(type = IdType.AUTO)
    protected Integer id;

    /**
     * 创建时间
     */
    @Column(updatable = false)
    @CreatedDate
    protected Date createTime;

    /**
     * 修改时间
     */
    @LastModifiedDate
    protected Date updateTime;

    /**
     * 创建人
     */
    @CreatedBy
    @Column(updatable = false)
    protected Integer creatorId;

    /**
     * 修改人
     */
    @LastModifiedBy
    @Column(insertable = false)
    protected Integer updaterId;

}
