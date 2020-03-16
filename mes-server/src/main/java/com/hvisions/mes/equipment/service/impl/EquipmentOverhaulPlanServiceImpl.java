package com.hvisions.mes.equipment.service.impl;

import com.hvisions.common.exception.BaseKnownException;
import com.hvisions.common.utils.PageHelperUtil;
import com.hvisions.mes.dto.equipment.*;
import com.hvisions.mes.enums.Constant;
import com.hvisions.mes.enums.MesExceptionEnum;
import com.hvisions.mes.equipment.dao.EquipmentOverhaulLogMapper;
import com.hvisions.mes.equipment.dao.EquipmentOverhaulPlanMapper;
import com.hvisions.mes.equipment.dao.EquipmentOverhaulPostponeMapper;
import com.hvisions.mes.equipment.entity.EquipmentOverhaulLog;
import com.hvisions.mes.equipment.entity.EquipmentOverhaulPlan;
import com.hvisions.mes.equipment.entity.EquipmentOverhaulPostpone;
import com.hvisions.mes.equipment.service.EquipmentOverhaulPlanService;
import com.hvisions.mes.util.DateUtil8;
import com.hvisions.mes.util.SysCode;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @description: 设备检修计划业务实现
 * @author: Bruce
 * @version:
 * @date: 2020-01-15 09:37
 */
@Service
public class EquipmentOverhaulPlanServiceImpl implements EquipmentOverhaulPlanService {

    @Autowired
    private EquipmentOverhaulPostponeMapper equipmentOverhaulPostponeMapper;
    @Autowired
    private EquipmentOverhaulPlanMapper equipmentOverhaulPlanMapper;
    @Autowired
    private EquipmentOverhaulLogMapper equipmentOverhaulLogMapper;

    @Override
    public int save(SaveEquipmentOverhaulDTO dto, Integer currUser) {
        Date date = new Date();
        EquipmentOverhaulPlan plan = new EquipmentOverhaulPlan();
        BeanUtils.copyProperties(dto, plan);
        plan.setCreateTime(date);
        plan.setCreatorId(currUser);
        plan.setUpdaterId(currUser);
        plan.setUpdateTime(date);
        plan.setStatus(1);

        return equipmentOverhaulPlanMapper.insert(plan);
    }

    @Override
    public int update(SaveEquipmentOverhaulDTO dto, Integer currUser) {
        if (equipmentOverhaulPlanMapper.findExistById(dto.getId()) != 1) {
            throw new BaseKnownException(MesExceptionEnum.ID_NOT_EXIST);
        }

        OverhaulLogParamsDTO paramsDTO = new OverhaulLogParamsDTO();
        paramsDTO.setEquipmentId(dto.getId());
        paramsDTO.setSort(false);
        paramsDTO.setPageSize(10);
        paramsDTO.setPage(0);
        List<OverhaulLogDTO> logDTOS = equipmentOverhaulLogMapper.selectByPrimaryKey(paramsDTO);
        if (!logDTOS.isEmpty()) {
            throw new BaseKnownException(MesExceptionEnum.EQP_UPDATE_ERROR);
        }

        EquipmentOverhaulPlan overhaul = new EquipmentOverhaulPlan();
        BeanUtils.copyProperties(dto, overhaul);
        Date date = new Date();
        overhaul.setUpdaterId(currUser);
        overhaul.setUpdateTime(date);

        return equipmentOverhaulPlanMapper.updateByPrimaryKey(overhaul);
    }

    @Override
    public Page<SaveEquipmentOverhaulDTO> list(SearchEquipmentOverhaulDTO dto) {
        Page<SaveEquipmentOverhaulDTO> page = PageHelperUtil.getPage(equipmentOverhaulPlanMapper::selectAll, dto, SaveEquipmentOverhaulDTO.class);
        List<SaveEquipmentOverhaulDTO> content = page.getContent();
        for (SaveEquipmentOverhaulDTO dto1 : content) {
            dto1.setStatus(SysCode.equipmentOverhaulStatus.get(Integer.valueOf(dto1.getStatus())));
        }

        return page;
    }

    @Override
    public int  delete(Integer id, Integer currUser) {
        EquipmentOverhaulPlan plan1 = equipmentOverhaulPlanMapper.selectByPrimaryKey(id);
        if (plan1.getStatus() != 1) {
            throw new BaseKnownException(MesExceptionEnum.EQP_DEL_ERROR);
        }
        OverhaulLogParamsDTO dto = new OverhaulLogParamsDTO();
        dto.setEquipmentId(id);
        dto.setPage(0);
        dto.setPageSize(1);
        dto.setSort(false);
        List<OverhaulLogDTO> list = equipmentOverhaulLogMapper.selectByPrimaryKey(dto);
        if (!list.isEmpty()) {
            throw new BaseKnownException(MesExceptionEnum.EQP_DEL_ERROR2);
        }

        Date date = new Date();
        EquipmentOverhaulPlan plan = new EquipmentOverhaulPlan();
        plan.setId(id);
        plan.setUpdaterId(currUser);
        plan.setUpdateTime(date);
        plan.setIsDel(Constant.YES_DEL.getCode());
        equipmentOverhaulPlanMapper.updateByPrimaryKey(plan);

        EquipmentOverhaulLog log = new EquipmentOverhaulLog();
        log.setUpdateTime(date);
        log.setUpdaterId(currUser);
        log.setEquipmentOverhaulId(id);
        log.setIsDel(Constant.YES_DEL.getCode());
        equipmentOverhaulLogMapper.updateByPrimaryKey(log);

        EquipmentOverhaulPostpone postpone = new EquipmentOverhaulPostpone();
        postpone.setEquipmentOverhaulId(id);
        postpone.setUpdateTime(date);
        postpone.setUpdaterId(currUser);
        postpone.setIsDel(Constant.YES_DEL.getCode());
        return equipmentOverhaulPostponeMapper.updateByPrimaryKey(postpone);
    }

    @Override
    public int postpone(PostponeOverhaulDTO dto, Integer currUser) {
        Date date = new Date();
        EquipmentOverhaulPlan plan = new EquipmentOverhaulPlan();
        plan.setId(dto.getEquipmentId());
        plan.setStatus(4);
        plan.setUpdaterId(currUser);
        plan.setUpdateTime(date);
        plan.setOverhaulDate(dto.getPostponeDate());
        equipmentOverhaulPlanMapper.updateByPrimaryKey(plan);

        EquipmentOverhaulPostpone postpone = new EquipmentOverhaulPostpone();
        postpone.setUpdaterId(currUser);
        postpone.setUpdateTime(date);
        postpone.setCreatorId(currUser);
        postpone.setCreateTime(date);
        postpone.setEquipmentOverhaulId(dto.getEquipmentId());
        postpone.setPostponeBackup(dto.getPostponeBackup());
        postpone.setPostponeDate(dto.getPostponeDate());

        return equipmentOverhaulPostponeMapper.insert(postpone);
    }

    @Override
    public int startOverhaul(OverhaulContentDTO dto, Integer currUser) {
        Date date = new Date();
        EquipmentOverhaulPlan plan = new EquipmentOverhaulPlan();
        plan.setId(dto.getId());
        plan.setStatus(2);
        plan.setUpdaterId(currUser);
        plan.setUpdateTime(date);
        plan.setActualDate(date);
        equipmentOverhaulPlanMapper.updateByPrimaryKey(plan);

        EquipmentOverhaulLog log = new EquipmentOverhaulLog();
        log.setEquipmentOverhaulId(dto.getId());
        log.setOverhaulStartTime(date);
        log.setOverhaulContent(dto.getContent());
        log.setOverhaulUserId(currUser);
        log.setCreatorId(currUser);
        log.setCreateTime(date);
        log.setUpdaterId(currUser);
        log.setUpdateTime(date);

        return equipmentOverhaulLogMapper.insert(log);
    }

    @Override
    public int endOverhaul(Integer id, Double amount, Integer currUser) {
        Date date = new Date();

        EquipmentOverhaulPlan overhaulPlan = equipmentOverhaulPlanMapper.selectByPrimaryKey(id);
        String day = DateUtil8.getAfterOrPreDate(
                DateUtil8.convertCurDate(overhaulPlan.getOverhaulDate()), "day", overhaulPlan.getCycle());
        EquipmentOverhaulPlan plan = new EquipmentOverhaulPlan();
        plan.setId(id);
        plan.setStatus(1);
        plan.setUpdaterId(currUser);
        plan.setUpdateTime(date);
        plan.setOverhaulDate(DateUtil8.strToDateYYYYMMdd(day));
        equipmentOverhaulPlanMapper.updateByPrimaryKey(plan);

        EquipmentOverhaulLog log = new EquipmentOverhaulLog();
        log.setId(equipmentOverhaulLogMapper.findNewLog(id).getId());
        log.setEquipmentOverhaulId(id);
        log.setOverhaulEndTime(date);
        log.setOverhaulAmount(BigDecimal.valueOf(amount));
        log.setUpdaterId(currUser);
        log.setUpdateTime(date);
        return equipmentOverhaulLogMapper.updateByIdAndEquipmentId(log);
    }

    @Override
    public Page<OverhaulLogDTO> findOverhaulLog(OverhaulLogParamsDTO dto) {
        return PageHelperUtil.getPage(equipmentOverhaulLogMapper::selectByPrimaryKey, dto, OverhaulLogDTO.class);
    }

    @Override
    public List<EquipmentOverhaulPlan> findRemind() {
        return equipmentOverhaulPlanMapper.findRemind();
    }

    @Override
    public EquipmentOverhaulPostpone findPostponeByEquipmentId(Integer equipmentId) {
        return equipmentOverhaulPostponeMapper.findPostponeByEquipmentId(equipmentId);
    }

    @Override
    public List<Integer> findUserIdByRole(String roleName) {
        return equipmentOverhaulPlanMapper.findUserIdByRole(roleName);
    }
}
