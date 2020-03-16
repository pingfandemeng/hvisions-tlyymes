package com.hvisions.mes.prodplan.service;

import com.hvisions.mes.dto.prodplan.DemoEntityDTO;
import com.hvisions.mes.dto.prodplan.DemoQueryDTO;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * <p>Title: DemoEntityService</p>
 * <p>Description: </p>
 * <p>Company: www.h-visions.com</p>
 * <p>create date: 2018/10/23</p>
 *
 * @author :leiming
 * @version :1.0.0
 */
public interface DemoEntityService {


    /**
     * 根据名称查询列表
     *
     * @param name 名称
     * @return 实体dto对象
     */
    List<DemoEntityDTO> findByName(String name);

    /**
     * 根据id列表删除
     *
     * @param ids id列表
     */
    void deleteByIds(List<Integer> ids);

    /**
     * 根据名称和描述模糊查询
     *
     * @param demoQueryDTO 名称
     * @return 分页数据
     */
    Page<DemoEntityDTO> getByName(DemoQueryDTO demoQueryDTO);

    /**
     * 添加实体
     *
     * @param demoEntityDTO 实体对象
     * @return 实体ID
     */
    int save(DemoEntityDTO demoEntityDTO);

    /**
     * 删除实体
     *
     * @param id 实体id
     */
    void deleteById(int id);

    /**
     * 获取所有
     *
     * @return 所有实体列表
     */
    List<DemoEntityDTO> getAll();

    /**
     * 分页查询另外一种实现
     *
     * @param demoQueryDTO 查询对象
     * @return 分页信息
     */
    Page<DemoEntityDTO> getByNameOtherWay(DemoQueryDTO demoQueryDTO);

    /**
     * 查询列表
     *
     * @param demoQueryDTO 查询条件
     * @return list
     */
    List<DemoEntityDTO> getDemoEntityListByMyBatis(DemoQueryDTO demoQueryDTO);

    /**
     * 分页查询
     *
     * @param demoQueryDTO 查询条件
     * @return 分页信息
     */
    Page<DemoEntityDTO> getDemoEntityPageByMyBatis(DemoQueryDTO demoQueryDTO);


}
