package com.hvisions.mes.dyb.consts;

/**
 * @description: 字段扩展
 * @author: Bruce
 * @version:
 * @date: 2019-12-09 16:57
 */
public interface DbConst {

    /**
     * 数据库名
     */
    String SCHEMA = "tlyy";
    /**
     * 基础信息表对应的扩展表
     */
    String DYB_EXTEND_TABLE = "t_dyb_extend";

    /**
     * 基础信息扩展表中的基础信息id字段
     */
    String DYB_ID = "dyb_id";

    /**
     * 基础信息表名
     */
    String DYB_TABLE_NAME = "t_dyb_check";
    /**
     * 默认密码
     */
    String DEFAULT_PASSWORD = "root";
    /**
     * 管理员账号
     */
    String ADMIN_ACCOUNT = "root";
}
