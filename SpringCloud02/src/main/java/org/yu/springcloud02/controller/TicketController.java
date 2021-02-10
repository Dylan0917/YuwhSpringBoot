package org.yu.springcloud02.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.yu.springcloud02.service.TicketService;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName TicketController.java
 * @Description TODO
 * @createTime 2021年02月10日 16:57:00
 */
@RestController
public class TicketController {
    @Autowired
    TicketService ticketService;
    @GetMapping("/ticket")
    public String getTicket(){
        String ticket = ticketService.getTicket();
        return ticket;
    }
}
