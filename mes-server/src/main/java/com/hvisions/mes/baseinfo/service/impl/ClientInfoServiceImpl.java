package com.hvisions.mes.baseinfo.service.impl;

import com.hvisions.common.exception.BaseKnownException;
import com.hvisions.common.utils.PageHelperUtil;
import com.hvisions.mes.baseinfo.dao.TclientInfoMapper;
import com.hvisions.mes.baseinfo.entity.TclientInfo;
import com.hvisions.mes.enums.Constant;
import com.hvisions.mes.enums.MesExceptionEnum;
import com.hvisions.mes.baseinfo.service.ClientInfoService;
import com.hvisions.mes.dto.baseinfo.SaveClientInfoDTO;
import com.hvisions.mes.dto.baseinfo.SearchClientInfoDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @description: 客户信息维护业务
 * @author: Bruce
 * @version:
 * @date: 2019-10-14 15:34
 */
@Service
public class ClientInfoServiceImpl implements ClientInfoService {

    @Autowired
    private TclientInfoMapper tclientInfoMapper;

    @Override
    public int save(SaveClientInfoDTO dto, Integer currUserId) {
        Map<String, String> map = new HashMap<>();
        map.put("number", dto.getNumber());
        map.put("name", dto.getName());
        int count = tclientInfoMapper.findNumberAndName(map);
        if (count > 0) {
            throw new BaseKnownException(MesExceptionEnum.EXISTS_CLIENT);
        }

        TclientInfo info = new TclientInfo();
        BeanUtils.copyProperties(dto, info);
        info.setCreateTime(new Date());
        info.setCreatorId(currUserId);
        info.setUpdateTime(new Date());
        info.setUpdaterId(currUserId);
        return tclientInfoMapper.insert(info);
    }

    @Override
    public int update(SaveClientInfoDTO dto, Integer currUserId) {
        if (null != dto.getId()) {
            TclientInfo info = new TclientInfo();
            BeanUtils.copyProperties(dto, info);
            info.setUpdateTime(new Date());
            info.setUpdaterId(currUserId);
            tclientInfoMapper.updateByPrimaryKey(info);
        }
        return 1;
    }

    @Override
    public int delete(Integer id, Integer currUserId) {
        if (null != id) {
            TclientInfo info = new TclientInfo();
            info.setId(id);
            info.setUpdateTime(new Date());
            info.setUpdaterId(currUserId);
            info.setIsDel(Constant.YES_DEL.getCode());
            tclientInfoMapper.updateByPrimaryKey(info);
        }
        return 1;
    }

    @Override
    public Page<SaveClientInfoDTO> list(SearchClientInfoDTO dto) {
        return PageHelperUtil.getPage(tclientInfoMapper::selectAll, dto, SaveClientInfoDTO.class);
    }
}
