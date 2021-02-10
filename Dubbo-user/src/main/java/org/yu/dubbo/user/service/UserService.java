package org.yu.dubbo.user.service;

import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.yu.dubbo.ticket.service.TicketService;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName UserService.java
 * @Description TODO
 * @createTime 2021年02月10日 15:44:00
 */
@Component
public class UserService {
    @Reference
    TicketService ticketService;
    public void hello(){
        System.out.println(ticketService.getService());
    }
}
