package org.yu.task.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * @author yu.wenhua
 * @desc
 * @date 2021/2/5 15:44
 */
@Service
public class AsyncService {
    @Async //加了该注解后 不会阻塞后续任务
    public void hello(){
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("处理数据中。。。。。。");
    }

}
