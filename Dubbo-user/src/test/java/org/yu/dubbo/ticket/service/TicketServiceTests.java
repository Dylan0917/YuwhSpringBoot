package org.yu.dubbo.ticket.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.yu.dubbo.user.service.UserService;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName TicketServiceTests.java
 * @Description TODO
 * @createTime 2021年02月10日 15:52:00
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TicketServiceTests {
    @Autowired
    UserService userService;
    @Test
    public void test01(){
        userService.hello();
    }
}
