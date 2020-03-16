package com.hvisions.mes.baseinfo.controller;

import com.hvisions.common.dto.ExtendColumnInfo;
import com.hvisions.common.service.BaseExtendService;
import com.hvisions.common.vo.ResultVO;
import com.hvisions.mes.baseinfo.service.ClientInfoService;
import com.hvisions.mes.core.BaseController;
import com.hvisions.mes.dto.baseinfo.SaveClientInfoDTO;
import com.hvisions.mes.dto.baseinfo.SearchClientInfoDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @description: 客户信息控制器
 * @author: Bruce
 * @version:
 * @date: 2019-10-14 17:31
 */
@RestController
@RequestMapping(value = "/clientInfo")
@Api(description = "客户信息控制器")
public class ClientInfoController extends BaseController {

    @Autowired
    private ClientInfoService clientInfoService;

    @Resource(name = "client_extend")
    BaseExtendService extendService;

    @ApiOperation(value = "新增", response = ResultVO.class)
    @PostMapping("/save")
    public int save(@RequestBody SaveClientInfoDTO dto) {
        return clientInfoService.save(dto, getCurrentUser());
    }

    @ApiOperation(value = "修改", response = ResultVO.class)
    @PutMapping("/update")
    public int update(@RequestBody SaveClientInfoDTO dto) {
        return clientInfoService.update(dto, getCurrentUser());
    }

    @ApiOperation(value = "删除", response = ResultVO.class)
    @DeleteMapping("/delete/{id}")
    @ApiImplicitParam(name = "id", value = "主键", paramType = "path", required = true, defaultValue = "0", dataType = "Integer")
    public int delete(@PathVariable("id") int id) {
        return clientInfoService.delete(id, getCurrentUser());
    }

    @ApiOperation(value = "列表", response = SaveClientInfoDTO.class)
    @PostMapping("/list")
    public Page<SaveClientInfoDTO> list(@RequestBody SearchClientInfoDTO dto) {
        return clientInfoService.list(dto);
    }

    @ApiOperation(value = "添加扩展字段属性", response = ResultVO.class)
    @PostMapping("/saveExtend")
    public void saveExtend(@RequestBody ExtendColumnInfo extendColumnInfo) {
        getCurrentUser();
        extendService.addExtend(extendColumnInfo);
    }

    @ApiOperation(value = "删除扩展字段属性", response = ResultVO.class)
    @DeleteMapping("/delExtend/{name}")
    @ApiImplicitParam(name = "name", value = "要删除的属性名", paramType = "path", required = false, defaultValue = "", dataType = "String")
    public void delExtend(@PathVariable("name") String name) {
        getCurrentUser();
        extendService.dropExtend(name);
    }

    @ApiOperation(value = "获取扩展字段属性列表", response = ResultVO.class)
    @GetMapping("/getExtend")
    public List<ExtendColumnInfo> getExtend() {
        return extendService.getExtendColumnInfo();
    }
}
