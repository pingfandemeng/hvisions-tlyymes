package com.hvisions.mes.qualitycontrol.dao;

import com.hvisions.mes.dto.qualitycontrol.DeviationManagementDTO;
import com.hvisions.mes.dto.qualitycontrol.SearchDeviationManagementDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Author: Lau
 * @Description:
 * @Date: Created in 14:38 2020/1/8
 * @Modified By:
 */
@Mapper
public interface DeviationManagementMapper {

    /**
     * 根据条件查询实体
     * @param dto
     * @return
     */
    List<DeviationManagementDTO> selectWithCondition(SearchDeviationManagementDTO dto);
}
