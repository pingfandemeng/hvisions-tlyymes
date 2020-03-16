package com.hvisions.mes.prodplan.repository;

import com.hvisions.mes.baseinfo.entity.tSupplierInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SupplierInfoRepository extends JpaRepository<tSupplierInfo, Integer> {
    /**
     * 根据名称和简称分页查询
     *
     * @param name       年份
     * @param nameShort 产品
     * @param pageable    分页
     * @return 列表
     */
    Page<tSupplierInfo> findByNameAndNameShort(String name, String nameShort, Pageable pageable);
}
