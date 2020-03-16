package com.hvisions.mes.prodplan.dao;

import com.hvisions.mes.dto.prodplan.DemoQueryDTO;
import com.hvisions.mes.prodplan.entity.DemoUser;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * <p>Title: DemoEntityMapper</p>
 * <p>Description: 使用Mybatis进行操作 </p>
 * <p>Company: www.h-visions.com</p>
 * <p>create date: 2019/6/6</p>
 *
 * @author :leiming
 * @version :1.0.0
 */
@Mapper
@Component
public interface DemoEntityMapper {

    /**
     * 获取实体信息
     *
     * @param queryDTO 实体查询条件
     * @return 实体信息
     */
    List<DemoUser> getDemoEntity(DemoQueryDTO queryDTO);

}









