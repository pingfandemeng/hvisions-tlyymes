package com.hvisions.mes.stopcar.dao;

import com.hvisions.mes.stopcar.entity.PlanStopCarApprove;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PlanStopCarApproveMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(PlanStopCarApprove record);

    PlanStopCarApprove selectByPrimaryKey(Integer id);

    List<PlanStopCarApprove> selectAll();

    int updateByPrimaryKey(PlanStopCarApprove record);

    int updateByPlanStopId(PlanStopCarApprove record);
}