package com.hvisions.mes.baseinfo.service;

import com.hvisions.mes.baseinfo.entity.tSupplierInfo;
import com.hvisions.mes.dto.baseinfo.SaveSupplierInfoDTO;
import com.hvisions.mes.dto.baseinfo.SearchSupplierInfoDTO;
import org.springframework.data.domain.Page;

public interface SupplierInfoService {
    /**
     * 新增
     * @pa对象
     * @return 结果
     */
    int save(SaveSupplierInfoDTO dto);

    /**
     * 修改
     * @param dto 对象
     * @return 结果
     */
    int update(SaveSupplierInfoDTO dto);

    /**
     * 删除
     * @param id 主键
     * @return 结果
     */
    void delete(int id);

    /**
     * 列表
     * @param dto 搜索条件
     * @return 结果
     */
    Page<SaveSupplierInfoDTO> list(SearchSupplierInfoDTO dto);


    /**
     * 根据ID查询数据
     * @param id
     * @return
     */
    tSupplierInfo selectByPrimaryKey(Integer id);
}
