package com.hvisions.mes.qualitycontrol.service;

import com.hvisions.mes.dto.qualitycontrol.SaveDeviationManagementDTO;
import com.hvisions.mes.dto.qualitycontrol.SearchDeviationManagementDTO;
import com.hvisions.mes.dto.qualitycontrol.DeviationManagementDTO;
import org.springframework.data.domain.Page;

/**
 * @Author: Lau
 * @Description: 偏差管理接口
 * @Date: Created in 15:17 2020/1/6
 * @Modified By:
 */
public interface DeviationManagementService {

    /**
     * 新增偏差管理信息
     * @param deviationManagement
     * @return
     */
    int insert(SaveDeviationManagementDTO deviationManagement);

    /**
     * 删除（物理删除）
     * @param id 主键
     */
    void delete(int id, int currentUser);
    /**
     * 修改
     * @param dto 对象
     * @param currentUser 当前登录人
     * @return 结果
     */
    int reportOrReview(SaveDeviationManagementDTO dto, int currentUser);

    /**
     * 根据条件查询实体
     * @param dto
     * @return
     */
    Page<DeviationManagementDTO> list(SearchDeviationManagementDTO dto);
}
