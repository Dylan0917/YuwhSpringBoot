package org.yu.datamybatis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.yu.datamybatis.bean.Department;
import org.yu.datamybatis.bean.Employee;
import org.yu.datamybatis.mapper.DepartmentMapper;
import org.yu.datamybatis.mapper.EmployeeMapper;

/**
 * @author yu.wenhua
 * @desc
 * @date 2021/1/28 17:20
 */
@Controller
public class DeptController {

    final DepartmentMapper deptMapper;

    final EmployeeMapper employeeMapper;

    @Autowired
    public DeptController(DepartmentMapper deptMapper,EmployeeMapper employeeMapper) {
        this.deptMapper = deptMapper;
        this.employeeMapper = employeeMapper;
    }
    @GetMapping("/dept/{id}")
    @ResponseBody
    public Department getDepartment(@PathVariable("id") Integer id){
        Department dept = deptMapper.getDeptById(id);
        return dept;
    }
    @GetMapping("/dept")
    @Transactional
    @ResponseBody
    public Department insertDept(Department department) {
        deptMapper.insertDept(department);
        System.err.println("Inserted successfully");
        System.err.println("---> 1/0 = " + ( 1 / 0));
        return department;
    }

    @GetMapping("/emp/{id}")
    @ResponseBody
    public Employee getEmp(@PathVariable("id") Integer id) {
        return employeeMapper.getEmpById(id);
    }

}
