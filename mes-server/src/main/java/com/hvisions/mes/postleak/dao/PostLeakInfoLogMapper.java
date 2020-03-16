package com.hvisions.mes.postleak.dao;

import com.hvisions.mes.postleak.entity.PostLeakInfoLog;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface PostLeakInfoLogMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(PostLeakInfoLog record);

    PostLeakInfoLog selectByPrimaryKey(Integer id);

    List<PostLeakInfoLog> selectAll();

    int updateByPrimaryKey(PostLeakInfoLog record);

    int updateByPostLeakInfoId(@Param("postLeakInfoId") Integer postLeakInfoId,
                               @Param("isDel") Integer isDel);

    int updateByPostLeakId(PostLeakInfoLog log);

    int updateByBackup(@Param("backup") String backup,
                       @Param("postLeakInfoId") Integer postLeakInfoId);
}