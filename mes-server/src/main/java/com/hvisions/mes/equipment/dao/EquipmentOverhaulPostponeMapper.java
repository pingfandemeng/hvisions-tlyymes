package com.hvisions.mes.equipment.dao;

import com.hvisions.mes.equipment.entity.EquipmentOverhaulPostpone;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface EquipmentOverhaulPostponeMapper {
    int deleteByPrimaryKey(@Param("id") Integer id, @Param("equipmentOverhaulId") Integer equipmentOverhaulId);

    int insert(EquipmentOverhaulPostpone record);

    EquipmentOverhaulPostpone selectByPrimaryKey(@Param("id") Integer id, @Param("equipmentOverhaulId") Integer equipmentOverhaulId);

    List<EquipmentOverhaulPostpone> selectAll();

    int updateByPrimaryKey(EquipmentOverhaulPostpone record);

    EquipmentOverhaulPostpone findPostponeByEquipmentId(Integer equipmentId);
}