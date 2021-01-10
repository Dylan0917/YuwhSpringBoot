package org.yu.yamlstu.bean;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName Persion.java
 * @Description
 * @createTime 2021年01月09日 16:49:00
 * @ConfigurationProperties(prefix = "person") 将属性与配置文件绑定  支持jsr303校验
 */
@Component
@ConfigurationProperties(prefix = "person")
public class Person {

    private String age;
    private Boolean boss;
    private String birth;
    private Map maps;
    private List lists;
    private Dog dog;
    private String lastname;

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public Boolean getBoss() {
        return boss;
    }

    public void setBoss(Boolean boss) {
        this.boss = boss;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public Map getMaps() {
        return maps;
    }

    public void setMaps(Map maps) {
        this.maps = maps;
    }

    public List getLists() {
        return lists;
    }

    public void setLists(List lists) {
        this.lists = lists;
    }

    public Dog getDog() {
        return dog;
    }

    public void setDog(Dog dog) {
        this.dog = dog;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    @Override
    public String toString() {
        return "Persion{" +
                "age='" + age + '\'' +
                ", boss=" + boss +
                ", birth='" + birth + '\'' +
                ", maps=" + maps +
                ", lists=" + lists +
                ", dog=" + dog +
                ", lastname='" + lastname + '\'' +
                '}';
    }
}
