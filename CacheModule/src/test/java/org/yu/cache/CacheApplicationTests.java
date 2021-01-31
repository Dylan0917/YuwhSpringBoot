package org.yu.cache;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.yu.cache.bean.Employee;
import org.yu.cache.mapper.EmployeeMapper;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName CacheApplicationTests.java
 * @Description TODO
 * @createTime 2021年01月31日 10:01:00
 */
@RunWith(SpringRunner.class)
@SpringBootTest
//@MapperScan("org.yu.cache.mapper") 此处不用加这个注解
public class CacheApplicationTests {
    @Autowired
    EmployeeMapper mapper;
    @Test
    public void contextLoads(){
        Employee employee = mapper.getEmpById(1);
        System.out.println(employee.toString());
    }


}
