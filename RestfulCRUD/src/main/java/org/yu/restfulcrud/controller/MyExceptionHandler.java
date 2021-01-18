package org.yu.restfulcrud.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.yu.restfulcrud.exception.UserNotExistException;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName MyExceptionHandler.java
 * @Description 自定义异常处理
 * @createTime 2021年01月18日 22:43:00
 */
@ControllerAdvice
public class MyExceptionHandler {

 /*   @ResponseBody
    @ExceptionHandler(UserNotExistException.class)
    public Map<String,Object> handleException(Exception e){
        Map<String,Object> map = new HashMap<>();
        map.put("code","user.notexist");
        map.put("message","用户出错啦");
        return map;
    }*/

 @ExceptionHandler(UserNotExistException.class)
 public String handleException(Exception e, HttpServletRequest request){
     Map<String,Object> map = new HashMap<>();
     map.put("code","user.notexist");
     map.put("message","用户出错啦");
     request.setAttribute(RequestDispatcher.ERROR_STATUS_CODE,500);
     //使用error的视图解析器自动返回html或者json
     return "forward:/error";
 }


}
