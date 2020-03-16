package com.hvisions.mes.qualitycontrol.service;

import com.hvisions.mes.dto.qualitycontrol.*;
import org.springframework.data.domain.Page;

/**
 * 来料车辆外观检验
 */
public interface IncomingInspectionService {

    /**
     * 新增车辆外观检验数据
     * @param record
     * @return
     */
    int insert(CarCheckDTO record, Integer currUserId);

    /**
     * 保存取样检测
     * @param dto 对象
     * @return 结果
     */
    int saveSample(SaveIncomingInspectionSampleDTO dto, Integer currUserId);

    /**
     * 复核人确认
     * @param baseInfoId 基础信息id
     * @return 结果
     */
    int reviewConfirm(Integer baseInfoId,String result, Integer currUserId);

    /**
     * 放行确认
     * @param baseInfoId 基础信息id
     * @param result 放行结论
     * @return 结果
     */
    int fxConfirm(Integer baseInfoId, Integer result, Integer currUserId);

    /**
     * 接报人确认
     * @param baseInfoId 基础信息id
     * @param isCoaAndInfo 查看供方COA信息与包装信息是否一致（0否，1是）
     * @return 结果
     */
    int jbConfirm(Integer baseInfoId, Integer isCoaAndInfo, Integer currUserId);


    /**
     * 删除基础数据
     * @param id
     * @return
     */
    int deleteByPrimaryKeyBaseInfo(Integer id,Integer currUserId);

    /**
     * 新增基础数据
     * @param dto
     * @return
     */
    int insertBaseInfo(SaveIncomingInspectionBaseInfoDTO dto, Integer currUserId);

    /**
     * 根据id查询基础数据
     * @param id
     * @return
     */
    IncomingInspectionBaseInfoDetailDTO selectByPrimaryKeBaseInfo(Integer id);

    /**
     * 查询所有基础信息
     * @return
     */
    Page<SaveIncomingInspectionBaseInfoDTO> selectAllBaseInfo(SearchIncomingInspectionBaseInfoDTO dto);

    /**
     * 根据id修改基础数据
     * @param record
     * @return
     */
    int updateByPrimaryKeyBaseInfo(SaveIncomingInspectionBaseInfoDTO record,Integer currUserId);

    /**
     * 进行下一步操作改变状态
     * @param
     * @return
     */
    int next(Integer id);




}
