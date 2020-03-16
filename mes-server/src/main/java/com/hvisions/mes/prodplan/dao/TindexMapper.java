package com.hvisions.mes.prodplan.dao;

import com.hvisions.mes.prodplan.entity.Tindex;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Bruce
 */
@Mapper
public interface TindexMapper {

    /**
     * 根据主键删除
     * @param id 主键
     * @return 删除结果
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 保存
     * @param record 保存信息
     * @return 保存结果
     */
    int insert(Tindex record);

    /**
     * 根据主键查询
     * @param id 主键
     * @return 结果对象
     */
    Tindex selectByPrimaryKey(Integer id);

    /**
     * 查询所有
     * @return 查询结果集
     */
    List<Tindex> selectAll();

    /**
     * 根据主键更新
     * @param record 更新信息
     * @return 更新结果
     */
    int updateByPrimaryKey(Tindex record);

    /**
     * 根据typeid查询指标信息
     * @param typeId 类型id
     * @return 指标列表
     */
    List<Tindex> findByTypeId(Integer typeId);

    /**
     * 逻辑删除
     * @param record 删除对象
     * @return 删除结果
     */
    int delByTypeId(Tindex record);

    /**
     * 统计类型下面有多少个指标
     * @param typeId 类型id
     * @return 统计结果
     */
    int countByTypeId(Integer typeId);

    /**
     * 查询类型和消耗指标名称是否存在过
     * @param typeId 类型id
     * @param indexKey 消耗指标
     * @return 结果
     */
    int countByTypeIdAndKey(@Param("typeId") Integer typeId, @Param("indexKey") String indexKey);
}