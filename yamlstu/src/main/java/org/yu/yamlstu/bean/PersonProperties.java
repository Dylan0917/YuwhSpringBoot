package org.yu.yamlstu.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName PersonProperties.java
 * @Description TODO
 * @createTime 2021年01月09日 22:02:00
 */
@Component
public class PersonProperties {
    //从application.properties获取属性
    @Value("${personProperties.name}")
    private String name;
    //从application.yml获取属性
    @Value("${person.age}")
    private String age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "PersonProperties{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                '}';
    }
}
