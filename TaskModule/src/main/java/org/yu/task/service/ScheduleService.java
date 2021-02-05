package org.yu.task.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * @author yu.wenhua
 * @desc
 * @date 2021/2/5 15:53
 */
@Service
public class ScheduleService implements SchedulingConfigurer {
    @Scheduled(cron = "*/5 * * * * ?")
    public void hello(){
        System.out.println("hello....");
    }

    @Override
    public void configureTasks(ScheduledTaskRegistrar scheduledTaskRegistrar) {
        scheduledTaskRegistrar.addTriggerTask(//执行定时任务
                () -> {
                    System.out.println("执行动态定时任务: " + LocalDateTime.now().toLocalTime());
                }, //设置触发器
                triggerContext -> {
                    // 初始化定时任务周期
                    String cron = "*/6 * * * * ?";
                    CronTrigger trigger = new CronTrigger(cron);
                    return trigger.nextExecutionTime(triggerContext);
                });
    }
}
