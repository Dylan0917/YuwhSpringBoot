package com.yu.helloworld.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloWorldController {

    @RequestMapping("/hi")
    @ResponseBody
    public String helloworld(String pa){
        System.out.println(pa);
        return "helloworld";
    }

}
