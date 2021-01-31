package org.yu.cache.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.yu.cache.bean.Department;
import org.yu.cache.service.DepartmentService;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName DeptController.java
 * @Description TODO
 * @createTime 2021年01月31日 19:38:00
 */
@RestController
public class DeptController {

    @Autowired
    DepartmentService departmentService;

    @GetMapping("/dept/{id}")
    public Department getDeptById(@PathVariable("id") Integer id){
        Department deptById = departmentService.getDeptById(id);
        return deptById;
    }

}
