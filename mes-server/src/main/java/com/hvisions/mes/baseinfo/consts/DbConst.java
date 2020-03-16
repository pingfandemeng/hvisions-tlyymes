package com.hvisions.mes.baseinfo.consts;

/**
 * @description: 供应商字段扩展
 * @author: ljj3hao
 * @version:
 * @date: 2019-11-18 10:21
 */
public interface DbConst {

    /**
     * 数据库名
     */
    String SCHEMA = "tlyy";
    /**
     * 基础信息表对应的扩展表
     */
    String USER_EXTEND_TABLE = "t_supplier_info_extend";

    /**
     * 客户信息扩展表
     */
    String CLIENT_EXTEND_TABLE = "t_client_info_extend";

    /**
     * 基础信息扩展表中的基础信息id字段
     */
    String USER_ID = "id";

    /**
     * 客户信息id
     */
    String CLIENT_ID = "client_info_id";

    /**
     * 基础信息表名
     */
    String USER_TABLE_NAME = "t_supplier_info";

    /**
     * 客户信息表名
     */
    String CLIENT_TABLE_NAME = "t_client_info";
    /**
     * 默认密码
     */
    String DEFAULT_PASSWORD = "root";
    /**
     * 管理员账号
     */
    String ADMIN_ACCOUNT = "root";
}
