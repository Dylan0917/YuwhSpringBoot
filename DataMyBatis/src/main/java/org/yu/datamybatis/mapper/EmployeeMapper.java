package org.yu.datamybatis.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.yu.datamybatis.bean.Employee;

/**
 * @author yu.wenhua
 * @desc
 * @date 2021/1/28 19:36
 */
@Mapper
public interface EmployeeMapper {

    public Employee getEmpById(Integer id);

}
