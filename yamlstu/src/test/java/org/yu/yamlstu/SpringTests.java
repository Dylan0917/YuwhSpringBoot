package org.yu.yamlstu;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.yu.yamlstu.bean.Person;
import org.yu.yamlstu.bean.PersonProperties;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName SpringTests.java
 * @Description TODO
 * @createTime 2021年01月09日 17:23:00
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringTests {

    @Autowired
    private Person person;
    @Autowired
    private PersonProperties personProperties;
    @Test
    public void testYml(){
        System.out.println(person.toString());
    }
    @Test
    public void testValue(){
        System.out.println(personProperties.toString());
    }
}
