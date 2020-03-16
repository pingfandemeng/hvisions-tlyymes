package com.hvisions.mes.qualitycontrol.dao;

import com.hvisions.mes.qualitycontrol.entity.IncomingInspectionSampleCheck;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface IncomingInspectionSampleCheckMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(IncomingInspectionSampleCheck record);

    IncomingInspectionSampleCheck selectByPrimaryKey(Integer id);

    IncomingInspectionSampleCheck selectByBaseInfoId(Integer id);

    List<IncomingInspectionSampleCheck> selectAll();

    int updateByPrimaryKey(IncomingInspectionSampleCheck record);
}