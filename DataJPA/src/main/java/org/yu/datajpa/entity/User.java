package org.yu.datajpa.entity;

import javax.persistence.*;

/**
 * @author yu.wenhua
 * @desc
 * @date 2021/1/29 14:05
 */
@Entity //是一个实体类
@Table(name = "tbl_user") //指定表
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //主键自增
    private Integer id;
    @Column(name = "last_name")
    private String lastName;
    @Column
    private String email;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
