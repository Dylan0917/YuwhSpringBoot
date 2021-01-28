package org.yu.datajdbc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * @author yu.wenhua
 * @desc
 * @date 2021/1/28 11:24
 */
@Controller
public class Controller01 {

    JdbcTemplate jdbcTemplate;

    @Autowired
    public Controller01(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @GetMapping("/c01/m01")
    @ResponseBody
    public Map m01(){
        List<Map<String, Object>> list = jdbcTemplate.queryForList("select * FROM department");
        return list.get(0);
    }
}
