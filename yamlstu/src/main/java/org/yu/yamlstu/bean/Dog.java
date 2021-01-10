package org.yu.yamlstu.bean;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName Dog.java
 * @Description
 * @createTime 2021年01月09日 16:49:00
 */
public class Dog {
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
