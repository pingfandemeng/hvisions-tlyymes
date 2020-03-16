package com.hvisions.mes.prodplan.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hvisions.common.utils.DtoMapper;
import com.hvisions.common.utils.PageHelperUtil;
import com.hvisions.mes.dto.prodplan.DemoQueryDTO;
import com.hvisions.mes.dto.prodplan.DemoUserDTO;
import com.hvisions.mes.prodplan.dao.DemoUserMapper;
import com.hvisions.mes.prodplan.entity.DemoEntity;
import com.hvisions.mes.prodplan.entity.DemoUser;
import com.hvisions.mes.prodplan.service.DemoUserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * <p>Title: DemoEntityServiceImp</p>
 * <p>Description: 服务实现层,使用MybatisPlus进行操作</p>
 * <p>Company: www.h-visions.com</p>
 * <p>create date: 2018/10/23</p>
 *
 * @author :leiming
 * @version :1.0.0
 */
@Service
public class DemoUserServiceImpl extends ServiceImpl<DemoUserMapper, DemoUser> implements DemoUserService {


    private final DemoUserMapper demoUserMapper;

    @Autowired
    public DemoUserServiceImpl(DemoUserMapper demoUserMapper) {

        this.demoUserMapper = demoUserMapper;
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public List<DemoUserDTO> myBatisPlusFindAll() {
        return DtoMapper.convertList(demoUserMapper.selectList(null), DemoUserDTO.class);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<DemoUserDTO> myBatisPlusConditionsFindBMore(DemoQueryDTO demoQueryDTO) {
        LambdaQueryWrapper<DemoUser> wrapper = Wrappers.<DemoUser>lambdaQuery()
                .eq(StringUtils.isNotBlank(demoQueryDTO.getName()), DemoUser::getName, demoQueryDTO.getName())
                .eq(StringUtils.isNotBlank(demoQueryDTO.getDescription()), DemoUser::getDescription, demoQueryDTO.getDescription())
                .ge(null != demoQueryDTO.getCreateTimeBefore(), DemoUser::getCreateTime, demoQueryDTO.getCreateTimeBefore())
                .le(null != demoQueryDTO.getCreateTimeBefore(), DemoUser::getCreateTime, demoQueryDTO.getCreateTimeAfter());
        return DtoMapper.convertList(demoUserMapper.selectList(wrapper), DemoUserDTO.class);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Page<DemoUserDTO> myBatisPlusConditionsByPage(DemoQueryDTO demoQueryDTO) {
        LambdaQueryWrapper<DemoUser> wrapper = Wrappers.<DemoUser>lambdaQuery()
                .like(StringUtils.isNotBlank(demoQueryDTO.getName()), DemoUser::getName, demoQueryDTO.getName())
                .like(StringUtils.isNotBlank(demoQueryDTO.getDescription()), DemoUser::getDescription, demoQueryDTO.getDescription())
                .ge(null != demoQueryDTO.getCreateTimeBefore(), DemoUser::getCreateTime, demoQueryDTO.getCreateTimeBefore())
                .le(null != demoQueryDTO.getCreateTimeBefore(), DemoUser::getCreateTime, demoQueryDTO.getCreateTimeAfter());
        return PageHelperUtil.getPage(demoUserMapper::selectPage, demoQueryDTO, wrapper, DemoUserDTO.class);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int myBatisPlusSaveOrUpdate(DemoUserDTO demoUserDTO) {
        DemoUser demoUser = DtoMapper.convert(demoUserDTO,DemoUser.class);
        demoUserMapper.insert(demoUser);
        return demoUser.getId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void myBatisPlusDeleteByIds(List<Integer> ids) {
        demoUserMapper.deleteBatchIds(ids);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public IPage<Map<String, Object>> conditionalMoreTablePageFind(DemoQueryDTO demoQueryDTO) {
        QueryWrapper<DemoEntity> wrapper = new QueryWrapper<>();
        wrapper.like(StringUtils.isNotBlank(demoQueryDTO.getName()), "e.name", demoQueryDTO.getName());
        return demoUserMapper.findMoreTableQuery(new com.baomidou.mybatisplus.extension.plugins.pagination.Page<>(demoQueryDTO.getPage(), demoQueryDTO.getPageSize()), wrapper);
    }


}
