package org.yu.springcloud02.service;

import org.springframework.stereotype.Component;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName TicketService.java
 * @Description TODO
 * @createTime 2021年02月10日 16:55:00
 */
@Component
public class TicketService {
    public String getTicket(){
        return "厉害了，我的国";
    }
}
