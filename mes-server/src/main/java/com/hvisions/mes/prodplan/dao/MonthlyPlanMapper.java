package com.hvisions.mes.prodplan.dao;

import com.hvisions.mes.dto.prodplan.MonthlyPlanDTO;
import com.hvisions.mes.dto.prodplan.MonthlyPlanQueryDTO;
import com.hvisions.mes.prodplan.entity.MonthlyPlan;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 月度计划mapper
 * @author dyxie
 */
@Mapper
@Component
public interface MonthlyPlanMapper {

    /**
     * 获取月度计划实体List
     * @param monthlyPlanQueryDTO
     * @return
     */
    List<MonthlyPlanDTO> getMonthlyPlans(MonthlyPlanQueryDTO monthlyPlanQueryDTO);

    /**
     * 根据年月获取月度计划
     * @param monthlyPlanDTO
     * @return
     */
    List<MonthlyPlan> findMsgForYearAndMonth(MonthlyPlanDTO monthlyPlanDTO);

    /**
     * 修改月度计划总量
     * @param monthlyPlanDTO
     * @return
     */
    int updateAmount(MonthlyPlanDTO monthlyPlanDTO);

    /**
     * 查询物料ID
     * @param production
     * @return
     */
    String selectName(@Param("production") String production);

    /**
     * 根据id更新自动排产状态
     * @param id
     * @return
     */
    int changeISPC(@Param("id") int id);


}
