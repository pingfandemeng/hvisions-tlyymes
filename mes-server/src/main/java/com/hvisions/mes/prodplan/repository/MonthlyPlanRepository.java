package com.hvisions.mes.prodplan.repository;

import com.hvisions.mes.prodplan.entity.MonthlyPlan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Description:月度计划Repository
 * Time:     2019/9/16
 * Version:  1.0.0
 * @author dyxie
 */
@Repository
public interface MonthlyPlanRepository extends JpaRepository<MonthlyPlan, Integer> {



}
