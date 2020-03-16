package com.hvisions.mes.qualitycontrol.controller;

import com.hvisions.common.vo.ResultVO;
import com.hvisions.mes.core.BaseController;
import com.hvisions.mes.dto.qualitycontrol.DeviationManagementDTO;
import com.hvisions.mes.dto.qualitycontrol.SaveDeviationManagementDTO;
import com.hvisions.mes.dto.qualitycontrol.SearchDeviationManagementDTO;
import com.hvisions.mes.qualitycontrol.service.DeviationManagementService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: Lau
 * @Description: 偏差管理控制器
 * @Date: Created in 15:12 2020/1/6
 * @Modified By:
 */
@RestController
@RequestMapping(value = "/deviationManagement")
@Api(description = "偏差管理控制器")
public class DeviationManagementController  extends BaseController {

    @Autowired
    private DeviationManagementService deviationManagementService;

    @ApiOperation(value = "新增偏差管理信息", response = ResultVO.class)
    @PostMapping("/save")
    public int save(@RequestBody SaveDeviationManagementDTO DeviationManagement){
        return deviationManagementService.insert(DeviationManagement);
    }

    @ApiOperation(value = "删除", response = ResultVO.class)
    @DeleteMapping("/delete/{id}")
    @ApiImplicitParam(name = "id", value = "主键", paramType = "path", required = false, defaultValue = "0", dataType = "Integer")
    public void delete(@PathVariable("id") int id) {
        deviationManagementService.delete(id,getCurrentUser());
    }

    /**
     * 上报或复核(仅状态不同 0.新建 1.上报 2.复核 3.已完成)
     * @param dto
     * @return
     */
    @ApiOperation(value = "上报或复核", response = ResultVO.class)
    @PutMapping("/reportOrReview")
    public int reportOrReview(@RequestBody SaveDeviationManagementDTO dto) {
        return deviationManagementService.reportOrReview(dto, getCurrentUser());
    }



    @ApiOperation(value = "列表", response = DeviationManagementDTO.class)
    @PostMapping("/list")
    public Page<DeviationManagementDTO> list(@RequestBody SearchDeviationManagementDTO dto) {
        return deviationManagementService.list(dto);
    }


}
