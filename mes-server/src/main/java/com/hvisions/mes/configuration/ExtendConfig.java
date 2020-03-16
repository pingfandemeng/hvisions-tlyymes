package com.hvisions.mes.configuration;

import com.hvisions.common.dto.ExtendInfoParam;
import com.hvisions.common.service.BaseExtendService;
import com.hvisions.common.utils.SqlFactoryUtil;
import com.hvisions.mes.qualitycontrol.consts.DbConst;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * <p>Title: ExtendConfig</p>
 * <p>Description: 扩展服务配置</p>
 * <p>Company: www.h-visions.com</p>
 * <p>create date: 2018/12/24</p>
 *
 * @author :leiming
 * @version :1.0.0
 */
@Configuration
public class ExtendConfig {
    /**
     * @return 获取扩展服务工厂对象
     */
    @Bean
    SqlFactoryUtil getSqlFactory() {
        return new SqlFactoryUtil();
    }

    /**
     * 扩展服务
     *
     * @return 扩展服务
     */
    @Bean(value = "incoming_inspection_extend")
    BaseExtendService getRouteExtendService(SqlFactoryUtil getSqlFactory) {
        ExtendInfoParam extendInfoParam = new ExtendInfoParam();
        extendInfoParam.setOriginTableName(DbConst.USER_TABLE_NAME);
        extendInfoParam.setOriginTableIdName(DbConst.USER_ID);
        extendInfoParam.setSchema(DbConst.SCHEMA);
        extendInfoParam.setExtendTableName(DbConst.USER_EXTEND_TABLE);
        return getSqlFactory.getSqlBridge(extendInfoParam);
    }

    /**
     * 电仪表检测扩展服务
     * @param getSqlFactory
     * @return
     */
    @Bean(value = "dyb_extend")
    BaseExtendService getDybExtendService(SqlFactoryUtil getSqlFactory) {
        ExtendInfoParam extendInfoParam = new ExtendInfoParam();
        extendInfoParam.setOriginTableName(com.hvisions.mes.dyb.consts.DbConst.DYB_TABLE_NAME);
        extendInfoParam.setOriginTableIdName(com.hvisions.mes.dyb.consts.DbConst.DYB_ID);
        extendInfoParam.setSchema(com.hvisions.mes.dyb.consts.DbConst.SCHEMA);
        extendInfoParam.setExtendTableName(com.hvisions.mes.dyb.consts.DbConst.DYB_EXTEND_TABLE);
        return getSqlFactory.getSqlBridge(extendInfoParam);
    }

    /**
     * 客户信息扩展服务
     * @param getSqlFactory
     * @return
     */
    @Bean(value = "client_extend")
    BaseExtendService getClientExtendService(SqlFactoryUtil getSqlFactory) {
        ExtendInfoParam extendInfoParam = new ExtendInfoParam();
        extendInfoParam.setOriginTableName(com.hvisions.mes.baseinfo.consts.DbConst.CLIENT_TABLE_NAME);
        extendInfoParam.setOriginTableIdName(com.hvisions.mes.baseinfo.consts.DbConst.CLIENT_ID);
        extendInfoParam.setSchema(com.hvisions.mes.baseinfo.consts.DbConst.SCHEMA);
        extendInfoParam.setExtendTableName(com.hvisions.mes.baseinfo.consts.DbConst.CLIENT_EXTEND_TABLE);
        return getSqlFactory.getSqlBridge(extendInfoParam);
    }
}









