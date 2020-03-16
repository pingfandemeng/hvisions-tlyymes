package com.hvisions.mes.qualitycontrol.service.impl;

import com.hvisions.common.utils.PageHelperUtil;
import com.hvisions.mes.enums.Constant;
import com.hvisions.mes.dto.qualitycontrol.DeviationManagementDTO;
import com.hvisions.mes.dto.qualitycontrol.SaveDeviationManagementDTO;
import com.hvisions.mes.dto.qualitycontrol.SearchDeviationManagementDTO;
import com.hvisions.mes.qualitycontrol.dao.DeviationManagementMapper;
import com.hvisions.mes.qualitycontrol.entity.DeviationManagement;
import com.hvisions.mes.qualitycontrol.repository.DeviationManagementRepostory;
import com.hvisions.mes.qualitycontrol.service.DeviationManagementService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @Author: Lau
 * @Description:偏差管理业务
 * @Date: Created in 15:19 2020/1/6
 * @Modified By:
 */
@Service
public class DeviationManagementServiceImpl implements DeviationManagementService{


    @Autowired
    DeviationManagementRepostory deviationManagementRepostory;

    @Autowired
    DeviationManagementMapper deviationManagementMapper;



    /**
     * 新增偏差管理信息
     * @param deviationManagement
     * @return
     */
    @Override
    public int insert(SaveDeviationManagementDTO deviationManagement) {
        DeviationManagement entity = new DeviationManagement();
        BeanUtils.copyProperties(deviationManagement,entity);
        //设置状态码(0.新建  1.已上报  2.已复核)
        entity.setStatus(0);
        //设置未删除状态
        entity.setIsDel(Constant.NO_DEL.getCode());
        //entity.setCreateTime(new Date());
        //entity.setUpdateTime(new Date());
        return deviationManagementRepostory.save(entity).getId();
    }

    @Override
    public void delete(int id, int currentUser) {
        DeviationManagement entity = deviationManagementRepostory.findById(id).get();
        entity.setIsDel(Constant.YES_DEL.getCode());
        //entity.setUpdateTime(new Date());
        //entity.setUpdaterId(currentUser);
        deviationManagementRepostory.save(entity);

    }

    @Override
    public int reportOrReview(SaveDeviationManagementDTO dto, int currentUser) {

        DeviationManagement entity = deviationManagementRepostory.findById(dto.getId()).get();

        entity.setStatus(dto.getStatus());
        if(StringUtils.isNotBlank(dto.getReason())){
            entity.setReason(dto.getReason());
        }
        if(StringUtils.isNotBlank(dto.getRemark())){
            entity.setRemark(dto.getRemark());
        }

        entity.setUpdateTime(new Date());
        entity.setUpdaterId(currentUser);
        return deviationManagementRepostory.save(entity).getId();
    }

    @Override
    public Page<DeviationManagementDTO> list(SearchDeviationManagementDTO dto) {
        //远程调用auth服务,根据用户id获取用户部门名称
        /*ResultVO<SysUserDTO> result = sysUserClient.getUser(currentUserId);
        SysUserDTO sysUserDTO = result.getData();
        String departmentName = sysUserDTO.getDepartmentName();
        System.out.println("部门名称=========="+departmentName);*/

        return PageHelperUtil.getPage(deviationManagementMapper::selectWithCondition, dto, DeviationManagementDTO.class);
    }
}
