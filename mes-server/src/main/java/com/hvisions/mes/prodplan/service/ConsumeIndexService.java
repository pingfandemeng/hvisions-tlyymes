package com.hvisions.mes.prodplan.service;

import com.hvisions.mes.dto.prodplan.SearchConsumeIndexDTO;
import com.hvisions.mes.dto.prodplan.IndexListDTO;
import com.hvisions.mes.dto.prodplan.SaveConsumeIndexInfoDTO;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Map;

/**
 * @author: Bruce
 * @version:
 * @description: 消耗指标接口
 * @date: 2019-09-17 14:51
 */
public interface ConsumeIndexService {

    /**
     * 保存消耗指标
     * @param saveConsumeIndexInfoDTO 保存对象
     * @return 保存结果
     */
    int save(SaveConsumeIndexInfoDTO saveConsumeIndexInfoDTO, Integer currUserId);

    /**
     * 搜索列表
     * @param searchConsumeIndexDTO 搜索条件
     * @return 分页信息
     */
    Page<IndexListDTO> list(SearchConsumeIndexDTO searchConsumeIndexDTO);

    /**
     * 删除消耗指标一条数据（逻辑删除）
     * @param typeId 类型id
     * @param id 指标id
     * @return 删除结果
     */
    int delIndex(Integer typeId, Integer id, Integer currUserId);

    /**
     * 修改消耗指标
     * @param typeDTO 修改对象
     * @return 修改结果
     */
    int update(SaveConsumeIndexInfoDTO typeDTO, Integer currUserId);

    /**
     * 一键添加
     * @param date 当前选择的时间
     * @return 处理结果
     */
    int aKeyToAdd(String date, Integer currUserId);

    /**
     * 查询bom
     * @return
     */
    List<Map<String, Object>> findBomItem();
}
