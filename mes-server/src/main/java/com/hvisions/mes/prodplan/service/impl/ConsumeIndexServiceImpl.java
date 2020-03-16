package com.hvisions.mes.prodplan.service.impl;

import com.hvisions.common.exception.BaseKnownException;
import com.hvisions.common.utils.PageHelperUtil;
import com.hvisions.mes.dto.prodplan.SearchConsumeIndexDTO;
import com.hvisions.mes.enums.Constant;
import com.hvisions.mes.enums.MesExceptionEnum;
import com.hvisions.mes.prodplan.dao.TindexMapper;
import com.hvisions.mes.prodplan.dao.TtypeMapper;
import com.hvisions.mes.prodplan.entity.Tindex;
import com.hvisions.mes.prodplan.entity.Ttype;
import com.hvisions.mes.dto.prodplan.IndexListDTO;
import com.hvisions.mes.dto.prodplan.SaveConsumeIndexInfoDTO;
import com.hvisions.mes.prodplan.service.ConsumeIndexService;
import com.hvisions.mes.util.DateUtil8;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Map;

import static com.hvisions.mes.util.DateUtil8.getNowDate_EN;

/**
 * @author: Bruce
 * @version:
 * @description: 消费指标业务实现
 * @date: 2019-09-17 14:55
 */
@Service
public class ConsumeIndexServiceImpl implements ConsumeIndexService {

    @Resource
    private TtypeMapper ttypeMapper;

    @Resource
    private TindexMapper tindexMapper;

    @Override
    public int save(SaveConsumeIndexInfoDTO saveConsumeIndexInfoDTO, Integer currUserId) {
        String[] split = saveConsumeIndexInfoDTO.getDate().split("-");
        Ttype ttype = ttypeMapper.findByYearAndMonthAndName(split[0], split[1],
                saveConsumeIndexInfoDTO.getTypeName(), saveConsumeIndexInfoDTO.getProdLine());

        Date date = new Date();
        if (null == ttype) {
            ttype = new Ttype();
            ttype.setProdLine(saveConsumeIndexInfoDTO.getProdLine());
            ttype.setName(saveConsumeIndexInfoDTO.getTypeName());
            ttype.setYear(split[0]);
            ttype.setMonth(split[1]);
            ttype.setCreateTime(date);
            ttype.setCreatorId(currUserId);
            ttype.setUpdateTime(date);
            ttype.setUpdaterId(currUserId);
            ttypeMapper.insert(ttype);
        } else {
            int count = tindexMapper.countByTypeIdAndKey(ttype.getId(), saveConsumeIndexInfoDTO.getIndexKey());
            if (count > 0) {
                throw new BaseKnownException(MesExceptionEnum.INDEX_EXIST);
            }
        }

        Tindex tindex = new Tindex();
        tindex.setIndexKey(saveConsumeIndexInfoDTO.getIndexKey());
        tindex.setIndexValue(saveConsumeIndexInfoDTO.getIndexValue());
        tindex.setSpec(saveConsumeIndexInfoDTO.getSpec());
        tindex.setTypeId(ttype.getId());
        tindex.setCreateTime(date);
        tindex.setCreatorId(currUserId);
        tindex.setUpdateTime(date);
        tindex.setUpdaterId(currUserId);
        tindexMapper.insert(tindex);
        return 1;
    }

    @Override
    public Page<IndexListDTO> list(SearchConsumeIndexDTO dto) {
        if (StringUtils.isBlank(dto.getDate())) {
            dto.setDate(getNowDate_EN());
        }
        String[] split = dto.getDate().split("-");
        dto.setYear(split[0]);
        dto.setMonth(split[1]);
        return PageHelperUtil.getPage(ttypeMapper::findList, dto, IndexListDTO.class);
    }

    @Override
    public int delIndex(Integer typeId, Integer id, Integer currUserId) {
        if (null != typeId && null != id) {
            Date date = new Date();
            // 先删除指标信息
            Tindex tindex = new Tindex();
            tindex.setId(id);
            tindex.setIsDel(Constant.YES_DEL.getCode());
            tindex.setUpdateTime(date);
            tindex.setUpdaterId(currUserId);
            tindexMapper.updateByPrimaryKey(tindex);

            // 再查询改类型下是否还存在指标，如果不存在指标了，那么把类型也进行删除
            int count = tindexMapper.countByTypeId(typeId);
            if (count == 0) {
                // 删除类型（产线，类型等）
                Ttype ttype = new Ttype();
                ttype.setId(typeId);
                ttype.setIsDel(Constant.YES_DEL.getCode());
                ttype.setUpdateTime(date);
                ttype.setUpdaterId(currUserId);
                ttypeMapper.updateByPrimaryKey(ttype);
            }
        }
        return 1;
    }

    @Override
    public int update(SaveConsumeIndexInfoDTO typeDTO, Integer currUserId) {
        if (null != typeDTO.getTypeId()) {
            Ttype ttype = new Ttype();
            ttype.setId(typeDTO.getTypeId());
            ttype.setUpdateTime(new Date());
            ttype.setUpdaterId(currUserId);
            ttype.setName(typeDTO.getTypeName());
            ttype.setProdLine(typeDTO.getProdLine());
            ttypeMapper.updateByPrimaryKey(ttype);
        }
        if (null != typeDTO.getIndexId()) {
            Tindex tindex = new Tindex();
            tindex.setId(typeDTO.getIndexId());
            tindex.setIndexKey(typeDTO.getIndexKey());
            tindex.setIndexValue(typeDTO.getIndexValue());
            tindex.setSpec(typeDTO.getSpec());
            tindex.setUpdateTime(new Date());
            tindex.setUpdaterId(currUserId);
            tindexMapper.updateByPrimaryKey(tindex);
        }
        return 1;
    }

    @Override
    public int aKeyToAdd(String date, Integer currUserId) {
        if (StringUtils.isNotBlank(date)) {
            String monthDate = DateUtil8.getLastMonthDate(date);
            String[] split = monthDate.split("-");

            List<Ttype> list = ttypeMapper.findLastMonthInfo(split[0], split[1]);
            split = date.split("-");
            for (Ttype ttype : list) {
                ttype.setYear(split[0]);
                ttype.setMonth(split[1]);
                ttype.setUpdateTime(new Date());
                ttype.setUpdaterId(currUserId);
                ttypeMapper.updateByPrimaryKey(ttype);
            }
        }
        return 1;
    }

    @Override
    public List<Map<String, Object>> findBomItem() {
        return ttypeMapper.findBomItem();
    }
}
