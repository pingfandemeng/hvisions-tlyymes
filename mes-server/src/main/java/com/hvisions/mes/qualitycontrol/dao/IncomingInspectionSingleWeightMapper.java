package com.hvisions.mes.qualitycontrol.dao;

import com.hvisions.mes.qualitycontrol.entity.IncomingInspectionSingleWeight;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface IncomingInspectionSingleWeightMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(IncomingInspectionSingleWeight record);

    IncomingInspectionSingleWeight selectByPrimaryKey(Integer id);

    List<IncomingInspectionSingleWeight> selectAll();

    int updateByPrimaryKey(IncomingInspectionSingleWeight record);
}