package com.hvisions.mes.stopcar.service.impl;

import com.hvisions.common.utils.PageHelperUtil;
import com.hvisions.mes.dto.stopcar.ApproveParmDTO;
import com.hvisions.mes.dto.stopcar.PlanStopCarDTO;
import com.hvisions.mes.dto.stopcar.SearchPlanStopCarDTO;
import com.hvisions.mes.enums.Constant;
import com.hvisions.mes.stopcar.dao.PlanStopCarApproveMapper;
import com.hvisions.mes.stopcar.dao.PlanStopCarMapper;
import com.hvisions.mes.stopcar.entity.PlanStopCar;
import com.hvisions.mes.stopcar.entity.PlanStopCarApprove;
import com.hvisions.mes.stopcar.service.StopCarService;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @description: 计划停车业务
 * @author: Bruce
 * @version:
 * @date: 2019-11-26 16:00
 */
@Service
public class StopCarServiceImpl implements StopCarService {

    @Mapper
    private PlanStopCarMapper planStopCarMapper;

    @Mapper
    private PlanStopCarApproveMapper planStopCarApproveMapper;

    @Override
    public int save(PlanStopCarDTO dto, Integer currUserId) {
        Date date = new Date();
        PlanStopCar car = new PlanStopCar();
        BeanUtils.copyProperties(dto, car);
        car.setCreateTime(date);
        car.setCreatorId(currUserId);
        car.setUpdaterId(currUserId);
        car.setUpdateTime(date);
        planStopCarMapper.insert(car);

        PlanStopCarApprove approve = new PlanStopCarApprove();
        approve.setCreateTime(date);
        approve.setCreatorId(currUserId);
        approve.setUpdaterId(currUserId);
        approve.setUpdateTime(date);
        approve.setPlanStopId(car.getId());
        return planStopCarApproveMapper.insert(approve);
    }

    @Override
    public int delete(Integer id, Integer currUserId) {
        PlanStopCar car = new PlanStopCar();
        car.setId(id);
        car.setUpdaterId(currUserId);
        car.setUpdateTime(new Date());
        car.setIsDel(Constant.YES_DEL.getCode());
        return planStopCarMapper.updateByPrimaryKey(car);
    }

    @Override
    public int update(PlanStopCarDTO dto, Integer currUserId) {
        PlanStopCar car = new PlanStopCar();
        BeanUtils.copyProperties(dto, car);
        car.setUpdaterId(currUserId);
        car.setUpdateTime(new Date());
        return planStopCarMapper.updateByPrimaryKey(car);
    }

    @Override
    public Page<PlanStopCarDTO> list(SearchPlanStopCarDTO dto) {
        return PageHelperUtil.getPage(planStopCarMapper::selectAll, dto, PlanStopCarDTO.class);
    }

    @Override
    public int submitApprove(Integer stopCarId, Integer currUserId) {
        PlanStopCarApprove approve = new PlanStopCarApprove();
        approve.setPlanStopId(stopCarId);
        approve.setUpdateTime(new Date());
        approve.setUpdaterId(currUserId);
        approve.setApproveStatus(Constant.APPROVING.getCode());
        return planStopCarApproveMapper.updateByPlanStopId(approve);
    }

    @Override
    public Page<PlanStopCarDTO> approveList(ApproveParmDTO dto) {
        dto.setApproveStatus(Constant.APPROVING.getCode());
        return PageHelperUtil.getPage(planStopCarMapper::findApproveList, dto, PlanStopCarDTO.class);
    }

    @Override
    public int checkApprove(Integer stopCarId, String idea, Integer status, Integer currUserId) {
        PlanStopCarApprove approve = new PlanStopCarApprove();
        approve.setApproveStatus(status);
        approve.setUpdaterId(currUserId);
        approve.setUpdateTime(new Date());
        approve.setPlanStopId(stopCarId);
        approve.setApproveIdea(idea);
        approve.setApproveUserId(currUserId);
        return planStopCarApproveMapper.updateByPlanStopId(approve);
    }
}
