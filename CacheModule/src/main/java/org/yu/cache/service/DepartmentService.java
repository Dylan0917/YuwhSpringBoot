package org.yu.cache.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.yu.cache.bean.Department;
import org.yu.cache.mapper.DepartmentMapper;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName DepartmentService.java
 * @Description TODO
 * @createTime 2021年01月31日 21:41:00
 */
@Service
@CacheConfig(cacheNames = "dept",cacheManager = "deptCacheManager")
public class DepartmentService {

    DepartmentMapper departmentMapper;

    @Autowired
    public DepartmentService(DepartmentMapper departmentMapper) {
        this.departmentMapper = departmentMapper;
    }

    @Cacheable(key = "#id")
    public Department getDeptById(Integer id){
        Department deptById = departmentMapper.getDeptById(id);
        return deptById;
    }

}
