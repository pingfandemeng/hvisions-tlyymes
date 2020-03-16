package com.hvisions.mes.qualitycontrol.service.impl;

import com.hvisions.common.utils.DtoMapper;
import com.hvisions.common.utils.PageHelperUtil;
import com.hvisions.mes.dto.qualitycontrol.*;
import com.hvisions.mes.enums.Constant;
import com.hvisions.mes.qualitycontrol.dao.*;
import com.hvisions.mes.qualitycontrol.entity.*;
import com.hvisions.mes.qualitycontrol.service.IncomingInspectionService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Description:
 *
 * @author: dyxie yliu jjlu
 * Time:     2019/10/18
 * Version:  1.0.0
 */
@Service
public class IncomingInspectionServiceImpl implements IncomingInspectionService {

    @Autowired
    private IncomingInspectionCarCheckMapper inspectionCarCheckMapper;

    @Autowired
    private IncomingInspectionSampleCheckMapper inspectionSampleCheckMapper;

    @Autowired
    private IncomingInspectionSingleWeightMapper singleWeightMapper;

    @Autowired
    private IncomingInspectionSampleCheckItemMapper checkItemMapper;

    @Autowired
    private IncomingInspectionConfirmPeopleMapper peopleMapper;

    @Autowired
    private IncomingInspectionBaseInfoMapper baseInfoMapper;

    @Autowired
    private IncomingInspectionConfirmPeopleMapper cfpMapper;


    @Override
    public int insert(CarCheckDTO record, Integer currUserId) {
        IncomingInspectionCarCheck carCheck = new IncomingInspectionCarCheck();
        BeanUtils.copyProperties(record, carCheck);
        carCheck.setIsDel(0);
        carCheck.setCreatorId(currUserId);
        carCheck.setCreateTime(new Date());
        carCheck.setUpdaterId(currUserId);
        carCheck.setUpdateTime(new Date());
        carCheck.setCheckUserId(currUserId);
        return inspectionCarCheckMapper.insert(carCheck);
    }

    @Override
    public int saveSample(SaveIncomingInspectionSampleDTO dto, Integer currUserId) {
        Date date = new Date();
        // 处理取样检测
        IncomingInspectionSampleCheck sampleCheck = new IncomingInspectionSampleCheck();
        BeanUtils.copyProperties(dto, sampleCheck);
        sampleCheck.setCreatorId(currUserId);
        sampleCheck.setCreateTime(date);
        sampleCheck.setUpdaterId(currUserId);
        sampleCheck.setUpdateTime(date);
        sampleCheck.setSampleUserId(currUserId);
        inspectionSampleCheckMapper.insert(sampleCheck);

        // 处理单件重量
        IncomingInspectionSingleWeight singleWeight = new IncomingInspectionSingleWeight();
        BeanUtils.copyProperties(dto, singleWeight);
        singleWeight.setSampleCheckId(sampleCheck.getId());
        singleWeight.setCreatorId(currUserId);
        singleWeight.setCreateTime(date);
        singleWeight.setUpdaterId(currUserId);
        singleWeight.setUpdateTime(date);
        singleWeightMapper.insert(singleWeight);

        // 处理外观性状
        if (null != dto.getOutwardList()) {
            for (IncomingInspectionSampleItemDTO itemDTO : dto.getOutwardList()) {
                IncomingInspectionSampleCheckItem sampleCheckItem = new IncomingInspectionSampleCheckItem();
                BeanUtils.copyProperties(itemDTO, sampleCheckItem);
                sampleCheckItem.setCheckType("wgxz");
                sampleCheckItem.setSampleCheckId(sampleCheck.getId());
                sampleCheckItem.setCreatorId(currUserId);
                sampleCheckItem.setCreateTime(date);
                sampleCheckItem.setUpdaterId(currUserId);
                sampleCheckItem.setUpdateTime(date);
                checkItemMapper.insert(sampleCheckItem);
            }
        }
        // 处理理化指标
        if (null != dto.getLhIndexList()) {
            for (IncomingInspectionSampleItemDTO itemDTO : dto.getLhIndexList()) {
                IncomingInspectionSampleCheckItem sampleCheckItem = new IncomingInspectionSampleCheckItem();
                BeanUtils.copyProperties(itemDTO, sampleCheckItem);
                sampleCheckItem.setCheckType("lhzb");
                sampleCheckItem.setSampleCheckId(sampleCheck.getId());
                sampleCheckItem.setCreatorId(currUserId);
                sampleCheckItem.setCreateTime(date);
                sampleCheckItem.setUpdaterId(currUserId);
                sampleCheckItem.setUpdateTime(date);
                checkItemMapper.insert(sampleCheckItem);
            }
        }

        // 处理检测结论
        IncomingInspectionConfirmPeople people = new IncomingInspectionConfirmPeople();
        people.setBaseInfoId(dto.getBaseInfoId());
        people.setResult(dto.getResult());
        people.setUpdaterId(currUserId);
        people.setUpdateTime(date);
        people.setCheckUserId(currUserId);
        people.setCheckUserDate(date);
        peopleMapper.updateByBaseInfoId(people);
        return 1;
    }

    @Override
    public int reviewConfirm(Integer baseInfoId, String result, Integer currUserId) {
        if (null != baseInfoId) {
            Date date = new Date();
            IncomingInspectionConfirmPeople people = new IncomingInspectionConfirmPeople();
            people.setBaseInfoId(baseInfoId);
            people.setUpdaterId(currUserId);
            people.setUpdateTime(date);
            people.setReviewUserId(currUserId);
            people.setReviewDate(date);
            return peopleMapper.updateByBaseInfoId(people);
        }
        return 0;
    }

    @Override
    public int fxConfirm(Integer baseInfoId, Integer result, Integer currUserId) {
        if (null != baseInfoId) {
            Date date = new Date();
            IncomingInspectionConfirmPeople people = new IncomingInspectionConfirmPeople();
            people.setBaseInfoId(baseInfoId);
            people.setUpdaterId(currUserId);
            people.setUpdateTime(date);
            people.setFxUserId(currUserId);
            people.setFxDate(date);
            people.setFxResult(result);
            return peopleMapper.updateByBaseInfoId(people);
        }
        return 0;
    }

    @Override
    public int jbConfirm(Integer baseInfoId, Integer isCoaAndInfo, Integer currUserId) {
        if (null != baseInfoId) {
            baseInfoMapper.confirmCoaAndInfo(isCoaAndInfo, baseInfoId);
            IncomingInspectionConfirmPeople people = new IncomingInspectionConfirmPeople();
            people.setJbUserId(currUserId);
            people.setJbDate(new Date());
            people.setUpdaterId(currUserId);
            people.setUpdateTime(new Date());
            people.setBaseInfoId(baseInfoId);
            return peopleMapper.updateByBaseInfoId(people);
        }
        return 0;
    }


    @Override
    public int deleteByPrimaryKeyBaseInfo(Integer id, Integer currUserId) {

        baseInfoMapper.deleteByPrimaryKey(id);
        baseInfoMapper.deleteCarCheck(id);
        baseInfoMapper.deleteConfirmPeople(id);
        baseInfoMapper.deleteSampleCheck(id);
        baseInfoMapper.deleteSampleCheckItem(id);
        baseInfoMapper.deleteSingleWeight(id);
        return 0;
    }

    /**
     * 新增基础数据
     *
     * @param dto
     * @return
     */
    @Override
    public int insertBaseInfo(SaveIncomingInspectionBaseInfoDTO dto, Integer currUserId) {
        IncomingInspectionBaseInfo baseInfo = new IncomingInspectionBaseInfo();
        BeanUtils.copyProperties(dto, baseInfo);
        baseInfo.setCreatorId(currUserId);
        baseInfo.setCreateTime(new Date());
        baseInfo.setUpdaterId(currUserId);
        baseInfo.setUpdateTime(new Date());
        baseInfo.setIsDel(Constant.NO_DEL.getCode());
        baseInfo.setState(Constant.ZERO_CURR_STATE.getCode());
        baseInfoMapper.insert(baseInfo);

        IncomingInspectionConfirmPeople confirmPeople = new IncomingInspectionConfirmPeople();
        confirmPeople.setIsDel(Constant.NO_DEL.getCode());
        confirmPeople.setBaseInfoId(baseInfo.getId());
        confirmPeople.setBjUserId(baseInfo.getCreatorId());
        confirmPeople.setBjDate(baseInfo.getCreateTime());
        cfpMapper.insert(confirmPeople);

        return baseInfo.getId();
    }

    /**
     * 根据id查询基础数据
     *
     * @param id
     * @return
     */
    @Override
    public IncomingInspectionBaseInfoDetailDTO selectByPrimaryKeBaseInfo(Integer id) {

        IncomingInspectionBaseInfoDetailDTO result = baseInfoMapper.selectDetail(id);
        IncomingInspectionSampleCheck sampleCheck = inspectionSampleCheckMapper.selectByBaseInfoId(id);
        if (null != result && sampleCheck != null) {
            result.setOutwardList(DtoMapper.convertList(
                    checkItemMapper.selectBySampleId(sampleCheck.getId(), "wgxz"), IncomingInspectionSampleItemDTO.class));
            result.setLhIndexList(DtoMapper.convertList(
                    checkItemMapper.selectBySampleId(sampleCheck.getId(), "lhzb"), IncomingInspectionSampleItemDTO.class));
        }
        return result;
    }

    /**
     * 查询所有基础信息
     *
     * @return
     */
    @Override
    public Page<SaveIncomingInspectionBaseInfoDTO> selectAllBaseInfo(SearchIncomingInspectionBaseInfoDTO dto) {
        return PageHelperUtil.getPage(baseInfoMapper::selectAll, dto, SaveIncomingInspectionBaseInfoDTO.class);
    }

    /**
     * 根据id修改基础数据
     *
     * @param dto
     * @return
     */
    @Override
    public int updateByPrimaryKeyBaseInfo(SaveIncomingInspectionBaseInfoDTO dto, Integer currUserId) {
        SaveIncomingInspectionBaseInfoDTO baseInfo = new SaveIncomingInspectionBaseInfoDTO();
        BeanUtils.copyProperties(dto, baseInfo);
        baseInfo.setUpdaterId(currUserId);
        baseInfo.setUpdateTime(new Date());
        return baseInfoMapper.updateByPrimaryKey(baseInfo);
    }


    /**
     * 进行下一步操作改变状态
     *
     * @param
     * @return
     */
    @Override
    public int next(Integer id) {

        return baseInfoMapper.next(id);
    }


}
