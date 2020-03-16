package com.hvisions.mes.equipment.dao;

import com.hvisions.mes.dto.equipment.SaveEquipmentOverhaulDTO;
import com.hvisions.mes.dto.equipment.SearchEquipmentOverhaulDTO;
import com.hvisions.mes.equipment.entity.EquipmentOverhaulPlan;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface EquipmentOverhaulPlanMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(EquipmentOverhaulPlan record);

    EquipmentOverhaulPlan selectByPrimaryKey(Integer id);

    List<SaveEquipmentOverhaulDTO> selectAll(SearchEquipmentOverhaulDTO dto);

    int updateByPrimaryKey(EquipmentOverhaulPlan record);

    int findExistById(Integer id);

    List<EquipmentOverhaulPlan> findRemind();

    List<Integer> findUserIdByRole(String roleName);
}