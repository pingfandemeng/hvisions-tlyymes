package com.hvisions.mes.prodplan.repository;

import com.hvisions.mes.prodplan.entity.YearPlan;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface YearPlanRepository extends JpaRepository<YearPlan, Integer> {
    /**
     * 根据年份查询
     *
     * @param year 年份
     * @return 列表
     */
    List<YearPlan> findByYear(String year);

    /**
     * 根据年份和产品分页查询
     *
     * @param year       年份
     * @param production 产品
     * @param pageable    分页
     * @return 列表
     */
    Page<YearPlan> findByYearAndProduction(String year, String production, Pageable pageable);



}
