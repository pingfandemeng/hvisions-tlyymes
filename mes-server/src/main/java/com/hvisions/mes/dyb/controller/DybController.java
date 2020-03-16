package com.hvisions.mes.dyb.controller;

import com.hvisions.common.dto.ExtendColumnInfo;
import com.hvisions.common.exception.BaseKnownException;
import com.hvisions.common.service.BaseExtendService;
import com.hvisions.common.vo.ResultVO;
import com.hvisions.mes.core.BaseController;
import com.hvisions.mes.dto.dyb.*;
import com.hvisions.mes.dyb.entity.DybCheck;
import com.hvisions.mes.dyb.service.DybService;
import com.hvisions.mes.enums.MesExceptionEnum;
import com.hvisions.mes.util.DateUtil8;
import com.hvisions.mes.util.ExportUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.List;

/**
 * @description: 电仪表校验控制器
 * @author: Bruce
 * @version:
 * @date: 2019-11-26 13:15
 */
@RestController
@RequestMapping(value = "/dyb")
@Api(description = "电仪表校验控制器")
public class DybController extends BaseController {

    @Autowired
    private DybService dybService;

    @Resource(name = "dyb_extend")
    BaseExtendService extendService;

    @ApiOperation(value = "新增电仪表校验信息", response = ResultVO.class)
    @PostMapping("/save")
    public int save(@RequestBody SaveDybCheckDTO dto) {
        return dybService.save(dto, getCurrentUser());
    }

    @ApiOperation(value = "删除电仪表校验信息", response = ResultVO.class)
    @DeleteMapping("/delete/{id}")
    @ApiImplicitParam(name = "id", value = "电仪表校验信息主键", paramType = "path", required = false, defaultValue = "0", dataType = "Integer")
    public int delete(@PathVariable("id") int id) {
        return dybService.delete(id, getCurrentUser());
    }

    @ApiOperation(value = "修改电仪表校验信息", response = ResultVO.class)
    @PutMapping("/update")
    public int update(@RequestBody SaveDybCheckDTO dto) {
        return dybService.update(dto, getCurrentUser());
    }

    @ApiOperation(value = "电仪表校验信息列表", response = DybCheckDTO.class)
    @PostMapping("/list")
    public Page<DybCheckDTO> list(@RequestBody SearchDybCheckDTO dto) {
        return dybService.list(dto);
    }

    @ApiOperation(value = "确认电仪表校验", response = ResultVO.class)
    @PutMapping("/check/{id}/{result}")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "电仪表校验信息主键", paramType = "path", required = false, defaultValue = "0", dataType = "Integer"),
            @ApiImplicitParam(name = "result", value = "校验结果", paramType = "path", required = false, defaultValue = "", dataType = "String")
    })
    public int check(@PathVariable("id") int id, @PathVariable("result") String result) {
        return dybService.checkDyb(id, result, getCurrentUser());
    }

    @ApiOperation(value = "电仪表校验记录列表", response = DybCheckLogDTO.class)
    @PostMapping("/logList")
    public Page<DybCheckLogDTO> checkLog(@RequestBody DybCheckLogParmDTO dto) {
        return dybService.checkLog(dto);
    }

    @ApiOperation(value = "延期校验", response = ResultVO.class)
    @PutMapping("/postpone/{dybId}/{date}")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "dybId", value = "电仪表校验信息主键", paramType = "path", required = false, defaultValue = "0", dataType = "integer"),
            @ApiImplicitParam(name = "date", value = "延期日期(\"yyyy-MM-dd HH:mm\")", paramType = "path", required = false, defaultValue = "", dataType = "string")
    })
    public int postpone(@PathVariable("dybId") int dybId, @PathVariable("date") String date) {
        return dybService.postpone(dybId, date, getCurrentUser());
    }

    @ApiOperation(value = "开始校验", response = ResultVO.class)
    @PutMapping("/startCheck/{dybId}")
    @ApiImplicitParam(name = "dybId", value = "电仪表校验信息主键", paramType = "path", required = false, defaultValue = "0", dataType = "integer")
    public int startCheck(@PathVariable("dybId") int dybId) {
        DybCheck check = new DybCheck();
        check.setStatus(2);
        check.setUpdaterId(null);
        check.setUpdateTime(new Date());
        check.setId(dybId);
        return dybService.updateStatus(check);
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

    @ApiOperation(value = "下载模板")
    @GetMapping("/downTemp")
    public void downTemp(HttpServletRequest request, HttpServletResponse response) {
        HSSFWorkbook wb = null;
        ServletOutputStream stream = null;
        try {
            wb = ExportUtil.excelOut();
            String fileName = "模板" + DateUtil8.getNowDate_EN() + ".xls";
            fileName = new String(fileName.getBytes("gb2312"), "iso8859-1");
            String headStr = "attachment; filename=" + fileName;

            response.setContentType("application/octet-stream");
            response.setHeader("Content-Disposition", headStr);
            stream = response.getOutputStream();
            wb.write(stream);
            stream.flush();
            wb.close();
            stream.close();
        } catch (IOException e) {
            e.printStackTrace();
            throw new BaseKnownException(MesExceptionEnum.TEMP_ERROR);
        }
    }
}
