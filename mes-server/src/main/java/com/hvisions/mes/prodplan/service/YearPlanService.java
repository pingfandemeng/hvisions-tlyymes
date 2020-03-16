package com.hvisions.mes.prodplan.service;

import com.hvisions.mes.dto.prodplan.AutoScheduleDTO;
import com.hvisions.mes.dto.prodplan.YearPlanDTO;
import com.hvisions.mes.dto.prodplan.YearplanQueryDTO;
import org.springframework.data.domain.Page;

import java.text.ParseException;
import java.util.List;

public interface YearPlanService {
    /**
     * 根据年份查询
     *
     * @param year 年份
     * @return 实体dto对象
     */
    List<YearPlanDTO> findByYear(String year);

    /**
     * 新增年计划
     *
     * @param yearplanDTO 实体对象
     */
    int save(YearPlanDTO yearplanDTO);


    /**
     * 更新年计划
     *
     * @param yearplanDTO 实体对象
     */
    int update(YearPlanDTO yearplanDTO);

    /**
     * 删除年计划
     *
     * @param id 实体id
     */
    void deleteById(int id);
    /**
     * 删除多条年计划
     *
     * @param ids id列表
     */
    void deleteByIds(List<Integer> ids);
    /**
     * 获取所有信息
     *
     * @return 所有实体列表
     */
    List<YearPlanDTO> getAll();

    /**
     * 根据年份和产品模糊查询
     *
     * @param yearplanQueryDTO
     * @return 分页数据
     */
    Page<YearPlanDTO> getByYear(YearplanQueryDTO yearplanQueryDTO);

    /**
     * 根据名称和描述模糊查询（另一种方法）
     *
     * @param yearplanQueryDTO 名称
     * @return 分页数据
     */
    Page<YearPlanDTO> getPageByYearOtherWay(YearplanQueryDTO yearplanQueryDTO);


    /**
     * 根据Id查询是否已经排产
     */
    int selectPC(int id);


    /**
     *  自动排产
     * @param autoScheduleDTO  自动排产dto
     * @throws ParseException 日期转换异常
     */
    void autoSchedule(AutoScheduleDTO autoScheduleDTO) throws ParseException;
}

