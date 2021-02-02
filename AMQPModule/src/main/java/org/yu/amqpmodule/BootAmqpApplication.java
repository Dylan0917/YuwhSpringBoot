package org.yu.amqpmodule;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author yu.wenhua
 * @desc
 * org.springframework.boot.autoconfigure.amqp.RabbitAutoConfiguration
 * org.springframework.amqp.rabbit.core.RabbitTemplate 操作类 发送和接收消息
 * org.springframework.amqp.core.AmqpAdmin 创建队列 Exchanges和binding
 * @date 2021/2/2 15:01
 */
@EnableRabbit //开启基于注解的rabbitmq
@SpringBootApplication
public class BootAmqpApplication {
    public static void main(String[] args) {
        SpringApplication.run(BootAmqpApplication.class,args);
    }
}
