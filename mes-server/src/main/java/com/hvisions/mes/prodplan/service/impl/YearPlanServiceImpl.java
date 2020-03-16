package com.hvisions.mes.prodplan.service.impl;

import com.hvisions.common.exception.BaseKnownException;
import com.hvisions.common.utils.DtoMapper;
import com.hvisions.common.utils.PageHelperUtil;
import com.hvisions.mes.dto.prodplan.AutoScheduleDTO;
import com.hvisions.mes.enums.Constant;
import com.hvisions.mes.enums.MesExceptionEnum;
import com.hvisions.mes.prodplan.dao.YearPlanMapper;
import com.hvisions.mes.prodplan.entity.YearPlan;
import com.hvisions.mes.prodplan.repository.YearPlanRepository;
import com.hvisions.work.plan.client.WorkPlanClient;
import com.hvisions.work.plan.dto.HvPmWorkPlanAddAndUpdateDTO;
import com.hvisions.mes.prodplan.dao.MonthlyPlanMapper;
import com.hvisions.mes.dto.prodplan.YearPlanDTO;
import com.hvisions.mes.dto.prodplan.YearplanQueryDTO;
import com.hvisions.mes.prodplan.service.YearPlanService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Description:
 * Author:   ljj3hao
 * Time:     2019/9/17
 * Version:  1.0.0
 */
@Service
public class YearPlanServiceImpl implements YearPlanService {


    private final YearPlanRepository yearPlanRepository;
    private final YearPlanMapper yearPlanMapper;
    private final MonthlyPlanMapper monthlyPlanMapper;
    @Autowired
    private WorkPlanClient workPlanClient;

    @Autowired
    public YearPlanServiceImpl(YearPlanRepository yearPlanRepository, YearPlanMapper yearPlanMapper, MonthlyPlanMapper monthlyPlanMapper) {
        //调用父类的构造函数，传入jpa对象，实现普通的增删改查功能
        this.yearPlanRepository = yearPlanRepository;
        this.yearPlanMapper = yearPlanMapper;
        this.monthlyPlanMapper = monthlyPlanMapper;
    }

    /**
     * 根据年份查询
     *
     * @param year 年份
     * @return 实体dto对象
     */
    @Override
    public List<YearPlanDTO> findByYear(String year) {
        return yearPlanRepository.findByYear(year).stream()
                .map(t -> DtoMapper.convert(t, YearPlanDTO.class))
                .collect(Collectors.toList());
    }


    /**
     * 新增年计划
     *
     * @param yearplanDTO 实体对象
     */
    @Override
    public int save(YearPlanDTO yearplanDTO) {
        //查找该年该产品的年度计划是否已存在
        List<YearPlan> msgForYearAndPro = yearPlanMapper.findMsgForYearAndPro(yearplanDTO);
        if (msgForYearAndPro.size() > 0) {
            throw new BaseKnownException(MesExceptionEnum.EXISTS_YEAR_PLAN);
        } else {
            return yearPlanRepository.save(DtoMapper.convert(yearplanDTO, YearPlan.class)).getId();
        }
    }

    /**
     * 更新年计划
     *
     * @param yearplanDTO 实体对象
     */
    @Override
    public int update(YearPlanDTO yearplanDTO) {
        //查找该年该产品的年度计划是否已存在
        yearplanDTO.setIsPc(Constant.NO_PC.getCode());
        List<YearPlan> msgForYearAndPro = yearPlanMapper.findMsgForYearAndPro(yearplanDTO);
        if (msgForYearAndPro.size() > 0) {
            throw new BaseKnownException(MesExceptionEnum.EXISTS_YEAR_PLAN);
        } else {
            return yearPlanRepository.save(DtoMapper.convert(yearplanDTO, YearPlan.class)).getId();
        }
    }

    /**
     * 删除年计划
     *
     * @param id 实体id
     */
    @Override
    public void deleteById(int id) {
        yearPlanRepository.deleteById(id);
    }

    /**
     * 获取所有年计划
     *
     * @return 所有实体列表
     */
    @Override
    public List<YearPlanDTO> getAll() {
        return DtoMapper.convertList(yearPlanRepository.findAll(), YearPlanDTO.class);
    }

    /**
     * 删除多条年计划
     *
     * @param ids id列表
     */
    @Override
    public void deleteByIds(List<Integer> ids) {

    }

    /**
     * 根据年份和产品来查询
     * {@inheritDoc}
     */
    @Override
    public Page<YearPlanDTO> getByYear(YearplanQueryDTO yearplanQueryDTO) {
        Page<YearPlan> yearplan =
                yearPlanRepository.findByYearAndProduction(yearplanQueryDTO.getYear(), yearplanQueryDTO.getProduction(), yearplanQueryDTO.getRequest());
        //用DtoMapper转换对象
        return DtoMapper.convertPage(yearplan, YearPlanDTO.class);
    }


//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public Page<YearPlanDTO> getPageByYearOtherWay(YearplanQueryDTO yearplanQueryDTO) {
//        ExampleMatcher exampleMatcher = ExampleMatcher.matching()
//                //包含，忽略大小写
//                .withMatcher("year", ExampleMatcher.GenericPropertyMatchers.contains().ignoreCase())
//                .withMatcher("production", ExampleMatcher.GenericPropertyMatchers.contains().ignoreCase());
//        Example<YearPlan> example = Example.of(DtoMapper.convert(yearplanQueryDTO, YearPlan.class), exampleMatcher);
//        return DtoMapper.convertPage(yearPlanRepository.findAll(example, yearplanQueryDTO.getRequest()), YearPlanDTO.class);
//    }

    /**
     * Mybatis的根据条件查询所有月度计划
     *
     * @param yearplanQueryDTO 年计划查询DTO
     * @return
     */
    @Override
    public Page<YearPlanDTO> getPageByYearOtherWay(YearplanQueryDTO yearplanQueryDTO) {
        //第一个参数是获取list的方法,需要传递mapper的查询方法，第二个参数是方法需要的参数，第三个对象是如果需要对结果进行类型转换，需要传入的参数，底层使用的BeanUtil.copyProperty
        return PageHelperUtil.getPage(this.yearPlanMapper::getYearPlans, yearplanQueryDTO, YearPlanDTO.class);
    }


    /**
     * 根据Id查询是否已经排产
     */
    @Override
    public int selectPC(int id) {
        int isPc = yearPlanMapper.selectPC(id);
        if (isPc > 0) {
            throw new BaseKnownException(MesExceptionEnum.IS_PC);
        }
        return yearPlanMapper.selectPC(id);
    }


    @Override
    public void autoSchedule(AutoScheduleDTO autoScheduleDTO) throws ParseException {

        //获取每个月的计划量 进一法 数量只多不少
        int amount = autoScheduleDTO.getQuantity();
        int monthAmount;
        int monthOfYear = 12;
        if (amount % monthOfYear != 0) {
            monthAmount = amount / 12 + 1;
        } else {
            monthAmount = amount / 12;
        }
        int year = autoScheduleDTO.getYear();

        //计划编号前面用年月日

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        DateTimeFormatter df2 = DateTimeFormatter.ofPattern("yyyyMM");
        for (int i = 1; i <= monthOfYear; i++) {

            //第一天

            LocalDateTime firstDay = LocalDateTime.of(year, i, 1, 0, 0, 0);
            //最后一天
            LocalDateTime lastDay = firstDay.with(TemporalAdjusters.lastDayOfMonth());
            lastDay = LocalDateTime.of(lastDay.toLocalDate(), LocalTime.MAX);


            //生成生产计划对象
            HvPmWorkPlanAddAndUpdateDTO hvPmWorkPlanAddAndUpdateDTO = new HvPmWorkPlanAddAndUpdateDTO();
            //复制属性  route  产线  车间
            BeanUtils.copyProperties(autoScheduleDTO, hvPmWorkPlanAddAndUpdateDTO);

            String firstDayStr = df.format(firstDay);
            String lastDayStr = df.format(lastDay);

            //计划编号 开始时间  结束时间 数量
            hvPmWorkPlanAddAndUpdateDTO.setPlanCode(df2.format(firstDay) + autoScheduleDTO.getCellCode());
            hvPmWorkPlanAddAndUpdateDTO.setPlanStartTime(sdf.parse(firstDayStr));
            hvPmWorkPlanAddAndUpdateDTO.setPlanEndTime(sdf.parse(lastDayStr));
            hvPmWorkPlanAddAndUpdateDTO.setQuantity(new BigDecimal(monthAmount));

            //生成计划
            workPlanClient.addWorkPlan(hvPmWorkPlanAddAndUpdateDTO);

            //改变年度计划排产状态
            monthlyPlanMapper.changeISPC(autoScheduleDTO.getPlanId());
        }


    }

    /**
     * localDate转Date
     *
     * @param localDateTime localDateTime格式时间
     * @return Date 格式时间
     */
    private Date localDateTime2Date(LocalDateTime localDateTime) {
        if (null == localDateTime) {
            return null;
        }
//        ZonedDateTime zonedDateTime = localDateTime.atZone();

        return Date.from(localDateTime.toInstant(ZoneOffset.UTC));

    }

}

