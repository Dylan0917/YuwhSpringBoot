package org.yu.amqpmodule.service;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;
import org.yu.amqpmodule.bean.Book;

/**
 * @author yu.wenhua
 * @desc
 * @date 2021/2/2 15:51
 */
@Service
public class BookService {

    @RabbitListener(queues = "atguigu.news")
    public void receiveBookMsg(Book book){
        System.out.println("收到消息---"  + book);
    }
    @RabbitListener(queues = "atguigu")
    public void receiveBookMsg02(Message book){
        System.out.println(book.getBody());
        System.out.println(book.getMessageProperties());
        System.out.println("收到消息---"  + book);
    }




}
