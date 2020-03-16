package com.hvisions.mes.baseinfo.dao;

import com.hvisions.mes.baseinfo.entity.tSupplierInfo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SupplierInfoMapper
{

    /**
     * 查询
     * @param id 主键
     * @return 结果
     */
    tSupplierInfo selectByPrimaryKey(Integer id);
}
