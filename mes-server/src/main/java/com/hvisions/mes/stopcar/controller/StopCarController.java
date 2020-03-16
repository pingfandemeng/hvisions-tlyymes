package com.hvisions.mes.stopcar.controller;

import com.hvisions.common.vo.ResultVO;
import com.hvisions.mes.dto.stopcar.ApproveParmDTO;
import com.hvisions.mes.core.BaseController;
import com.hvisions.mes.dto.stopcar.PlanStopCarDTO;
import com.hvisions.mes.dto.stopcar.SearchPlanStopCarDTO;
import com.hvisions.mes.stopcar.service.StopCarService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

/**
 * @description: 计划停车控制器
 * @author: Bruce
 * @version:
 * @date: 2019-11-26 17:44
 */
@RestController
@RequestMapping(value = "/stopCar")
@Api(description = "计划停车控制器")
public class StopCarController extends BaseController {

    @Autowired
    private StopCarService stopCarService;

    @ApiOperation(value = "新增", response = ResultVO.class)
    @PostMapping("/save")
    public int save(@RequestBody PlanStopCarDTO dto) {
        return stopCarService.save(dto, getCurrentUser());
    }

    @ApiOperation(value = "修改", response = ResultVO.class)
    @PutMapping("/update")
    public int update(@RequestBody PlanStopCarDTO dto) {
        return stopCarService.update(dto, getCurrentUser());
    }

    @ApiOperation(value = "删除", response = ResultVO.class)
    @DeleteMapping("/delete/{id}")
    @ApiImplicitParam(name = "id", value = "主键", paramType = "path", required = false, defaultValue = "0", dataType = "Integer")
    public int delete(@PathVariable("id") int id) {
        return stopCarService.delete(id, getCurrentUser());
    }

    @ApiOperation(value = "列表", response = PlanStopCarDTO.class)
    @PostMapping("/list")
    public Page<PlanStopCarDTO> list(@RequestBody SearchPlanStopCarDTO dto) {
        return stopCarService.list(dto);
    }

    @ApiOperation(value = "提交审核", response = ResultVO.class)
    @PutMapping("/submitApprove/{stopCarId}")
    @ApiImplicitParam(name = "stopCarId", value = "停车计划主键", paramType = "path", required = false, defaultValue = "0", dataType = "Integer")
    public int submitApprove(@PathVariable("stopCarId") int stopCarId) {
        return stopCarService.submitApprove(stopCarId, getCurrentUser());
    }

    @ApiOperation(value = "查询需要审核的计划停车列表", response = PlanStopCarDTO.class)
    @PostMapping("/approveList")
    public Page<PlanStopCarDTO> approveList(@RequestBody ApproveParmDTO dto) {
        return stopCarService.approveList(dto);
    }

    @ApiOperation(value = "审核人员确认审核", response = ResultVO.class)
    @PutMapping("/approve/{stopCarId}/{idea}/{status}")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "stopCarId", value = "停车计划主键", paramType = "path", required = false, defaultValue = "0", dataType = "Integer"),
            @ApiImplicitParam(name = "idea", value = "审核意见", paramType = "path", required = false, defaultValue = "", dataType = "String"),
            @ApiImplicitParam(name = "status", value = "审核状态", paramType = "path", required = false, defaultValue = "0", dataType = "Integer")
    })
    public int checkApprove(@PathVariable("stopCarId") int stopCarId, @PathVariable("idea") String idea, @PathVariable("status") int status) {
        return stopCarService.checkApprove(stopCarId, idea, status, getCurrentUser());
    }
}
