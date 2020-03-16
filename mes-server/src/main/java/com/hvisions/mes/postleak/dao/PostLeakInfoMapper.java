package com.hvisions.mes.postleak.dao;

import com.hvisions.mes.dto.postleak.PostLeakListDTO;
import com.hvisions.mes.dto.postleak.SearchPostLeakDTO;
import com.hvisions.mes.postleak.entity.PostLeakInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PostLeakInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(PostLeakInfo record);

    PostLeakInfo selectByPrimaryKey(Integer id);

    List<PostLeakListDTO> selectAll(SearchPostLeakDTO dto);

    int updateByPrimaryKey(PostLeakInfo record);

    List<PostLeakListDTO> findRemind();
}