package com.hvisions.mes.dict.service;

import com.hvisions.mes.dto.dict.SaveDictDTO;
import com.hvisions.mes.dto.dict.SearchDictDTO;
import org.springframework.data.domain.Page;

/**
 * @description: 数据字典接口
 * @author: Bruce
 * @version:
 * @date: 2019-11-08 14:49
 */
public interface DictService {

    /**
     * 新增
     * @param dto 对象
     * @param currUserId 当前登录人
     * @return 结果
     */
    int save(SaveDictDTO dto, Integer currUserId);

    /**
     * 删除（物理删除）
     * @param id 主键
     * @return 结果
     */
    int delete(Integer id);

    /**
     * 修改
     * @param dto 对象
     * @param currUserId 当前登录人
     * @return 结果
     */
    int update(SaveDictDTO dto, Integer currUserId);

    /**
     * 查询列表
     * @param dto 搜索条件
     * @return 结果
     */
    Page<SaveDictDTO> list(SearchDictDTO dto);
}
