package com.hvisions.mes.qualitycontrol.dao;

import com.hvisions.mes.qualitycontrol.entity.IncomingInspectionConfirmPeople;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface IncomingInspectionConfirmPeopleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(IncomingInspectionConfirmPeople record);

    IncomingInspectionConfirmPeople selectByPrimaryKey(Integer id);

    List<IncomingInspectionConfirmPeople> selectAll();

    int updateByPrimaryKey(IncomingInspectionConfirmPeople record);

    int updateByBaseInfoId(IncomingInspectionConfirmPeople record);
}