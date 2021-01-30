package com.yu.helloworld.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.yu.starter.HelloService;

@Controller
public class HelloWorldController {


    @Autowired
    HelloService helloService;

    @RequestMapping("/hi")
    @ResponseBody
    public String helloworld(String pa){
        System.out.println(pa);
        System.out.println(helloService.sayHellAtguigu("-----"));
        return "helloworld";
    }

}
