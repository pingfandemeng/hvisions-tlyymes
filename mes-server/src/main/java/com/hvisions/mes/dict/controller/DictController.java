package com.hvisions.mes.dict.controller;

import com.hvisions.common.vo.ResultVO;
import com.hvisions.mes.core.BaseController;
import com.hvisions.mes.dict.service.DictService;
import com.hvisions.mes.dto.dict.SaveDictDTO;
import com.hvisions.mes.dto.dict.SearchDictDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

/**
 * @description: 数据字典控制器
 * @author: Bruce
 * @version:
 * @date: 2019-11-08 15:27
 */
@RestController
@RequestMapping(value = "/dict")
@Api(description = "数据字典控制器")
public class DictController extends BaseController {

    @Autowired
    private DictService dictService;

    @ApiOperation(value = "新增", response = ResultVO.class)
    @PostMapping("/save")
    public int save(@RequestBody SaveDictDTO dto) {
        return dictService.save(dto, getCurrentUser());
    }

    @ApiOperation(value = "删除", response = ResultVO.class)
    @DeleteMapping("/delete/{id}")
    @ApiImplicitParam(name = "id", value = "主键", paramType = "path", required = false, defaultValue = "0", dataType = "Integer")
    public int delete(@PathVariable("id") int id) {
        getCurrentUser();
        return dictService.delete(id);
    }

    @ApiOperation(value = "列表", response = SaveDictDTO.class)
    @PostMapping("/list")
    public Page<SaveDictDTO> list(@RequestBody SearchDictDTO dto) {
        return dictService.list(dto);
    }

    @ApiOperation(value = "修改", response = ResultVO.class)
    @PutMapping("/update")
    public int update(@RequestBody SaveDictDTO dto) {
        return dictService.update(dto, getCurrentUser());
    }
}
