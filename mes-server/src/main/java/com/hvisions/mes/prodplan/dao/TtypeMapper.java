package com.hvisions.mes.prodplan.dao;

import com.hvisions.mes.dto.prodplan.SearchConsumeIndexDTO;
import com.hvisions.mes.dto.prodplan.IndexListDTO;
import com.hvisions.mes.prodplan.entity.Ttype;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author Bruce
 */
@Mapper
public interface TtypeMapper {

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
    int insert(Ttype record);

    /**
     * 根据主键查询
     * @param id 主键
     * @return  查询对象
     */
    Ttype selectByPrimaryKey(Integer id);

    /**
     * 查询所有
     * @return 查询列表
     */
    List<Ttype> selectAll();

    /**
     * 根据主键更新
     * @param record 更新内容
     * @return 更新结果
     */
    int updateByPrimaryKey(Ttype record);

    /**
     * 条件搜索
     * @param indexDTO 搜索条件
     * @return 查询列表
     */
    List<IndexListDTO> findList(SearchConsumeIndexDTO indexDTO);

    /**
     * 获取当前日期的上个月的信息
     * @param year 年份
     * @param month 月份
     * @return 结果集
     */
    List<Ttype> findLastMonthInfo(@Param("year") String year, @Param("month") String month);

    /**
     * 查询类型
     * @param year 年份
     * @param month 月份
     * @param name 类型名称
     * @param prodLine 产线
     * @return 结果
     */
    Ttype findByYearAndMonthAndName(@Param("year") String year,
                                    @Param("month") String month,
                                    @Param("name") String name,
                                    @Param("prodLine") String prodLine);

    /**
     * 查询bom
     * @return
     */
    List<Map<String, Object>> findBomItem();
}