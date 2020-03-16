package com.hvisions.mes.baseinfo.service.impl;

import com.hvisions.common.utils.DtoMapper;
import com.hvisions.mes.baseinfo.dao.SupplierInfoMapper;
import com.hvisions.mes.baseinfo.entity.tSupplierInfo;
import com.hvisions.mes.dto.baseinfo.SaveSupplierInfoDTO;
import com.hvisions.mes.enums.Constant;
import com.hvisions.mes.baseinfo.service.SupplierInfoService;
import com.hvisions.mes.dto.baseinfo.SearchSupplierInfoDTO;
import com.hvisions.mes.prodplan.repository.SupplierInfoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Description:
 * Author:   ljj3hao
 * Time:     2019/10/16
 * Version:  1.0.0
 */
@Service
public class SupplierInfoServiceImpl implements SupplierInfoService {

    private final SupplierInfoRepository supplierInfoRepository;

    @Autowired
    private SupplierInfoMapper suppliorInfoMapper;


    @Autowired
    public SupplierInfoServiceImpl(SupplierInfoRepository supplierInfoRepository) {
        //调用父类的构造函数，传入jpa对象，实现普通的增删改查功能
        this.supplierInfoRepository = supplierInfoRepository;


    }
    /**
     * 新增
     *
     * @param dto
     * @return 结果
     * @pa对象
     */
    @Override
    public int save(SaveSupplierInfoDTO dto) {
        tSupplierInfo info = new tSupplierInfo();
        BeanUtils.copyProperties(dto, info);
        info.setCreateTime(new Date());
        info.setUpdateTime(new Date());
  //      info.setIsDel(Constant.NO_DEL.getCode());
        return supplierInfoRepository.save(DtoMapper.convert(dto, tSupplierInfo.class)).getId();
    }

    /**
     * 修改
     *
     * @param dto 对象
     * @return 结果
     */
    @Override
    public int update(SaveSupplierInfoDTO dto) {
        tSupplierInfo info = new tSupplierInfo();
        BeanUtils.copyProperties(dto, info);
        info.setUpdateTime(new Date());
   //     info.setIsDel(Constant.NO_DEL.getCode());
        return supplierInfoRepository.save(DtoMapper.convert(dto, tSupplierInfo.class)).getId();
    }

    /**
     * 删除
     *
     * @param id 主键
     * @return 结果
     */
    @Override
    public void delete(int id) {
        tSupplierInfo info = new tSupplierInfo();
        info.setId(id);
        info.setUpdateTime(new Date());
        info.setIsDel(Constant.YES_DEL.getCode());
        supplierInfoRepository.save(info);

    }

    /**
     * 列表
     *
     * @param dto 搜索条件
     * @return 结果
     */
    @Override
    public Page<SaveSupplierInfoDTO> list(SearchSupplierInfoDTO dto) {
        ExampleMatcher exampleMatcher = ExampleMatcher.matching()
                //包含，忽略大小写
                .withMatcher("name", ExampleMatcher.GenericPropertyMatchers.contains().ignoreCase())
                .withMatcher("nameShort", ExampleMatcher.GenericPropertyMatchers.contains().ignoreCase())
                .withMatcher( "isDel",ExampleMatcher.GenericPropertyMatchers.contains().ignoreCase());
        Example<tSupplierInfo> example = Example.of(DtoMapper.convert(dto, tSupplierInfo.class), exampleMatcher);
        return DtoMapper.convertPage(supplierInfoRepository.findAll(example, dto.getRequest()),SaveSupplierInfoDTO.class);

    }

    @Override
    public tSupplierInfo selectByPrimaryKey(Integer id) {
        return suppliorInfoMapper.selectByPrimaryKey(id);
    }
}
