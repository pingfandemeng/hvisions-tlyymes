package com.hvisions.mes.qualitycontrol.repository;

import com.hvisions.mes.qualitycontrol.entity.DeviationManagement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @Author: Lau
 * @Description:
 * @Date: Created in 9:14 2020/1/7
 * @Modified By:
 */
@Repository
public interface DeviationManagementRepostory extends JpaRepository<DeviationManagement, Integer> {

}
