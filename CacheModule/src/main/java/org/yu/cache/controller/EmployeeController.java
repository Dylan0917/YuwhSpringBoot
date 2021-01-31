package org.yu.cache.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.yu.cache.bean.Employee;
import org.yu.cache.service.EmployeeService;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName EmployeeController.java
 * @Description TODO
 * @createTime 2021年01月31日 10:25:00
 */
@RestController
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/emp/{id}")
    public Employee getEmp(@PathVariable("id") Integer id) {
        return employeeService.getEmpById(id);
    }
    @GetMapping("/emp")
    public Employee updateEmp(Employee employee) {
        employeeService.updateEmp(employee);
        return employee;
    }
    @GetMapping("/del/{id}")
    public Integer delEmp(@PathVariable("id") Integer id) {
        employeeService.delEmpById(id);
        return id;
    }
    @GetMapping("/empl/{lastName}")
    public Employee getEmpByLastName(@PathVariable("lastName") String id) {
        return employeeService.getEmpByLastName(id);
    }
}
