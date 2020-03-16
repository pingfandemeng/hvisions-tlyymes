package com.hvisions.mes.prodplan.controller;

import com.hvisions.common.vo.ResultVO;
import com.hvisions.mes.core.BaseController;
import com.hvisions.mes.dto.prodplan.IndexListDTO;
import com.hvisions.mes.dto.prodplan.SaveConsumeIndexInfoDTO;
import com.hvisions.mes.dto.prodplan.SearchConsumeIndexDTO;
import com.hvisions.mes.prodplan.service.ConsumeIndexService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @description: 消耗指标控制器
 * @author: Bruce
 * @version:
 * @date: 2019-09-17 16:38
 */
@RestController
@RequestMapping(value = "/consumeIndex")
@Api(description = "消耗指标控制器")
public class ConsumeIndexController extends BaseController {

    @Resource
    private ConsumeIndexService indexService;

    @ApiOperation(value = "新增", response = ResultVO.class)
    @PostMapping("/save")
    public int save(@RequestBody SaveConsumeIndexInfoDTO indexInfoDTO) {
        return indexService.save(indexInfoDTO, getCurrentUser());
    }

    @ApiOperation(value = "查询消耗指标", response = IndexListDTO.class)
    @PostMapping("/list")
    public Page<IndexListDTO> list(@RequestBody SearchConsumeIndexDTO indexDTO) {
        return indexService.list(indexDTO);
    }

    @ApiOperation(value = "删除消耗指标", response = ResultVO.class)
    @DeleteMapping("/delete/{typeId}/{indexId}")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "typeId", value = "类型id", paramType = "path", required = true, defaultValue = "0", dataType = "Integer"),
        @ApiImplicitParam(name = "indexId", value = "消耗指标id", paramType = "path", required = true,defaultValue = "0", dataType = "Integer")
    })
    public int delete(@PathVariable("typeId") int typeId, @PathVariable("indexId") int indexId) {
        return indexService.delIndex(typeId, indexId, getCurrentUser());
    }

    @ApiOperation(value = "更新消耗指标(包括指标类型)", response = ResultVO.class)
    @PutMapping("/update")
    public int update(@RequestBody SaveConsumeIndexInfoDTO typeDTO) {
        return indexService.update(typeDTO, getCurrentUser());
    }

    @ApiOperation(value = "一键添加", response = ResultVO.class)
    @PostMapping("/aKeyToAdd/{date}")
    @ApiImplicitParam(name = "date", value = "日期（格式：yyyy-MM-dd）", paramType = "path", required = true, defaultValue = "", dataType = "String")
    public int aKeyToAdd(@PathVariable("date") String date) {
        return indexService.aKeyToAdd(date, getCurrentUser());
    }

    @ApiOperation(value = "查询bom item", response = ResultVO.class)
    @GetMapping("/findBomItem")
    public List<Map<String, Object>> findBomItem() {
        return indexService.findBomItem();
    }
}
