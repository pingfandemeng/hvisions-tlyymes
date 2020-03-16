package com.hvisions.mes.postleak.service;

import com.hvisions.mes.dto.postleak.PostLeakListDTO;
import com.hvisions.mes.dto.postleak.SavePostLeakInfoDTO;
import com.hvisions.mes.dto.postleak.SavePostLeakLogDTO;
import com.hvisions.mes.dto.postleak.SearchPostLeakDTO;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * @description: 岗位漏点服务接口
 * @author: Bruce
 * @version:
 * @date: 2019-11-04 17:27
 */
public interface PostLeakService {

    /**
     * 保存岗位漏点信息
     * @param dto 漏点信息
     * @param currUserId 当前登录用户
     * @return 结果
     */
    int save(SavePostLeakInfoDTO dto, Integer currUserId);

    /**
     * 删除岗位漏点信息
     * @param id 岗位漏点信息主键
     * @param currUserId 当前登录用户
     * @return 结果
     */
    int delete(Integer id, Integer currUserId);

    /**
     * 列表
     * @param dto 搜索条件
     * @return 结果
     */
    Page<PostLeakListDTO> list(SearchPostLeakDTO dto);

    /**
     * 修改
     * @param dto 修改参数
     * @param currUserId 当前登录人
     * @return 结果
     */
    int update(SavePostLeakInfoDTO dto, Integer currUserId);

    /**
     * 处理情况
     * @param dto 处理内容
     * @param currUserId 当前登录人
     * @return 结果
     */
    int dispose(SavePostLeakLogDTO dto, Integer currUserId);

    /**
     * 复核确认
     * @param id 主键
     * @param currUserId 当前登录人
     * @return 结果
     */
    int review(Integer id, Integer currUserId, String backup);

    /**
     * 查询需要进行提醒的信息
     * @return
     */
    List<PostLeakListDTO> findRemind();
}
