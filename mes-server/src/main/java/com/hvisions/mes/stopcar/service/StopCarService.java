package com.hvisions.mes.stopcar.service;

import com.hvisions.mes.dto.stopcar.ApproveParmDTO;
import com.hvisions.mes.dto.stopcar.PlanStopCarDTO;
import com.hvisions.mes.dto.stopcar.SearchPlanStopCarDTO;
import org.springframework.data.domain.Page;

/**
 * @description: 计划停车接口
 * @author: Bruce
 * @version:
 * @date: 2019-11-26 14:40
 */
public interface StopCarService {

    /**
     * 保存计划停车信息
     * @param dto 停车信息
     * @param currUserId 当前登陆人
     * @return 结果
     */
    int save(PlanStopCarDTO dto, Integer currUserId);

    /**
     * 删除计划停车信息
     * @param id 主键
     * @param currUserId 当前登陆人
     * @return 结果
     */
    int delete(Integer id, Integer currUserId);

    /**
     * 修改计划停车信息
     * @param dto 停车信息
     * @param currUserId 当前登陆人
     * @return 结果
     */
    int update(PlanStopCarDTO dto, Integer currUserId);

    /**
     * 查询计划停车信息
     * @param dto 搜索条件
     * @return 结果
     */
    Page<PlanStopCarDTO> list(SearchPlanStopCarDTO dto);

    /**
     * 提交计划停车审核
     * @param stopCarId 计划停车id
     * @param currUserId 当前登陆人
     * @return 结果
     */
    int submitApprove(Integer stopCarId, Integer currUserId);

    /**
     * 查询审核计划停车列表
     * @param dto 审核状态
     * @return 结果
     */
    Page<PlanStopCarDTO> approveList(ApproveParmDTO dto);

    /**
     * 审核人员审核停车计划
     * @param idea 审核意见
     * @param status 审核状态（通过or拒绝）
     * @param currUserId 当前登陆人
     * @return 结果
     */
    int checkApprove(Integer stopCarId, String idea, Integer status, Integer currUserId);
}
