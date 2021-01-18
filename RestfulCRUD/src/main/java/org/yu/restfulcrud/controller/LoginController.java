package org.yu.restfulcrud.controller;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName LoginController.java
 * @Description TODO
 * @createTime 2021年01月17日 08:35:00
 */
@Controller
public class LoginController {
//    @RequestMapping()
    @PostMapping("user/login")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        Map<String,Object> map,
                        HttpSession session){
//        if (!StringUtils.isEmpty(username) && "123456".equals(password)){
        if (!StringUtils.isEmpty(username)){
            //防止表单重复提交使用重定向
//            return "dashboard";
            //将用户信息加入
            session.setAttribute("loginUser",username);
            return "redirect:/main.html";
        }
        map.put("msg","用户名密码错误");
        return "login";
    }
}
