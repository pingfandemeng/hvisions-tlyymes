package com.hvisions.mes.equipment.dao;

import com.hvisions.mes.dto.equipment.OverhaulLogDTO;
import com.hvisions.mes.dto.equipment.OverhaulLogParamsDTO;
import com.hvisions.mes.equipment.entity.EquipmentOverhaulLog;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface EquipmentOverhaulLogMapper {
    int deleteByPrimaryKey(@Param("id") Integer id, @Param("equipmentOverhaulId") Integer equipmentOverhaulId);

    int insert(EquipmentOverhaulLog record);

    List<OverhaulLogDTO> selectByPrimaryKey(OverhaulLogParamsDTO dto);

    List<EquipmentOverhaulLog> selectAll();

    int updateByPrimaryKey(EquipmentOverhaulLog record);

    int updateByIdAndEquipmentId(EquipmentOverhaulLog record);

    EquipmentOverhaulLog findNewLog(Integer equipmentOverhaulId);
}