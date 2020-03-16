package com.hvisions.mes.baseinfo.controller;

import com.hvisions.common.dto.ExtendColumnInfo;
import com.hvisions.common.service.BaseExtendService;
import com.hvisions.common.vo.ResultVO;
import com.hvisions.mes.baseinfo.entity.tSupplierInfo;
import com.hvisions.mes.baseinfo.service.SupplierInfoService;
import com.hvisions.mes.dto.baseinfo.SaveSupplierInfoDTO;
import com.hvisions.mes.dto.baseinfo.SearchSupplierInfoDTO;
import com.hvisions.mes.util.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * Description:
 * Author:   ljj3hao
 * Time:     2019/10/16
 * Version:  1.0.0
 */

@RestController
@RequestMapping(value = "/supplierInfo")
@Slf4j
@Api(description = "供应商信息维护Controller")
public class SupplierInfoController  {

    private final SupplierInfoService supplierInfoService;


    @Autowired
    public SupplierInfoController(SupplierInfoService supplierInfoService){
        this.supplierInfoService =  supplierInfoService;
    }

    @Resource(name = "incoming_inspection_extend")
    BaseExtendService extendService;

    /**
     * 新增供应商信息
     *
     * @param supplierInfoDTO 传入的对象
     * @return 添加后的实体Id
     */
    @ApiOperation(value = "新增供应商信息")
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public int add(@RequestBody SaveSupplierInfoDTO supplierInfoDTO) {
        return supplierInfoService.save(supplierInfoDTO);
    }

    /**
     * 修改供应商信息
     *
     * @param supplierInfoDTO 传入的对象
     * @return 添加后的实体Id
     */
    @ApiOperation(value = "修改供应商信息")
    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public int update(@RequestBody SaveSupplierInfoDTO supplierInfoDTO) {
        return supplierInfoService.update(supplierInfoDTO);

    }

    /**
     * 删除供应商消息
     *
     * @param id 实体id
     */
    @ApiOperation(value = "删除供应商消息")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable int id) {
        supplierInfoService.delete(id);
    }

    /**
     * 根据供应商名称和简称查询
     *
     * @param searchSupplierInfoDTO 查询对象
     * @return 分页数据
     */
    @ApiOperation(value = "根据名称和简称分页查询")
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public Page<SaveSupplierInfoDTO> search(@RequestBody SearchSupplierInfoDTO searchSupplierInfoDTO) {
        return supplierInfoService.list(searchSupplierInfoDTO);
    }


    /**
     * 根据id查询信息
     *
     * @param
     * @return 分页数据
     */
    @ApiOperation(value = "根据id查询")
    @RequestMapping(value = "/searchById/{id}", method = RequestMethod.POST)
    public tSupplierInfo searchById(@PathVariable("id")Integer id) {
        return supplierInfoService.selectByPrimaryKey(id);
    }


    @ApiOperation(value = "添加供应商扩展字段属性", response = ResultVO.class)
    @PostMapping("/saveExtend")
    public void saveExtend(@RequestBody ExtendColumnInfo extendColumnInfo) {
        extendService.addExtend(extendColumnInfo);
    }

    @ApiOperation(value = "删除供应商扩展字段属性", response = ResultVO.class)
    @DeleteMapping("/delExtend/{name}")
    @ApiImplicitParam(name = "name", value = "要删除的属性名", paramType = "path", required = false, defaultValue = "", dataType = "String")
    public void delExtend(@PathVariable("name") String name) {
        extendService.dropExtend(name);
    }

    @ApiOperation(value = "获取供应商扩展字段属性列表", response = ResultVO.class)
    @GetMapping("/getExtend")
    public List<ExtendColumnInfo> getExtend() {
        return extendService.getExtendColumnInfo();
    }
}
