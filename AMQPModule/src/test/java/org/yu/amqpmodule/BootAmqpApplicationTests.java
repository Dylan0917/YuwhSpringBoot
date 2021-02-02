package org.yu.amqpmodule;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.yu.amqpmodule.bean.Book;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author yu.wenhua
 * @desc
 * @date 2021/2/2 15:10
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class BootAmqpApplicationTests {

    @Autowired
    RabbitTemplate template;

    @Autowired
    AmqpAdmin amqpAdmin;

    /**
     * 单播
     */
    @Test
    public void contextLoads(){
        Map<String,Object> map = new HashMap<>();
//        map.put("msg","这是一个消息");
//        map.put("data", Arrays.asList("helloworld","123",true));
//        template.convertAndSend("exchange.direct","atguigu.news",map);
        Book book = new Book("西游记","吴承恩");
        template.convertAndSend("exchange.direct","atguigu.news",book);
    }

    @Test
    public void receiveMsg(){
        Object o = template.receiveAndConvert("atguigu.news");
        System.out.println(o.getClass());
        System.out.println(o.toString());
    }

    /**
     * 广播
     */
    @Test
    public void sendMsg(){
        Map<String,Object> map = new HashMap<>();
//        map.put("msg","这是一个消息");
//        map.put("data", Arrays.asList("helloworld","123",true));
//        template.convertAndSend("exchange.direct","atguigu.news",map);
//        Book book = new Book("三国演义","罗贯中");
        Book book = new Book("红楼梦","曹雪芹");
        template.convertAndSend("exchange.fanout","atguigu.news",book);
    }

    @Test
    public void amqpAdminTests(){
        /*amqpAdmin.declareExchange(new DirectExchange("amqpadmin.exchange"));
        System.out.println("创建完成");*/

        /*amqpAdmin.declareQueue(new Queue("amqppadmin.queue",true));
        System.out.println("Queue创建完成");*/

        amqpAdmin.declareBinding(new Binding("amqppadmin.queue",Binding.DestinationType.QUEUE,"amqpadmin.exchange",
                "amqp.hh",null));

    }

}
