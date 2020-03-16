package com.hvisions.mes.dyb.dao;

import com.hvisions.mes.dto.dyb.DybCheckDTO;
import com.hvisions.mes.dyb.entity.DybCheck;
import com.hvisions.mes.dto.dyb.SearchDybCheckDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface DybCheckMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(DybCheck record);

    DybCheck selectByPrimaryKey(Integer id);

    List<DybCheckDTO> selectAll(SearchDybCheckDTO dto);

    int updateByPrimaryKey(DybCheck record);

    int insertExtend(@Param("map") Map<String, Object> map);

    int updateExtend(@Param("map") Map<String, Object> map, @Param("dybId") Integer dybId);

    List<Map<String, Object>>findExtend();

    List<DybCheck> findRemind();
}