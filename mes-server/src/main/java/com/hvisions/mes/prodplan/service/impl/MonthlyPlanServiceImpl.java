package com.hvisions.mes.prodplan.service.impl;

import com.hvisions.common.dto.HvPage;
import com.hvisions.common.exception.BaseKnownException;
import com.hvisions.common.utils.DtoMapper;
import com.hvisions.common.utils.PageHelperUtil;
import com.hvisions.common.vo.ResultVO;
import com.hvisions.materialsmsd.materials.dto.MaterialDTO;
import com.hvisions.mes.dto.prodplan.MonthlyPlanDTO;
import com.hvisions.mes.dto.prodplan.MonthlyPlanQueryDTO;
import com.hvisions.mes.enums.MesExceptionEnum;
import com.hvisions.mes.prodplan.entity.MonthlyPlan;
import com.hvisions.mes.prodplan.repository.MonthlyPlanRepository;
import com.hvisions.mes.prodplan.service.MonthlyPlanService;
import com.hvisions.work.plan.client.WorkPlanClient;
import com.hvisions.materialsmsd.materials.client.MaterialClient;
import com.hvisions.work.plan.dto.IssuerDTO;
import com.hvisions.mes.prodplan.dao.MonthlyPlanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.List;

// import com.hvisions.common.exception.BaseKnownException;

/**
 * Description:
 * Time:     2019/9/16
 * Version:  1.0.0
 * @author dyxie
 */
@Service
public class MonthlyPlanServiceImpl implements MonthlyPlanService {

    private final MonthlyPlanRepository monthlyPlanRepository;
    private final MonthlyPlanMapper monthlyPlanMapper;
    @Autowired
    private WorkPlanClient workPlanClient;
    @Autowired
    private MaterialClient materialClient;

    @Autowired
    public MonthlyPlanServiceImpl(MonthlyPlanRepository monthlyPlanRepository,MonthlyPlanMapper monthlyPlanMapper) {
        this.monthlyPlanRepository = monthlyPlanRepository;
        this.monthlyPlanMapper = monthlyPlanMapper;
    }

    /**
     * 保存月度计划
     * @param monthlyPlanDTO
     * @return
     */
    @Override
    public int save(MonthlyPlanDTO monthlyPlanDTO) {
        int result = 0;
        Calendar yearAndMonth = Calendar.getInstance();
        yearAndMonth.setTime(monthlyPlanDTO.getUserDate());
        monthlyPlanDTO.setYear(yearAndMonth.get(Calendar.YEAR));
        monthlyPlanDTO.setMonth(yearAndMonth.get(Calendar.MONTH)+1);
        // 修改
        if(monthlyPlanDTO.getId()!=null){
            result = monthlyPlanRepository.save(DtoMapper.convert(monthlyPlanDTO, MonthlyPlan.class)).getId();
        }else{ // 新增
            // 查找该年该月数据是否已存在
            List<MonthlyPlan> msgForYearAndMonth = monthlyPlanMapper.findMsgForYearAndMonth(monthlyPlanDTO);
            // 新增时该时间点月度计划已经存在时不允许新增
            if (msgForYearAndMonth.size() == 0 ) {
                Calendar beginMonth = Calendar.getInstance();
                beginMonth.setTime(monthlyPlanDTO.getUserDate());
                beginMonth.set(Calendar.DAY_OF_MONTH,beginMonth.getActualMinimum(Calendar.DAY_OF_MONTH));
                monthlyPlanDTO.setPlanStartTime(beginMonth.getTime());
                //获取月尾日期
                Calendar endMonth = Calendar.getInstance();
                endMonth.setTime(monthlyPlanDTO.getUserDate());
                endMonth.set(Calendar.DAY_OF_MONTH,endMonth.getActualMaximum(Calendar.DAY_OF_MONTH));
                monthlyPlanDTO.setPlanEndTime(endMonth.getTime());
                result  =  monthlyPlanRepository.save(DtoMapper.convert(monthlyPlanDTO, MonthlyPlan.class)).getId();
            } else {
                result = 0;
            }
        }
        if(result==0){
            throw new BaseKnownException(MesExceptionEnum.EXISTS_CLIENT);
        }
        return result;
    }

    /**
     * 删除该条月度计划
     * @param id
     */
    @Override
    public void deleteById(int id) {
        monthlyPlanRepository.deleteById(id);
        //throw new BaseKnownException(2,"",null);
    }

    /**
     * 根据条件查询所有月度计划数据
     * @param monthlyPlanQueryDTO
     * @return
     */
    @Override
    public Page<MonthlyPlanDTO> getAllByCondition(MonthlyPlanQueryDTO monthlyPlanQueryDTO) {
        ExampleMatcher exampleMatcher = ExampleMatcher.matching()
                //包含，忽略大小写
                .withMatcher("year", ExampleMatcher.GenericPropertyMatchers.contains().ignoreCase())
                .withMatcher("product", ExampleMatcher.GenericPropertyMatchers.contains().ignoreCase());
        Example<MonthlyPlan> example = Example.of(DtoMapper.convert(monthlyPlanQueryDTO, MonthlyPlan.class), exampleMatcher);
        return DtoMapper.convertPage(monthlyPlanRepository.findAll(example, monthlyPlanQueryDTO.getRequest()), MonthlyPlanDTO.class);
    }

    /**
     * Mybatis的根据条件查询所有月度计划
     * @param monthlyPlanQueryDTO
     * @return
     */
    @Override
    public Page<MonthlyPlanDTO> getMonthlyPlans(MonthlyPlanQueryDTO monthlyPlanQueryDTO) {

        // 2019-09
        if(!"".equals(monthlyPlanQueryDTO.getYearAndMonth())&&monthlyPlanQueryDTO.getYearAndMonth()!=null){
            String [] ym = monthlyPlanQueryDTO.getYearAndMonth().split("-");
            monthlyPlanQueryDTO.setYear(Integer.valueOf(ym[0]));
            monthlyPlanQueryDTO.setMonth(Integer.valueOf(ym[1]));
        }
        // monthlyPlanMapper.getMonthlyPlans(monthlyPlanQueryDTO);
        //第一个参数是获取list的方法,需要传递mapper的查询方法，第二个参数是方法需要的参数，第三个对象是如果需要对结果进行类型转换，需要传入的参数，底层使用的BeanUtil.copyProperty
        return PageHelperUtil.getPage(this.monthlyPlanMapper::getMonthlyPlans, monthlyPlanQueryDTO, MonthlyPlanDTO.class);
    }

    /**
     * 自动排产
     *
     * @param monthlyPlanDTO
     * @return
     */
    @Override
    public int saveAll(MonthlyPlanDTO monthlyPlanDTO, int num, String year, String production, int id) {
        //改变年度计划排产状态
        monthlyPlanMapper.changeISPC(id);
        //获取每个月的计划量
        String product =monthlyPlanMapper.selectName(production);
        int amout =0;
        int yu = num%12;
        if(yu!=0){
            amout=num/12+1;
        }else{
            amout=num/12;
        }
        int year1=Integer.parseInt(year);
        monthlyPlanDTO.setProduct(product);
        monthlyPlanDTO.setAmount(BigDecimal.valueOf(amout));
        monthlyPlanDTO.setYear(year1);
        for (int i=1;i<=12;i++) {
            monthlyPlanDTO.setMonth(i);
            monthlyPlanDTO.setType(0);
            List<MonthlyPlan> msgForYearAndMonth = monthlyPlanMapper.findMsgForYearAndMonth(monthlyPlanDTO);
            if (msgForYearAndMonth.size() == 0 ){
                //获取月头日期
                Calendar cal = Calendar.getInstance();
                cal.set(Calendar.YEAR, year1);
                cal.set(Calendar.MONTH, i-1);

                //获取某月最小天数
                int firstDay = cal.getMinimum(Calendar.DATE);

                //设置日历中月份的最小天数
                cal.set(Calendar.DAY_OF_MONTH,firstDay);
                monthlyPlanDTO.setPlanStartTime(cal.getTime());

                //获取月尾日期
                //获取某月最大天数
                int lastDay = cal.getActualMaximum(Calendar.DATE);
                //设置日历中月份的最大天数
                cal.set(Calendar.DAY_OF_MONTH, lastDay);

                monthlyPlanDTO.setPlanEndTime(cal.getTime());
                MonthlyPlan plan = DtoMapper.convert(monthlyPlanDTO, MonthlyPlan.class);
                monthlyPlanRepository.save(plan);
            }else{
                continue;
            }

        }
        return 0;
    }

    /**
     * 下发月度工单
     * @param issuerDTO
     * @return
     */
    @Override
    public ResultVO issuerPlan(IssuerDTO issuerDTO) {
        return workPlanClient.issuerPlan(issuerDTO);
    }

    /**
     * 获取所有物料
     * @return
     */
    @Override
    public List<MaterialDTO> getAllProduction() {
        ResultVO<HvPage<MaterialDTO>> tag = materialClient.getAllProduct();
        HvPage<MaterialDTO> tag2 = tag.getData();
        return tag2.getContent();
    }

}
