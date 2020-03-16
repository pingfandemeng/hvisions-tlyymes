package com.hvisions.mes.qualitycontrol.dao;

import com.hvisions.mes.qualitycontrol.entity.IncomingInspectionExtend;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface IncomingInspectionExtendMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(IncomingInspectionExtend record);

    IncomingInspectionExtend selectByPrimaryKey(Integer id);

    List<IncomingInspectionExtend> selectAll();

    int updateByPrimaryKey(IncomingInspectionExtend record);
}