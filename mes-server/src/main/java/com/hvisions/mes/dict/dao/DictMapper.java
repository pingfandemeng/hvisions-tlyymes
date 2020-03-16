package com.hvisions.mes.dict.dao;

import com.hvisions.mes.dto.dict.SaveDictDTO;
import com.hvisions.mes.dto.dict.SearchDictDTO;
import com.hvisions.mes.dict.entity.Dict;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface DictMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Dict record);

    Dict selectByPrimaryKey(Integer id);

    List<SaveDictDTO> selectAll(SearchDictDTO dto);

    int updateByPrimaryKey(Dict record);

    List<Map<String, Object>> findByType(String type);

    List<Map<String, Object>> findPlantByParentId(Integer parentId);

    List<Map<String, Object>> findAllUser();

    List<Map<String, Object>> findProdLine(String prodLine);

    List<Map<String, Object>> findEquipmentByPlantCode(String plantCode);
}