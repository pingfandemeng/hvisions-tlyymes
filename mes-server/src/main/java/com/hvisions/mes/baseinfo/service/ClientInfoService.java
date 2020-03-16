package com.hvisions.mes.baseinfo.service;

import com.hvisions.mes.dto.baseinfo.SaveClientInfoDTO;
import com.hvisions.mes.dto.baseinfo.SearchClientInfoDTO;
import org.springframework.data.domain.Page;

/**
 * @description: 客户信息维护
 * @author: Bruce
 * @version:
 * @date: 2019-10-14 15:31
 */
public interface ClientInfoService {

    /**
     * 新增
     * @param dto 对象
     * @return 结果
     */
    int save(SaveClientInfoDTO dto, Integer currUserId);

    /**
     * 修改
     * @param dto 对象
     * @return 结果
     */
    int update(SaveClientInfoDTO dto, Integer currUserId);

    /**
     * 删除
     * @param id 主键
     * @return 结果
     */
    int delete(Integer id, Integer currUserId);

    /**
     * 列表
     * @param dto 搜索条件
     * @return 结果
     */
    Page<SaveClientInfoDTO> list(SearchClientInfoDTO dto);
}
