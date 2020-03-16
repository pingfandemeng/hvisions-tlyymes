package com.hvisions.mes.core.task;

import com.hvisions.auth.client.MessageClient;
import com.hvisions.auth.message.MessageCreateDTO;
import com.hvisions.mes.dto.postleak.PostLeakListDTO;
import com.hvisions.mes.equipment.service.EquipmentOverhaulPlanService;
import com.hvisions.mes.postleak.service.PostLeakService;
import com.hvisions.mes.util.DateUtil8;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;

/**
 * @description: 岗位漏点任务调度
 * @author: Bruce
 * @version:
 * @date: 2020-02-20 15:35
 */
@Component
public class PostLeakDynamicTimedTask implements SchedulingConfigurer {

    private static final Logger logger = LoggerFactory.getLogger(PostLeakDynamicTimedTask.class);

    @Value("${task.postleak.cron}")
    private String cron;

    @Value("${task.postleak.roleName}")
    private String roleName;

    @Value("${task.postleak.title}")
    private String title;

    @Value("${task.postleak.url}")
    private String url;

    @Autowired
    private EquipmentOverhaulPlanService service;

    @Autowired
    private PostLeakService postLeakService;

    @Autowired
    private MessageClient messageClient;

    @Override
    public void configureTasks(ScheduledTaskRegistrar scheduledTaskRegistrar) {
        scheduledTaskRegistrar.addTriggerTask(() -> {

            // 任务逻辑
            try {
                logger.info("开始执行岗位漏点计划提醒任务调度。。。");
                long startTime = System.currentTimeMillis();
                List<Integer> list = service.findUserIdByRole(roleName);
                logger.info("需要发送 {} 个用户", list.size());

                if (!list.isEmpty() && null != list) {
                    int count = 0;
                    int remindCount = 0;
                    for (PostLeakListDTO dto : postLeakService.findRemind()) {
                        if (DateUtil8.getNowDate_EN().equals(DateUtil8.convertCurDate(dto.getPlanDate()))) {
                            MessageCreateDTO messageCreateDTO = new MessageCreateDTO();
                            messageCreateDTO.setUserIds(list);
                            messageCreateDTO.setTitle(title);
                            messageCreateDTO.setHandled(false);
                            messageCreateDTO.setContent(dto.getLeakDescription());
                            messageCreateDTO.setData(new HashMap<>());
                            messageCreateDTO.setUrl(url);
                            messageClient.createMessage(messageCreateDTO);
                            remindCount ++;
                        }
                        count ++;
                    }
                    logger.info("累计查询 {} 条需要进行岗位漏点计划消息提醒", count);
                    logger.info("累计发送 {} 条岗位漏点计划消息提醒", remindCount);
                }
                long endTime = System.currentTimeMillis();
                logger.info("结束执行岗位漏点计划提醒任务调度，耗时 {} 秒", (endTime - startTime)/1000);
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
}
