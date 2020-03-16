package com.hvisions.mes.prodplan.service;


import com.hvisions.common.vo.ResultVO;
import com.hvisions.materialsmsd.materials.dto.MaterialDTO;
import com.hvisions.mes.dto.prodplan.MonthlyPlanDTO;
import com.hvisions.mes.dto.prodplan.MonthlyPlanQueryDTO;
import com.hvisions.work.plan.dto.IssuerDTO;
import org.springframework.data.domain.Page;

import java.util.List;
/**
 * Description:
 * Time:     2019/9/16
 * Version:  1.0.0
 * @author dyxie
 */
public interface MonthlyPlanService {
    /**
     * 保存月度计划
     * @param monthlyPlanDTO
     * @return
     */
    int save(MonthlyPlanDTO monthlyPlanDTO);


    /**
     * 自动排产
     * @param monthlyPlanDTO
     * @return
     */
    int saveAll(MonthlyPlanDTO monthlyPlanDTO, int num, String year, String production,int id);

    /**
     * 删除月度计划
     * @param id
     */
    void deleteById(int id);

    /**
     * 根据条件查询所有月度计划数据
     * @param monthlyPlanQueryDTO
     * @return
     */
    Page<MonthlyPlanDTO> getAllByCondition(MonthlyPlanQueryDTO monthlyPlanQueryDTO);

    /**
     *  Mybatis的根据条件查询所有月度计划
     * @param monthlyPlanQueryDTO
     * @return
     */
    Page<MonthlyPlanDTO> getMonthlyPlans(MonthlyPlanQueryDTO monthlyPlanQueryDTO);

    /**
     * 月度计划下发
     * @param issuerDTO
     * @return
     */
    ResultVO issuerPlan(IssuerDTO issuerDTO);

    /**
     * 获取所有的产品
     * @return
     */
    List<MaterialDTO> getAllProduction();

}
