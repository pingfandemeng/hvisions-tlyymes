package com.hvisions.mes.qualitycontrol.controller;

import com.hvisions.common.dto.ExtendColumnInfo;
import com.hvisions.common.service.BaseExtendService;
import com.hvisions.common.vo.ResultVO;
import com.hvisions.mes.core.BaseController;
import com.hvisions.mes.dto.qualitycontrol.*;
import com.hvisions.mes.qualitycontrol.service.IncomingInspectionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * Description:来料检验Controller
 *
 * @author: dyxie yliu jjlu
 * Time:     2019/10/18
 * Version:  1.0.0
 */
@RestController
@RequestMapping(value = "/incomingInspection")
@Slf4j
@Api(description = "来料检验Controller")
public class IncomingInspectionController extends BaseController {

    @Autowired
    private IncomingInspectionService incomingInspectionService;

    @Resource(name = "incoming_inspection_extend")
    BaseExtendService extendService;

    @ApiOperation(value = "新增车辆外观检信息", response = ResultVO.class)
    @PostMapping("/save")
    public int save(@RequestBody CarCheckDTO carCheck){
        return incomingInspectionService.insert(carCheck,getCurrentUser());
    }

    @ApiOperation(value = "保存取样检测信息", response = ResultVO.class)
    @PostMapping("/saveSample")
    public int saveSample(@RequestBody SaveIncomingInspectionSampleDTO dto) {
        return incomingInspectionService.saveSample(dto, getCurrentUser());
    }

    @ApiOperation(value = "复核人确认", response = ResultVO.class)
    @PutMapping("/reviewConfirm/{baseInfoId}/{result}")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "baseInfoId", value = "基础信息id", paramType = "path", required = false, defaultValue = "0", dataType = "Integer"),
            @ApiImplicitParam(name = "result", value = "来料检验结论", paramType = "path", required = false, defaultValue = "0", dataType = "Integer")
    })
    public int reviewConfirm(@PathVariable("baseInfoId") int baseInfoId, @PathVariable("result") String result) {
        return incomingInspectionService.reviewConfirm(baseInfoId,result, getCurrentUser());
    }

    @ApiOperation(value = "放行人确认", response = ResultVO.class)
    @PutMapping("/fxConfirm/{baseInfoId}/{result}")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "baseInfoId", value = "基础信息id", paramType = "path", required = false, defaultValue = "0", dataType = "Integer"),
            @ApiImplicitParam(name = "result", value = "放行结论（0否，1是）", paramType = "path", required = false, defaultValue = "0", dataType = "Integer")
    })
    public int fxConfirm(@PathVariable("baseInfoId") int baseInfoId, @PathVariable("result") int result) {
        return incomingInspectionService.fxConfirm(baseInfoId, result, getCurrentUser());
    }

    @ApiOperation(value = "接报确认", response = ResultVO.class)
    @PutMapping("/jbConfirm/{baseInfoId}/{isCoaAndInfo}")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "baseInfoId", value = "基础信息id", paramType = "path", required = false, defaultValue = "0", dataType = "Integer"),
            @ApiImplicitParam(name = "isCoaAndInfo", value = "查看供方COA信息与包装信息是否一致（0否，1是）", paramType = "path", required = false, defaultValue = "0", dataType = "Integer")
    })
    public int jbConfirm(@PathVariable("baseInfoId") int baseInfoId, @PathVariable("isCoaAndInfo") int isCoaAndInfo) {
        return incomingInspectionService.jbConfirm(baseInfoId, isCoaAndInfo, getCurrentUser());
    }

    @ApiOperation(value = "添加来料检验扩展字段属性", response = ResultVO.class)
    @PostMapping("/saveExtend")
    public void saveExtend(@RequestBody ExtendColumnInfo extendColumnInfo) {
        getCurrentUser();
        extendService.addExtend(extendColumnInfo);
    }

    @ApiOperation(value = "删除来料检验扩展字段属性", response = ResultVO.class)
    @DeleteMapping("/delExtend/{name}")
    @ApiImplicitParam(name = "name", value = "要删除的属性名", paramType = "path", required = false, defaultValue = "", dataType = "String")
    public void delExtend(@PathVariable("name") String name) {
        getCurrentUser();
        extendService.dropExtend(name);
    }

    @ApiOperation(value = "获取来料检验扩展字段属性列表", response = ResultVO.class)
    @GetMapping("/getExtend")
    public List<ExtendColumnInfo> getExtend() {
        return extendService.getExtendColumnInfo();
    }

    @ApiOperation(value = "查询所有基础信息", response = SaveIncomingInspectionBaseInfoDTO.class)
    @RequestMapping(value = "/baseInfoList", method = RequestMethod.POST)
    public Page<SaveIncomingInspectionBaseInfoDTO> selectAllBaseInfo(@RequestBody SearchIncomingInspectionBaseInfoDTO dto){
            return incomingInspectionService.selectAllBaseInfo(dto);
    }

    @ApiOperation(value = "根据key查询基础信息的详情", response = IncomingInspectionBaseInfoDetailDTO.class)
    @RequestMapping(value = "/baseInfoFindByKeyDetail/{id}", method = RequestMethod.POST)
    public IncomingInspectionBaseInfoDetailDTO selectByPrimaryKeyBaseInfoDetail(@PathVariable("id")Integer id){
        return incomingInspectionService.selectByPrimaryKeBaseInfo(id);
    }

    @ApiOperation(value = "新增基础信息", response = ResultVO.class)
    @PostMapping("/baseInfoSave")
    public int saveBaseInfo(@RequestBody SaveIncomingInspectionBaseInfoDTO dto){
        return incomingInspectionService.insertBaseInfo(dto,getCurrentUser());
    }

    @ApiOperation(value = "修改基础信息", response = ResultVO.class)
    @PutMapping("/baseInfoUpdate")
    public int updateBaseInfo(@RequestBody SaveIncomingInspectionBaseInfoDTO carCheck){
        return incomingInspectionService.updateByPrimaryKeyBaseInfo(carCheck,getCurrentUser());
    }

    @ApiOperation(value = "删除基础信息", response = ResultVO.class)
    @DeleteMapping("/baseInfoDelete/{id}")
    public int deleteBaseInfo(@PathVariable("id") Integer id){
        return incomingInspectionService.deleteByPrimaryKeyBaseInfo(id,getCurrentUser());
    }


    @ApiOperation(value = "修改操作状态", response = ResultVO.class)
    @PutMapping("/next/{id}")
    public int next(@PathVariable("id") Integer id){
        return incomingInspectionService.next(id);
    }


}
