package org.yu.datamybatis.bean;

/**
 * @author yu.wenhua
 * @desc
 * @date 2021/1/28 17:11
 */
public class Department {
    private Integer id;
    private String departmentName;

    public void setId(Integer id) {
        this.id = id;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public Integer getId() {
        return id;
    }

    public String getDepartmentName() {
        return departmentName;
    }
}
