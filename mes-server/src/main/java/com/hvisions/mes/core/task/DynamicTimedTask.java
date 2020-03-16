package com.hvisions.mes.core.task;

import com.hvisions.auth.client.MessageClient;
import com.hvisions.auth.client.UserClient;
import com.hvisions.auth.message.MessageCreateDTO;
import com.hvisions.mes.equipment.entity.EquipmentOverhaulPostpone;
import com.hvisions.mes.equipment.entity.EquipmentOverhaulPlan;
import com.hvisions.mes.equipment.service.EquipmentOverhaulPlanService;
import com.hvisions.mes.util.DateUtil8;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * @description: 设备检修提醒任务调度
 * @author: Bruce
 * @version:
 * @date: 2020-01-22 16:24
 */
@Component
public class DynamicTimedTask implements SchedulingConfigurer {

    private static final Logger logger = LoggerFactory.getLogger(DynamicTimedTask.class);

    @Value("${task.equipment.cron}")
    private String cron;

    @Value("${task.equipment.roleName}")
    private String roleName;

    @Value("${task.equipment.node}")
    private String node;

    @Value("${task.equipment.title}")
    private String title;

    @Value("${task.equipment.url}")
    private String url;

    @Autowired
    private MessageClient messageClient;

    @Autowired
    private UserClient userClient;

    @Autowired
    private EquipmentOverhaulPlanService service;

    @Override
    public void configureTasks(ScheduledTaskRegistrar scheduledTaskRegistrar) {
        scheduledTaskRegistrar.addTriggerTask(() -> {

            // 任务逻辑
            try {
                logger.info("开始执行设备检修提醒任务调度。。。");
                long startTime = System.currentTimeMillis();
                List<Integer> list = service.findUserIdByRole(roleName);
                logger.info("需要发送 {} 个用户", list.size());

                if (!list.isEmpty() && null != list) {
                    int count = 0;
                    int remindCount = 0;
                    for (EquipmentOverhaulPlan plan : service.findRemind()) {
                        String remindDay = null;
                        EquipmentOverhaulPostpone postpone = service.findPostponeByEquipmentId(plan.getId());
                        if (null != postpone) {
                            Date postponeDate = postpone.getPostponeDate();
                            remindDay = DateUtil8.getAfterOrPreDate(
                                    DateUtil8.convertCurDate(postponeDate), node,
                                    null != plan.getRemindDays()? plan.getRemindDays() * (-1) : 0);
                        } else {
                            remindDay = DateUtil8.getAfterOrPreDate(
                                    DateUtil8.convertCurDate(plan.getOverhaulDate()), node,
                                    null != plan.getRemindDays()? plan.getRemindDays() * (-1) : 0);
                        }
                        if (DateUtil8.getNowDate_EN().equals(remindDay)) {
                            MessageCreateDTO messageCreateDTO = new MessageCreateDTO();
                            messageCreateDTO.setUserIds(list);
                            messageCreateDTO.setTitle(title);
                            messageCreateDTO.setHandled(false);
                            messageCreateDTO.setContent(plan.getEquipmentName());
                            messageCreateDTO.setData(new HashMap<>());
                            messageCreateDTO.setUrl(url);
                            messageClient.createMessage(messageCreateDTO);
                            remindCount ++;
                        }
                        count ++;
                    }
                    logger.info("累计查询 {} 条需要进行设备检修消息提醒", count);
                    logger.info("累计发送 {} 条设备检修消息提醒", remindCount);
                }
                long endTime = System.currentTimeMillis();
                logger.info("结束执行设备检修提醒任务调度，耗时 {} 秒", (endTime - startTime)/1000);
            } catch (Exception e) {
                logger.error("调度异常：");
                e.printStackTrace();
            }
        }, triggerContext -> {

            // 任务触发，在这里可修改任务的执行周期,因为每次调度都会执行这里
            CronTrigger cronTrigger = new CronTrigger(cron);
            return cronTrigger.nextExecutionTime(triggerContext);
        });
    }

    public static void main(String[] args) {
//        System.out.println(DateUtil8.getAfterOrPreDate(
//                DateUtil8.getNowDate_EN(), "day", 0));
//        System.out.println(DateUtil8.convertCurDate(new Date()));
        System.out.println(0*(-1));
    }
}
