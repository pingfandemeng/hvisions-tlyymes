package com.hvisions.mes.equipment.service;

import com.hvisions.mes.dto.equipment.*;
import com.hvisions.mes.equipment.entity.EquipmentOverhaulPlan;
import com.hvisions.mes.equipment.entity.EquipmentOverhaulPostpone;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * @description: 设备检修计划业务
 * @author: Bruce
 * @version:
 * @date: 2020-01-14 16:56
 */
public interface EquipmentOverhaulPlanService {

    /**
     * 保存
     * @param dto
     * @return
     */
    int save(SaveEquipmentOverhaulDTO dto, Integer currUser);

    /**
     * 修改
     * @param dto
     * @return
     */
    int update(SaveEquipmentOverhaulDTO dto, Integer currUser);

    /**
     * 查询
     * @param dto
     * @return
     */
    Page<SaveEquipmentOverhaulDTO> list(SearchEquipmentOverhaulDTO dto);

    /**
     * 删除
     *
     * @param id
     * @return
     */
    int delete(Integer id, Integer currUser);

    /**
     * 延期
     * @param dto
     * @param currUser
     * @return
     */
    int postpone(PostponeOverhaulDTO dto, Integer currUser);

    /**
     * 开始设备检修
     * @param dto
     * @param currUser
     * @return
     */
    int startOverhaul(OverhaulContentDTO dto, Integer currUser);

    /**
     * 完成设备检修
     * @param id
     * @param amount
     * @param currUser
     * @return
     */
    int endOverhaul(Integer id, Double amount, Integer currUser);

    /**
     * 查询检修记录
     * @param dto
     * @return
     */
    Page<OverhaulLogDTO> findOverhaulLog(OverhaulLogParamsDTO dto);

    /**
     * 查询所有有效的设备检修信息
     * @return
     */
    List<EquipmentOverhaulPlan> findRemind();

    /**
     * 根据设备检修id查询对应的延期记录的最新一条
     * @param equipmentId
     * @return
     */
    EquipmentOverhaulPostpone findPostponeByEquipmentId(Integer equipmentId);

    /**
     * 查询角色名称下面所有的人员
     * @param roleName
     * @return
     */
    List<Integer> findUserIdByRole(String roleName);
}
