package com.hvisions.mes.postleak.service.impl;

import com.hvisions.common.utils.PageHelperUtil;
import com.hvisions.mes.dto.postleak.PostLeakListDTO;
import com.hvisions.mes.dto.postleak.SavePostLeakInfoDTO;
import com.hvisions.mes.dto.postleak.SavePostLeakLogDTO;
import com.hvisions.mes.dto.postleak.SearchPostLeakDTO;
import com.hvisions.mes.enums.Constant;
import com.hvisions.mes.postleak.dao.PostLeakInfoLogMapper;
import com.hvisions.mes.postleak.dao.PostLeakInfoMapper;
import com.hvisions.mes.postleak.entity.PostLeakInfo;
import com.hvisions.mes.postleak.entity.PostLeakInfoLog;
import com.hvisions.mes.postleak.service.PostLeakService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @description: 岗位漏点业务
 * @author: Bruce
 * @version:
 * @date: 2019-11-05 10:22
 */
@Service
public class PostLeakServiceImpl implements PostLeakService {

    @Autowired
    private PostLeakInfoMapper postLeakInfoMapper;

    @Autowired
    private PostLeakInfoLogMapper postLeakInfoLogMapper;

    @Override
    public int save(SavePostLeakInfoDTO dto, Integer currUserId) {
        PostLeakInfo info = new PostLeakInfo();
        Date date = new Date();
        BeanUtils.copyProperties(dto, info);
        info.setFindUserId(currUserId);
        info.setFindDate(date);
        info.setCreateTime(date);
        info.setCreatorId(currUserId);
        info.setUpdaterId(currUserId);
        info.setUpdateTime(date);
        postLeakInfoMapper.insert(info);

        PostLeakInfoLog log = new PostLeakInfoLog();
        log.setPostLeakInfoId(info.getId());
        log.setCreatorId(currUserId);
        log.setCreateTime(date);
        log.setUpdaterId(currUserId);
        log.setUpdateTime(date);
        log.setBackup(dto.getBackup());
        return postLeakInfoLogMapper.insert(log);
    }

    @Override
    public int delete(Integer id, Integer currUserId) {
        PostLeakInfo info = new PostLeakInfo();
        info.setId(id);
        info.setUpdateTime(new Date());
        info.setUpdaterId(currUserId);
        info.setIsDel(Constant.YES_DEL.getCode());
        postLeakInfoMapper.updateByPrimaryKey(info);
        return postLeakInfoLogMapper.updateByPostLeakInfoId(id, Constant.YES_DEL.getCode());
    }

    @Override
    public Page<PostLeakListDTO> list(SearchPostLeakDTO dto) {
        return PageHelperUtil.getPage(postLeakInfoMapper::selectAll, dto, PostLeakListDTO.class);
    }

    @Override
    public int update(SavePostLeakInfoDTO dto, Integer currUserId) {
        PostLeakInfo info = new PostLeakInfo();
        BeanUtils.copyProperties(dto, info);
        info.setUpdaterId(currUserId);
        info.setUpdateTime(new Date());
        postLeakInfoMapper.updateByPrimaryKey(info);
        return postLeakInfoLogMapper.updateByBackup(dto.getBackup(), dto.getId());
    }

    @Override
    public int dispose(SavePostLeakLogDTO dto, Integer currUserId) {
        PostLeakInfoLog log = new PostLeakInfoLog();
        BeanUtils.copyProperties(dto, log);
        Date date = new Date();
        log.setDisposeUserId(currUserId);
        log.setDoneDate(date);
        log.setUpdaterId(currUserId);
        log.setUpdateTime(date);
        return postLeakInfoLogMapper.updateByPostLeakId(log);
    }

    @Override
    public int review(Integer id, Integer currUserId, String backup) {
        PostLeakInfo info = new PostLeakInfo();
        Date date = new Date();
        info.setId(id);
        info.setReviewDate(date);
        info.setReviewUserId(currUserId);
        info.setUpdaterId(currUserId);
        info.setUpdateTime(date);
        postLeakInfoLogMapper.updateByBackup(backup, id);
        return postLeakInfoMapper.updateByPrimaryKey(info);
    }

    @Override
    public List<PostLeakListDTO> findRemind() {
        return postLeakInfoMapper.findRemind();
    }
}
