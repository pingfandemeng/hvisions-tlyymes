package com.hvisions.mes.dyb.service;

import com.hvisions.mes.dto.dyb.*;
import com.hvisions.mes.dyb.entity.DybCheck;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * @description: 电仪表服务接口
 * @author: Bruce
 * @version:
 * @date: 2019-11-25 13:54
 */
public interface DybService {

    /**
     * 保存电仪表校验信息
     * @param dto 对象
     * @param currUserId 当前登录人
     * @return 结果
     */
    int save(SaveDybCheckDTO dto, Integer currUserId);

    /**
     * 修改电仪表校验信息
     * @param dto 对象
     * @param currUserId 当前登录人
     * @return 结果
     */
    int update(SaveDybCheckDTO dto, Integer currUserId);

    /**
     * 搜索电仪表校验信息
     * @param dto 条件
     * @return 分页结果
     */
    Page<DybCheckDTO> list(SearchDybCheckDTO dto);

    /**
     * 删除电仪表信息
     * @param id 主键
     * @param currUserId 当前登陆人
     * @return 结果
     */
    int delete(Integer id, Integer currUserId);

    /**
     * 确认电仪表校验
     * @param dybId 电仪表id
     * @param checkResult 校验结果
     * @param currUserId 当前登录人
     * @return 结果
     */
    int checkDyb(Integer dybId, String checkResult, Integer currUserId);

    /**
     * 查询校验记录
     * @param dto 电仪表id
     * @return 结果
     */
    Page<DybCheckLogDTO> checkLog(DybCheckLogParmDTO dto);

    /**
     * 延期操作
     * @param dybId 电仪表id
     * @param postponeDate 延期日期
     * @param currUserId 当前登陆人
     * @return
     */
    int postpone(Integer dybId, String postponeDate, Integer currUserId);

    /**
     * 查询需要提醒的电仪表校验
     * @return
     */
    List<DybCheck> remind();

    /**
     * 变更状态
     * @param dybCheck
     */
    int updateStatus(DybCheck dybCheck);
}
