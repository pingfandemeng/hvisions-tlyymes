package com.hvisions.mes.qualitycontrol.dao;

import com.hvisions.mes.dto.qualitycontrol.IncomingInspectionBaseInfoDetailDTO;
import com.hvisions.mes.dto.qualitycontrol.SaveIncomingInspectionBaseInfoDTO;
import com.hvisions.mes.dto.qualitycontrol.SearchIncomingInspectionBaseInfoDTO;
import com.hvisions.mes.qualitycontrol.entity.IncomingInspectionBaseInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;


@Mapper
public interface IncomingInspectionBaseInfoMapper {
    int deleteByPrimaryKey(Integer id);
    int deleteCarCheck(Integer id);
    int deleteConfirmPeople(Integer id);
    int deleteSampleCheck(Integer id);
    int deleteSampleCheckItem(Integer id);
    int deleteSingleWeight(Integer id);



    int insert(IncomingInspectionBaseInfo record);

    SaveIncomingInspectionBaseInfoDTO selectByPrimaryKey(SaveIncomingInspectionBaseInfoDTO id);

    List<SaveIncomingInspectionBaseInfoDTO> selectAll(SearchIncomingInspectionBaseInfoDTO dto);

    int updateByPrimaryKey(SaveIncomingInspectionBaseInfoDTO record);

    int next(Integer id);

    IncomingInspectionBaseInfoDetailDTO selectDetail (Integer id);

    int confirmCoaAndInfo(@Param("isCoaAndInfo") Integer isCoaAndInfo, @Param("id") Integer id);
}
