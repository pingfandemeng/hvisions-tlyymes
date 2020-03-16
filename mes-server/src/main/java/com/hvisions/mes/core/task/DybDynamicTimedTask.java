package com.hvisions.mes.core.task;

import com.hvisions.auth.client.MessageClient;
import com.hvisions.auth.message.MessageCreateDTO;
import com.hvisions.mes.dyb.entity.DybCheck;
import com.hvisions.mes.dyb.service.DybService;
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
 * @description: 电仪表校验任务调度
 * @author: Bruce
 * @version:
 * @date: 2020-02-18 15:03
 */
@Component
public class DybDynamicTimedTask implements SchedulingConfigurer {

    private static final Logger logger = LoggerFactory.getLogger(DybDynamicTimedTask.class);

    @Value("${task.dyb.cron}")
    private String cron;

    @Value("${task.dyb.roleName}")
    private String roleName;

    @Value("${task.dyb.title}")
    private String title;

    @Value("${task.dyb.url}")
    private String url;

    @Autowired
    private MessageClient messageClient;

    @Autowired
    private DybService dybService;

    @Autowired
    private EquipmentOverhaulPlanService service;

    @Override
    public void configureTasks(ScheduledTaskRegistrar scheduledTaskRegistrar) {
        scheduledTaskRegistrar.addTriggerTask(() -> {

            // 任务逻辑
            try {
                logger.info("开始执行电仪表校验提醒任务调度。。。");
                long startTime = System.currentTimeMillis();
                List<Integer> list = service.findUserIdByRole(roleName);
                logger.info("需要发送 {} 个用户", list.size());

                if (!list.isEmpty() && null != list) {
                    int count = 0;
                    int remindCount = 0;
                    int updateCount = 0;
                    for (DybCheck check : dybService.remind()) {
                        // 状态为延期的处理
                        if (check.getStatus() == 3 &&
                                DateUtil8.getNowDate_EN().equals(DateUtil8.convertCurDate(check.getPlantCheckTime()))) {
                            check.setStatus(1);
                            check.setUpdateTime(new Date());
                            dybService.updateStatus(check);
                            updateCount ++;

                            MessageCreateDTO messageCreateDTO = new MessageCreateDTO();
                            messageCreateDTO.setUserIds(list);
                            messageCreateDTO.setTitle(title);
                            messageCreateDTO.setHandled(false);
                            messageCreateDTO.setContent(check.getBackup());
                            messageCreateDTO.setData(new HashMap<>());
                            messageCreateDTO.setUrl(url);
                            messageClient.createMessage(messageCreateDTO);
                            remindCount ++;
                        } else if (check.getStatus() == 1 &&    // 状态为新建的处理
                                DateUtil8.getNowDate_EN().equals(DateUtil8.convertCurDate(check.getPlantCheckTime()))) {
                            MessageCreateDTO messageCreateDTO = new MessageCreateDTO();
                            messageCreateDTO.setUserIds(list);
                            messageCreateDTO.setTitle(title);
                            messageCreateDTO.setHandled(false);
                            messageCreateDTO.setContent(check.getBackup());
                            messageCreateDTO.setData(new HashMap<>());
                            messageCreateDTO.setUrl(url);
                            messageClient.createMessage(messageCreateDTO);
                            remindCount ++;
                        } else if (check.getStatus() == 4) {    // 状态为完成校验的处理
                            check.setStatus(1);
                            check.setUpdateTime(new Date());
                            dybService.updateStatus(check);
                            updateCount ++;
                        }
                        count ++;
                    }
                    logger.info("累计查询 {} 条需要进行电仪表校验消息提醒", count);
                    logger.info("累计发送 {} 条电仪表校验消息提醒", remindCount);
                    logger.info("累计查询 {} 条延期的电仪表校验信息更改状态为新建", updateCount);
                }
                long endTime = System.currentTimeMillis();
                logger.info("结束执行电仪表校验提醒任务调度，耗时 {} 秒", (endTime - startTime)/1000);
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
        System.out.println(DateUtil8.getNowDate_EN());
    }
}
