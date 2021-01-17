package org.yu.restfulcrud.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.yu.restfulcrud.entities.Employee;

import java.util.Map;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName EmployeeDao.java
 * @Description TODO
 * @createTime 2021年01月17日 22:40:00
 */
@Repository
public class EmployeeDao {
    private static Map<Integer, Employee> employees = null;
    private DepartmentDao departmentDao;
//    https://blog.csdn.net/zhangjingao/article/details/81094529
//    为什么要使用构造器注入
//    不能有效的指明依赖。相信很多人都遇见过一个bug，依赖注入的对象为null，在启动依赖容器时遇到这个问题都是配置的依赖注入少了一个注解什么的，然而这种方式就过于依赖注入容器了，当没有启动整个依赖容器时，这个类就不能运转，在反射时无法提供这个类需要的依赖。
//    在使用set方式时，这是一种选择注入，可有可无，即使没有注入这个依赖，那么也不会影响整个类的运行。
//    在使用构造器方式时已经显式注明必须强制注入。通过强制指明依赖注入来保证这个类的运行。
    @Autowired
    public EmployeeDao(DepartmentDao departmentDao) {
        this.departmentDao = departmentDao;
    }
}
