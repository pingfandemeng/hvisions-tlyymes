package com.hvisions.mes.stopcar.dao;

import com.hvisions.mes.dto.stopcar.ApproveParmDTO;
import com.hvisions.mes.dto.stopcar.PlanStopCarDTO;
import com.hvisions.mes.dto.stopcar.SearchPlanStopCarDTO;
import com.hvisions.mes.stopcar.entity.PlanStopCar;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PlanStopCarMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(PlanStopCar record);

    PlanStopCar selectByPrimaryKey(Integer id);

    List<PlanStopCarDTO> selectAll(SearchPlanStopCarDTO dto);

    int updateByPrimaryKey(PlanStopCar record);

    List<PlanStopCarDTO> findApproveList(ApproveParmDTO dto);
}