package org.source.service;

import org.source.basic.service.BaseService;
import org.source.domain.Employee;
import org.source.domain.Login;
import org.source.query.EmployeeQuery;
import org.source.until.PageList;

import java.util.List;

public interface IEmployeeService extends BaseService<Employee> {

//    //根据id查询
//    Employee selectById(Long id);

    //新增
    void insertUser(Employee employee);


    String checkPassword(Login login);
}
