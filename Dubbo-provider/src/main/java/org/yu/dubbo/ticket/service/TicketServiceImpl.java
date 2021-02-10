package org.yu.dubbo.ticket.service;

import org.apache.dubbo.config.annotation.Service;
import org.springframework.stereotype.Component;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName TicketServiceImpl.java
 * @Description TODO
 * @createTime 2021年02月10日 15:26:00
 */
@Component
@Service
public class TicketServiceImpl implements TicketService{
    @Override
    public String getService() {
        return "厉害了，我的国";
    }
}
