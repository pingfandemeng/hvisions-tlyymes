package com.hvisions.mes.prodplan.controller;

import com.hvisions.mes.dto.prodplan.AutoScheduleDTO;
import com.hvisions.mes.dto.prodplan.MonthlyPlanDTO;
import com.hvisions.mes.prodplan.service.MonthlyPlanService;
import com.hvisions.mes.util.Result;
import com.hvisions.mes.dto.prodplan.YearPlanDTO;
import com.hvisions.mes.dto.prodplan.YearplanQueryDTO;
import com.hvisions.mes.prodplan.service.YearPlanService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

/**
 * Description:
 * Author:   ljj3hao
 * Time:     2019/9/17
 * Version:  1.0.0
 */
@RestController
@RequestMapping(value = "/yearplan")
@Slf4j
@Api(description = "年度计划")
public class YearPlanController {

    private final YearPlanService yearPlanService;
    private final MonthlyPlanService monthlyPlanService;


    @Autowired
    public YearPlanController(YearPlanService yearPlanService,MonthlyPlanService monthlyPlanService) {
        this.yearPlanService = yearPlanService;
        this.monthlyPlanService =  monthlyPlanService;
    }


    /**
     * 新增年计划
     *
     * @param yearplanDTO 传入的对象
     * @return 添加后的实体Id
     */
    @ApiOperation(value = "新增年度计划")
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public int add(@RequestBody YearPlanDTO yearplanDTO) {
        return yearPlanService.save(yearplanDTO);
    }

    /**
     * 修改年度计划
     *
     * @param yearplanDTO 传入的对象
     * @return 添加后的实体Id
     */
    @ApiOperation(value = "修改年度计划")
    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public int update(@RequestBody YearPlanDTO yearplanDTO) {
        return yearPlanService.update(yearplanDTO);
    }

    /**
     * 删除年度计划
     *
     * @param id 实体id
     */
    @ApiOperation(value = "删除年度计划")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable int id) {
        yearPlanService.deleteById(id);
    }

    /**
     * 查询
     *
     * @return 实体列表
     */
    @ApiOperation(value = "获取所有年度计划")
    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    public List<YearPlanDTO> getAll() {
        return yearPlanService.getAll();
    }


    /**
     * 根据年份模糊查询
     *
     * @param yearplanQueryDTO 查询对象
     * @return 分页数据
     */
    @ApiOperation(value = "根据年份和产品分页查询")
    @RequestMapping(value = "/getPageByYear", method = RequestMethod.POST)
    public Page<YearPlanDTO> getByYear(@RequestBody YearplanQueryDTO yearplanQueryDTO) {
        return yearPlanService.getByYear(yearplanQueryDTO);
    }


    /**
     * 根据年份模糊查询(另外一种方法)
     *
     * @param yearplanQueryDTO 查询对象
     * @return 分页数据
     */
    @ApiOperation(value = "根据年份和产品分页查询2")
    @RequestMapping(value = "/getPageByYearOtherWay", method = RequestMethod.POST)
    public Page<YearPlanDTO> getPageByYearOtherWay(@RequestBody YearplanQueryDTO yearplanQueryDTO) {
        return yearPlanService.getPageByYearOtherWay(yearplanQueryDTO);
    }


    /**
     * 自动排产
     * @param
     * @return
     */
    @ApiOperation(value="自动排产")
    @RequestMapping(value = "/addMonthlyPlanAll/{num}/{production}/{year}/{id}", method = RequestMethod.POST)
    public int addAll(@PathVariable("num") Integer num, @PathVariable("year") String year, @PathVariable("production") String production, @PathVariable("id") int id) throws ParseException {
        return monthlyPlanService.saveAll(new MonthlyPlanDTO(),num,year,production,id);
    }

    /**
     *
     * @param id
     * @return
     */
    @ApiOperation(value = "查询是否排产")
    @RequestMapping(value = "/selectPC/{id}", method = RequestMethod.POST)
    public int selectPc(@PathVariable int id) {
        return yearPlanService.selectPC(id);
    }


    /**
     * 自动排产
     * @param autoScheduleDTO 自动排产dto
     * @return
     * @throws ParseException 日期转化异常
     */
    @ApiOperation(value="自动排产")
    @RequestMapping(value = "/autoSchedule", method = RequestMethod.POST)
    public void autoSchedule(@RequestBody AutoScheduleDTO autoScheduleDTO) throws ParseException {
        yearPlanService.autoSchedule(autoScheduleDTO);
    }


}

