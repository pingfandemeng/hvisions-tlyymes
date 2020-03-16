package com.hvisions.mes.qualitycontrol.consts;

/**
 * @description: 数据库表字段扩展
 * @author: Bruce
 * @version:
 * @date: 2019-10-22 09:46
 */
public interface DbConst {

    /**
     * 数据库名
     */
    String SCHEMA = "tlyy";
    /**
     * 基础信息表对应的扩展表
     */
    String USER_EXTEND_TABLE = "t_incoming_inspection_extend";

    /**
     * 基础信息扩展表中的基础信息id字段
     */
    String USER_ID = "base_info_id";

    /**
     * 基础信息表名
     */
    String USER_TABLE_NAME = "t_incoming_inspection_base_info";
    /**
     * 默认密码
     */
    String DEFAULT_PASSWORD = "root";
    /**
     * 管理员账号
     */
    String ADMIN_ACCOUNT = "root";
}
