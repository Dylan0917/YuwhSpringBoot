package org.yu.cache.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.yu.cache.bean.Department;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName DepartmentMapper.java
 * @Description TODO
 * @createTime 2021年01月31日 19:34:00
 */
@Mapper
public interface DepartmentMapper {

    public Department getDeptById(Integer id);

}
