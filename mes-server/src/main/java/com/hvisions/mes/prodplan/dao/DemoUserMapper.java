package com.hvisions.mes.prodplan.dao;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hvisions.mes.prodplan.entity.DemoEntity;
import com.hvisions.mes.prodplan.entity.DemoUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * <p>Title: DemoUserMapper</p>
 * <p>Description: 使用MybatisPlus实现的仓储层</p>
 * <p>Company: www.h-visions.com</p>
 * <p>create date: 2019/8/2</p>
 *
 * @author :leiming
 * @version :1.0.0
 */
@Mapper
@Component
public interface DemoUserMapper extends BaseMapper<DemoUser> {


    /**
     * 多表-多条件-分页查询
     *
     * @param page    多条件
     * @param wrapper 分页查询条件包装实体
     * @return 查询结果集
     */
    @Select("select e.name as entityName,e.description as entityDescription,e.user_id as entityUserId," +
            "u.name as userName,u.name as userName,u.description as userDescription " +
            "from demo_entity e \n" +
            "left join\n" +
            "demo_user u on e.user_id=u.id ${ew.customSqlSegment}")
    IPage<Map<String, Object>> findMoreTableQuery(Page<DemoEntity> page, @Param(Constants.WRAPPER) Wrapper<DemoEntity> wrapper);
}









