package org.yu.cache;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
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
    @Autowired
    StringRedisTemplate stringRedisTemplate;
    @Autowired
    RedisTemplate redisTemplate;
    @Autowired
    RedisTemplate empRedisTemplate;
    @Test
    public void contextLoads(){
        Employee employee = mapper.getEmpById(1);
        System.out.println(employee.toString());
    }

    /**
     * Redis的五大数据类型
     *String（字符串）、List（列表）、Set（集合）、Hash（哈希，类似java里的map）、Zset（sorted set：有序集合）
     * stringRedisTemplate.opsForValue()--》String（字符串）
     * tringRedisTemplate.opsForList();-->List（列表）
     * stringRedisTemplate.opsForSet()--> Set（集合）
     * stringRedisTemplate.opsForHash()--->Hash（哈希，类似java里的map）
     * stringRedisTemplate.opsForZSet()--->Zset（sorted set：有序集合）
     */
    @Test
    public void redis01Tests(){
//        stringRedisTemplate.opsForValue().append("msg","hello");
//        System.out.println(stringRedisTemplate.opsForValue().get("msg"));
        stringRedisTemplate.opsForList().leftPush("mylist","1");
        stringRedisTemplate.opsForList().leftPush("mylist","2");
        stringRedisTemplate.opsForList().leftPush("mylist","3");
        stringRedisTemplate.opsForList().leftPush("mylist","4");
    }
    @Test
    public void redis02Tests(){
        Employee employee = mapper.getEmpById(6);
        empRedisTemplate.opsForValue().set("emp-06",employee);
    }

}
