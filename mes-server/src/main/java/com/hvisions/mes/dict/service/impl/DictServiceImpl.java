package com.hvisions.mes.dict.service.impl;

import com.hvisions.common.utils.PageHelperUtil;
import com.hvisions.mes.dto.dict.SaveDictDTO;
import com.hvisions.mes.dto.dict.SearchDictDTO;
import com.hvisions.mes.dict.dao.DictMapper;
import com.hvisions.mes.dict.entity.Dict;
import com.hvisions.mes.dict.service.DictService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @description: 数据字典业务
 * @author: Bruce
 * @version:
 * @date: 2019-11-08 15:08
 */
@Service
public class DictServiceImpl implements DictService {

    @Autowired
    private DictMapper dictMapper;

    @Override
    public int save(SaveDictDTO dto, Integer currUserId) {
        Dict dict = new Dict();
        BeanUtils.copyProperties(dto, dict);
        dict.setCreateTime(new Date());
        dict.setCreatorId(currUserId);
        dict.setUpdaterId(currUserId);
        dict.setUpdateTime(new Date());
        return dictMapper.insert(dict);
    }

    @Override
    public int delete(Integer id) {
        return dictMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int update(SaveDictDTO dto, Integer currUserId) {
        Dict dict = new Dict();
        BeanUtils.copyProperties(dto, dict);
        dict.setUpdaterId(currUserId);
        dict.setUpdateTime(new Date());
        return dictMapper.updateByPrimaryKey(dict);
    }

    @Override
    public Page<SaveDictDTO> list(SearchDictDTO dto) {
        return PageHelperUtil.getPage(dictMapper::selectAll, dto, SaveDictDTO.class);
    }
}
