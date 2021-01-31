package org.yu.cache.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.*;
import org.springframework.stereotype.Service;
import org.yu.cache.bean.Employee;
import org.yu.cache.mapper.EmployeeMapper;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName EmployeeService.java
 * @Description TODO
 * @createTime 2021年01月31日 10:23:00
 */
@Service
//@CacheConfig(cacheNames = "emp") 公共配置
public class EmployeeService {
    private final EmployeeMapper employeeMapper;
    @Autowired
    public EmployeeService(EmployeeMapper employeeMapper) {
        this.employeeMapper = employeeMapper;
    }

    //使用缓存标签时必须保证缓存的key一致
    @Cacheable(value={"emp"}
            ,key = "#id"
//            ,keyGenerator = "myKeyGenerator" //自定义key生成器
//            ,condition = "#a0>1" 为true时 缓存
//            unless = "#p0==2" 为true时不缓存
    )
    public Employee getEmpById(Integer id) {
        System.out.println("查询员工："+id);
        return employeeMapper.getEmpById(id);
    }
//    @CachePut更新
    @CachePut(value = {"emp"}
            ,key = "#employee.id"
//    ,keyGenerator = "myKeyGenerator"//必须和@Cacheable的配置相同才可以
    )
    public void updateEmp(Employee employee){
        System.out.println("更新员工："+employee.toString());
        employeeMapper.updateEmp(employee);
    }
    @CacheEvict(value = {"emp"}
            ,key = "#id"
//            ,keyGenerator = "myKeyGenerator"//必须和@Cacheable的配置相同才可以
            ,allEntries = false
            ,beforeInvocation = false //在方法之前执行缓存删除
             )
    public void delEmpById(Integer id){
        System.out.println("删除员工："+id);
        employeeMapper.delEmpById(id);
    }
    //@Caching实现复杂配置
    @Caching(
            cacheable = {
                    @Cacheable(value = {"emp"},key = "#lastName")
            },
            put = {
                    @CachePut(value = "emp",key = "#result.id"),
                    @CachePut(value = "emp",key = "#result.email")
            }
    )
    public Employee getEmpByLastName(String lastName){
        System.out.println("getEmpByLastName："+lastName);
        return employeeMapper.getEmpByLastName(lastName);
    }


}
