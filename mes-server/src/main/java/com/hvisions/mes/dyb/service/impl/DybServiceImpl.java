package com.hvisions.mes.dyb.service.impl;

import com.hvisions.common.exception.BaseKnownException;
import com.hvisions.common.utils.PageHelperUtil;
import com.hvisions.mes.dto.dyb.*;
import com.hvisions.mes.dyb.dao.DybCheckLogMapper;
import com.hvisions.mes.dyb.dao.DybCheckMapper;
import com.hvisions.mes.dyb.entity.DybCheck;
import com.hvisions.mes.dyb.entity.DybCheckLog;
import com.hvisions.mes.dyb.service.DybService;
import com.hvisions.mes.enums.Constant;
import com.hvisions.mes.enums.MesExceptionEnum;
import com.hvisions.mes.util.DateUtil8;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @description: 电仪表校验服务
 * @author: Bruce
 * @version:
 * @date: 2019-11-25 14:49
 */
@Service
public class DybServiceImpl implements DybService {

    @Autowired
    private DybCheckMapper dybCheckMapper;

    @Autowired
    private DybCheckLogMapper dybCheckLogMapper;

    @Override
    public int save(SaveDybCheckDTO dto, Integer currUserId) {
        Date date = new Date();
        DybCheck check = new DybCheck();
        BeanUtils.copyProperties(dto, check);
        check.setCreateTime(date);
        check.setUpdateTime(date);
        check.setCreatorId(currUserId);
        check.setUpdaterId(currUserId);
        check.setStatus(1);
        dybCheckMapper.insert(check);

        DybCheckLog log = new DybCheckLog();
        log.setDybCheckId(check.getId());
        log.setCreateTime(date);
        log.setCreatorId(currUserId);
        log.setPlantCheckTime(dto.getPlantCheckTime());
        log.setUpdaterId(currUserId);
        log.setUpdateTime(date);
        dybCheckLogMapper.insert(log);

        Map<String, Object> map = dto.getExtendMap();
        map.put("dyb_id", check.getId());

        return dybCheckMapper.insertExtend(map);
    }

    @Override
    public int update(SaveDybCheckDTO dto, Integer currUserId) {
        DybCheck check = new DybCheck();
        BeanUtils.copyProperties(dto, check);
        check.setUpdateTime(new Date());
        check.setUpdaterId(currUserId);
        dybCheckMapper.updateByPrimaryKey(check);

        if (!dto.getExtendMap().isEmpty()) {
            dybCheckMapper.updateExtend(dto.getExtendMap(), check.getId());
        }
        return 1;
    }

    @Override
    public Page<DybCheckDTO> list(SearchDybCheckDTO dto) {
        Page<DybCheckDTO> page = PageHelperUtil.getPage(dybCheckMapper::selectAll, dto, DybCheckDTO.class);
        List<DybCheckDTO> list = page.getContent();
        List<Map<String, Object>> extend = dybCheckMapper.findExtend();
        for (DybCheckDTO checkDTO : list) {
            for (Map<String, Object> map : extend) {
                if (checkDTO.getId() == map.get("dyb_id")) {
                    checkDTO.setExtend(map);
                    break;
                }
            }
        }
        return page;
    }

    @Override
    public int delete(Integer id, Integer currUserId) {
        DybCheck dybCheck = dybCheckMapper.selectByPrimaryKey(id);
        if (dybCheck.getStatus() != 1) {
            throw new BaseKnownException(MesExceptionEnum.EQP_DEL_ERROR);
        }
        DybCheck check = new DybCheck();
        check.setId(id);
        check.setIsDel(Constant.YES_DEL.getCode());
        check.setUpdaterId(currUserId);
        check.setUpdateTime(new Date());
        return dybCheckMapper.updateByPrimaryKey(check);
    }

    @Override
    public int checkDyb(Integer dybId, String checkResult, Integer currUserId) {
        DybCheck check1 = dybCheckMapper.selectByPrimaryKey(dybId);
        String remindDate = null;
        switch (check1.getCheckPeriod()) {
            case "1":
                remindDate = DateUtil8.getAfterOrPreDate(
                        DateUtil8.convertCurDate(check1.getPlantCheckTime()), "week", 1);
            break;
            case "2":
                remindDate = DateUtil8.getAfterOrPreDate(
                        DateUtil8.convertCurDate(check1.getPlantCheckTime()), "month", 1);
            break;
            case "3":
                remindDate = DateUtil8.getAfterOrPreDate(
                        DateUtil8.convertCurDate(check1.getPlantCheckTime()), "month", 6);
            break;
            case "4":
                remindDate = DateUtil8.getAfterOrPreDate(
                        DateUtil8.convertCurDate(check1.getPlantCheckTime()), "month", 12);
            break;
            default:
        }

        Date date = new Date();
        DybCheck check = new DybCheck();
        check.setId(dybId);
        check.setPlantCheckTime(null != remindDate? DateUtil8.strToDateYYYYMMdd(remindDate):null);
        check.setUpdateTime(date);
        check.setUpdaterId(currUserId);
        check.setStatus(4);
        dybCheckMapper.updateByPrimaryKey(check);

        DybCheckLog log = new DybCheckLog();
        log.setDybCheckId(dybId);
        log.setUpdateTime(date);
        log.setUpdaterId(currUserId);
        log.setRealityCheckTime(date);
        log.setCheckResult(checkResult);
        return dybCheckLogMapper.updateByDybId(log);
    }

    @Override
    public Page<DybCheckLogDTO> checkLog(DybCheckLogParmDTO dto) {
        return PageHelperUtil.getPage(dybCheckLogMapper::selectAll, dto, DybCheckLogDTO.class);
    }

    @Override
    public int postpone(Integer dybId, String postponeDate, Integer currUserId) {
        DybCheck check = new DybCheck();
        Date date = new Date();
        check.setId(dybId);
        check.setStatus(3);
        check.setUpdaterId(currUserId);
        check.setUpdateTime(date);
        check.setPlantCheckTime(DateUtil8.strToDateFormat(postponeDate, "yyyy-MM-dd HH:mm"));
        dybCheckMapper.updateByPrimaryKey(check);

        DybCheckLog log = new DybCheckLog();
        log.setDybCheckId(dybId);
        log.setPlantCheckTime(DateUtil8.strToDateFormat(postponeDate, "yyyy-MM-dd HH:mm"));
        log.setUpdaterId(currUserId);
        log.setUpdateTime(date);
        return dybCheckLogMapper.updateByDybId(log);
    }

    @Override
    public List<DybCheck> remind() {
        return dybCheckMapper.findRemind();
    }

    @Override
    public int updateStatus(DybCheck dybCheck) {
        return dybCheckMapper.updateByPrimaryKey(dybCheck);
    }
}
