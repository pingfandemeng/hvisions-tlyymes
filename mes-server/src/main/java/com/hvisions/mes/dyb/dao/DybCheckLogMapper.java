package com.hvisions.mes.dyb.dao;

import com.hvisions.mes.dyb.entity.DybCheckLog;
import com.hvisions.mes.dto.dyb.DybCheckLogDTO;
import com.hvisions.mes.dto.dyb.DybCheckLogParmDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DybCheckLogMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(DybCheckLog record);

    DybCheckLog selectByPrimaryKey(Integer id);

    List<DybCheckLogDTO> selectAll(DybCheckLogParmDTO dto);

    int updateByPrimaryKey(DybCheckLog record);

    int updateByDybId(DybCheckLog record);
}