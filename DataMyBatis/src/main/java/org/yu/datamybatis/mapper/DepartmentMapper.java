package org.yu.datamybatis.mapper;

import org.apache.ibatis.annotations.*;
import org.yu.datamybatis.bean.Department;

/**
 * @author yu.wenhua
 * @desc 指定这是一个操作数据库的mapper
 * @date 2021/1/28 17:14
 */
@Mapper
public interface DepartmentMapper {

    @Select("select * from department where id=#{id}")
    Department getDeptById(Integer id);

    @Delete("delete from department where id=#{id}")
    int deleteDeptById(Integer id);

    @Options(useGeneratedKeys = true, keyProperty = "id") //自增主键
    @Insert("insert into department(departmentname) values(#{departmentName})")
    int insertDept(Department department);

    @Update("update department set departmentname=#{departmentName} where id=#{id}")
    int updateDept(Department department);
}
