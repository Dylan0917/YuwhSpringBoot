package org.yu.springcloud03.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName UserController.java
 * @Description TODO
 * @createTime 2021年02月10日 17:15:00
 */
@RestController
public class UserController {
    @Autowired
    RestTemplate restTemplate;
    @GetMapping("getticket")
    public String getTicket(){
        String forObject = restTemplate.getForObject("http://SPRINGCLOUD02/ticket", String.class);
        return forObject;
    }
}
