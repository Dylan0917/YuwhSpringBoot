package org.yu.cache.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.yu.cache.bean.Employee;

/**
 * @author yu.wenhua
 * @desc
 * @date 2021/1/30 17:17
 */
@Mapper
public interface EmployeeMapper {
    public Employee getEmpById(Integer id);
    public Employee getEmpByLastName(String lastName);
    public void updateEmp(Employee employee);
    public void delEmpById(Integer id);
    public void insertEmp(Employee employee);
}
