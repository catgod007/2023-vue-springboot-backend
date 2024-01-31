package org.source.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.source.basic.mapper.BaseMapper;
import org.source.domain.Employee;
import org.source.query.EmployeeQuery;
import org.source.service.IDepartmentService;
import org.springframework.beans.factory.annotation.Qualifier;


import java.util.List;
@Mapper
public interface IEmployeeMapper extends BaseMapper<Employee> {
//    //根据id查询
//    Employee selectById(Long id);
    //新增
    void insertUser(Employee employee);
    Employee selectByUserName(String username);
}