package com.hvisions.mes.equipment.controller;

import com.hvisions.common.vo.ResultVO;
import com.hvisions.mes.core.BaseController;
import com.hvisions.mes.dto.equipment.*;
import com.hvisions.mes.equipment.service.EquipmentOverhaulPlanService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

/**
 * @description: 设备检修控制器
 * @author: Bruce
 * @version:
 * @date: 2020-01-15 15:24
 */
@RestController
@RequestMapping(value = "/equipmentOverhaulPlan")
@Api(description = "设备检修控制器")
public class EquipmentOverhaulPlanController extends BaseController {

    @Autowired
    private EquipmentOverhaulPlanService service;

    @ApiOperation(value = "新增", response = ResultVO.class)
    @PostMapping("/save")
    public int save(@RequestBody SaveEquipmentOverhaulDTO dto) {
        return service.save(dto, getCurrentUser());
    }

    @ApiOperation(value = "修改", response = ResultVO.class)
    @PutMapping("/update")
    public int update(@RequestBody SaveEquipmentOverhaulDTO dto) {
        return service.update(dto, getCurrentUser());
    }

    @ApiOperation(value = "条件查询", response = SaveEquipmentOverhaulDTO.class)
    @PostMapping("/list")
    public Page<SaveEquipmentOverhaulDTO> list(@RequestBody SearchEquipmentOverhaulDTO dto) {
        return service.list(dto);
    }

    @ApiOperation(value = "删除", response = ResultVO.class)
    @DeleteMapping("/delete/{id}")
    @ApiImplicitParam(name = "id", value = "主键", paramType = "path", required = false, defaultValue = "0", dataType = "Integer")
    public int delete(@PathVariable("id") int id) {
        return service.delete(id, getCurrentUser());
    }

    @ApiOperation(value = "延期", response = ResultVO.class)
    @PutMapping("/postpone")
    public int postpone(@RequestBody PostponeOverhaulDTO dto) {
        return service.postpone(dto, getCurrentUser());
    }

    @ApiOperation(value = "开始设备检修", response = ResultVO.class)
    @PutMapping("/startOverhaul")
    public int startOverhaul(@RequestBody OverhaulContentDTO dto) {
        return service.startOverhaul(dto, getCurrentUser());
    }

    @ApiOperation(value = "完成设备检修", response = ResultVO.class)
    @PutMapping("/endOverhaul/{id}/{amount}")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "设备检修id", paramType = "path", required = false, defaultValue = "0", dataType = "int"),
            @ApiImplicitParam(name = "amount", value = "检修费用", paramType = "path", required = false, defaultValue = "0", dataType = "double")
    })
    public int endOverhaul(@PathVariable("id") int id, @PathVariable("amount") Double amount) {
        return service.endOverhaul(id, amount, getCurrentUser());
    }

    @ApiOperation(value = "查询检修记录", response = OverhaulLogDTO.class)
    @PostMapping("/logList")
    public Page<OverhaulLogDTO> logList(@RequestBody OverhaulLogParamsDTO dto) {
        return service.findOverhaulLog(dto);
    }
}
