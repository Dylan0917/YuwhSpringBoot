package org.yu.restfulcrud.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName Conroller01.java
 * @Description TODO
 * @createTime 2021年01月10日 16:12:00
 */
@Controller
public class Conroller01 {
    @RequestMapping("/hello")
    public String helloController(Model model){
        model.addAttribute("hello","你好啊");
        return "success";
    }
}
