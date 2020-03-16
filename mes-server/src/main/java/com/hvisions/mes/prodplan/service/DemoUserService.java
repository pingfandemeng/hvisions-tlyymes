package com.hvisions.mes.prodplan.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.hvisions.mes.dto.prodplan.DemoQueryDTO;
import com.hvisions.mes.dto.prodplan.DemoUserDTO;
import com.hvisions.mes.prodplan.entity.DemoUser;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Map;

/**
 * <p>Title: DemoUserService</p>
 * <p>Description: User服务。底层使用JPA和Mybatis实现 </p>
 * <p>Company: www.h-visions.com</p>
 * <p>create date: 2018/10/23</p>
 *
 * @author :yangfan
 * @version :1.0.0
 */
public interface DemoUserService extends IService<DemoUser> {

    /**
     * 查询所有
     *
     * @return 查询结果集
     */
    List<DemoUserDTO> myBatisPlusFindAll();

    /**
     * 多条件条件查询
     *
     * @param demoQueryDTO 条件实体对象
     * @return 查询结果集
     */
    List<DemoUserDTO> myBatisPlusConditionsFindBMore(DemoQueryDTO demoQueryDTO);

    /**
     * 多条件分页查询
     *
     * @param demoQueryDTO 条件实体对象
     * @return 查询结果集
     */
    Page myBatisPlusConditionsByPage(DemoQueryDTO demoQueryDTO);

    /**
     * 添加实体
     *
     * @param demoEntityDTO 实体对象
     * @return 影响行数
     */
    int myBatisPlusSaveOrUpdate(DemoUserDTO demoEntityDTO);


    /**
     * 根据id列表删除
     *
     * @param ids id列表
     */
    void myBatisPlusDeleteByIds(List<Integer> ids);

    /**
     * 分页查询
     *
     * @param demoQueryDTO 分页查询条件
     * @return 分页信息列表
     */
    IPage<Map<String, Object>> conditionalMoreTablePageFind(DemoQueryDTO demoQueryDTO);
}
