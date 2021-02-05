package org.yu.task.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.yu.task.service.AsyncService;

import java.util.HashMap;
import java.util.Map;

/**
 * @author yu.wenhua
 * @desc
 * @date 2021/2/5 15:36
 */
@RestController
public class AsyncController {

    final
    AsyncService asyncService;

    @Autowired
    public AsyncController(AsyncService asyncService) {
        this.asyncService = asyncService;
    }

    @GetMapping("/c01")
    public Map controller01(){
        Map map = new HashMap();
        asyncService.hello();
        map.put("aaa","2323232");
        return map;
    }



}
