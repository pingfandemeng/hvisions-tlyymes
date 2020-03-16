package com.hvisions.mes.prodplan.dao;


import com.hvisions.mes.dto.prodplan.YearPlanDTO;
import com.hvisions.mes.dto.prodplan.YearplanQueryDTO;
import com.hvisions.mes.prodplan.entity.YearPlan;
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
public interface YearPlanMapper {

    /**
     * 根据年和产品获取年度计划
     * @param yearPlanDTO
     * @return
     */
   List<YearPlan> findMsgForYearAndPro(YearPlanDTO yearPlanDTO);

    /**
     * 获取年度计划实体List
     * @param yearPlanQueryDTO
     * @return
     */
    List<YearPlanDTO> getYearPlans(YearplanQueryDTO yearPlanQueryDTO);

    /**
     * 根据id查询是否已经排产
     * @param id
     * @return
     */
    int selectPC(@Param("id") int id);

    /**
     * 根据id更新自动排产状态
     * @param id
     * @return
     */
    int changeISPC(@Param("id") int id);

}
