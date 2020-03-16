package com.hvisions.mes.baseinfo.dao;

import com.hvisions.mes.baseinfo.entity.TclientInfo;
import com.hvisions.mes.dto.baseinfo.SaveClientInfoDTO;
import com.hvisions.mes.dto.baseinfo.SearchClientInfoDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * @author Bruce
 */
@Mapper
public interface TclientInfoMapper {

    /**
     * 删除
     * @param id 主键
     * @return 结果
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 新增
     * @param record 信息
     * @return 结果
     */
    int insert(TclientInfo record);

    /**
     * 查询
     * @param id 主键
     * @return 结果
     */
    TclientInfo selectByPrimaryKey(Integer id);

    /**
     * 查询全部
     * @return 结果
     */
    List<SaveClientInfoDTO> selectAll(SearchClientInfoDTO dto);

    /**
     * 更新
     * @param record 信息
     * @return 结果
     */
    int updateByPrimaryKey(TclientInfo record);

    /**
     * 查询是否存在客户编号和名称
     * @param map 参数
     * @return 结果
     */
    int findNumberAndName(Map<String, String> map);
}