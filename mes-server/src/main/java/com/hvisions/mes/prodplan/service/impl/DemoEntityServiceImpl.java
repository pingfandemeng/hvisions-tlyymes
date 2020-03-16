package com.hvisions.mes.prodplan.service.impl;

import com.hvisions.common.utils.DtoMapper;
import com.hvisions.common.utils.PageHelperUtil;
import com.hvisions.mes.dto.prodplan.DemoEntityDTO;
import com.hvisions.mes.dto.prodplan.DemoQueryDTO;
import com.hvisions.mes.prodplan.dao.DemoEntityMapper;
import com.hvisions.mes.prodplan.entity.DemoEntity;
import com.hvisions.mes.prodplan.repository.DemoEntityRepository;
import com.hvisions.mes.prodplan.service.DemoEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>Title: DemoEntityServiceImp</p>
 * <p>Description: 服务实现层，使用了jpa，与mybatis进行操作</p>
 * <p>Company: www.h-visions.com</p>
 * <p>create date: 2018/10/23</p>
 *
 * @author :leiming
 * @version :1.0.0
 */
@Service
public class DemoEntityServiceImpl implements DemoEntityService {

    /**
     * jpa仓储层
     */
    private final DemoEntityRepository demoEntityRepository;
    /**
     * mybatis仓储层
     */
    private final DemoEntityMapper demoEntityMapper;

    @Autowired
    public DemoEntityServiceImpl(DemoEntityRepository demoEntityRepository, DemoEntityMapper demoEntityMapper) {
        //调用父类的构造函数，传入jpa对象，实现普通的增删改查功能
        this.demoEntityRepository = demoEntityRepository;
        this.demoEntityMapper = demoEntityMapper;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<DemoEntityDTO> findByName(String name) {
        //直接调用仓储层方法，并做类型转换
        return demoEntityRepository.findByNameContains(name).stream()
                //Common层的DtoMapper可以很方便的生成对象并且复制属性值
                .map(t -> DtoMapper.convert(t, DemoEntityDTO.class))
                //转成List格式
                .collect(Collectors.toList());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteByIds(List<Integer> ids) {
        List<DemoEntity> entities = demoEntityRepository.findAllById(ids);
        demoEntityRepository.deleteAll(entities);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Page<DemoEntityDTO> getByName(DemoQueryDTO demoQueryDTO) {
        Page<DemoEntity> demoEntities =
                demoEntityRepository.findByNameContainsAndDescriptionContains(demoQueryDTO.getName(), demoQueryDTO.getDescription(), demoQueryDTO.getRequest());
        //用DtoMapper转换对象
        return DtoMapper.convertPage(demoEntities, DemoEntityDTO.class);
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public int save(DemoEntityDTO demoEntityDTO) {
        return demoEntityRepository.save(DtoMapper.convert(demoEntityDTO, DemoEntity.class)).getId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void deleteById(int id) {
        demoEntityRepository.deleteById(id);
    }

    /**
     * {@inheritDoc}
     */
    @Override

    public List<DemoEntityDTO> getAll() {
        return DtoMapper.convertList(demoEntityRepository.findAll(), DemoEntityDTO.class);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Page<DemoEntityDTO> getByNameOtherWay(DemoQueryDTO demoQueryDTO) {
        ExampleMatcher exampleMatcher = ExampleMatcher.matching()
                //包含，忽略大小写
                .withMatcher("name", ExampleMatcher.GenericPropertyMatchers.contains().ignoreCase())
                .withMatcher("description", ExampleMatcher.GenericPropertyMatchers.contains().ignoreCase());
        Example<DemoEntity> example = Example.of(DtoMapper.convert(demoQueryDTO, DemoEntity.class), exampleMatcher);
        return DtoMapper.convertPage(demoEntityRepository.findAll(example, demoQueryDTO.getRequest()), DemoEntityDTO.class);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<DemoEntityDTO> getDemoEntityListByMyBatis(DemoQueryDTO demoQueryDTO) {
        return DtoMapper.convertList(demoEntityMapper.getDemoEntity(demoQueryDTO), DemoEntityDTO.class);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Page<DemoEntityDTO> getDemoEntityPageByMyBatis(DemoQueryDTO demoQueryDTO) {
        //第一个参数是获取list的方法,需要传递mapper的查询方法，第二个参数是方法需要的参数，第三个对象是如果需要对结果进行类型转换，需要传入的参数，底层使用的BeanUtil.copyProperty
        return PageHelperUtil.getPage(this.demoEntityMapper::getDemoEntity, demoQueryDTO, DemoEntityDTO.class);
    }

}
