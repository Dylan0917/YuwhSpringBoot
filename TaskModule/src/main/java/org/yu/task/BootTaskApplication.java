package org.yu.task;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author yu.wenhua
 * @desc
 * @date 2021/2/5 15:34
 */
@SpringBootApplication
@EnableAsync //启动异步任务
@EnableScheduling //开启定时任务
public class BootTaskApplication {
    public static void main(String[] args) {
        SpringApplication.run(BootTaskApplication.class,args);
    }
}
