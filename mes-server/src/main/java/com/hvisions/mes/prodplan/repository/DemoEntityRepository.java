package com.hvisions.mes.prodplan.repository;

import com.hvisions.mes.prodplan.entity.DemoEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>Title: DemoEntityRepository</p>
 * <p>Description: 使用Jpa进行操作</p>
 * <p>Company: www.h-visions.com</p>
 * <p>create date: 2018/10/23</p>
 *
 * @author :leiming
 * @version :1.0.0
 */
@Repository
public interface DemoEntityRepository extends JpaRepository<DemoEntity, Integer> {
    /**
     * 根据名称查询
     *
     * @param name 名称
     * @return 列表
     */
    List<DemoEntity> findByNameContains(String name);

    /**
     * 根据名称和描述查询
     *
     * @param name        名称
     * @param description 描述
     * @param pageable    分页
     * @return demo
     */
    Page<DemoEntity> findByNameContainsAndDescriptionContains(String name, String description, Pageable pageable);

}
