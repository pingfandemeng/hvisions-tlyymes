package com.hvisions.mes.qualitycontrol.dao;

import com.hvisions.mes.qualitycontrol.entity.IncomingInspectionSampleCheckItem;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface IncomingInspectionSampleCheckItemMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(IncomingInspectionSampleCheckItem record);

    IncomingInspectionSampleCheckItem selectByPrimaryKey(Integer id);

    List<IncomingInspectionSampleCheckItem> selectAll();

    int updateByPrimaryKey(IncomingInspectionSampleCheckItem record);

    List<IncomingInspectionSampleCheckItem> selectBySampleId(@Param("id") Integer id,
                                                             @Param("checkType") String checkType);
}