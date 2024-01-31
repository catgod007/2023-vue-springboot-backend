package org.source.service.impl;

import org.source.basic.query.BaseQuery;
import org.source.basic.service.BaseService;
import org.source.basic.service.impl.BaseServiceImpl;
import org.source.config.MD5Utils;
import org.source.domain.Employee;
import org.source.domain.Login;
import org.source.mapper.IEmployeeMapper;
import org.source.query.EmployeeQuery;
import org.source.service.IEmployeeService;
import org.source.until.PageList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class IEmployeeServiceImpl extends BaseServiceImpl<Employee> implements IEmployeeService {
    @Autowired
    private IEmployeeMapper employeeMapper;

//    @Override
//    public Employee selectById(Long id) {
//        return employeeMapper.selectById(id);
//    }


    @Override
    public void insertUser(Employee employee) {
        employeeMapper.insertUser(employee);
    }

//    @Override
//    public PageList<Employee> selectByPage(EmployeeQuery query) {
//        PageList<Employee> pageList = new PageList<>();
//        //查询当前页的数据
//        List<Employee> rows = employeeMapper.selectByPage(query);
//        pageList.setRows(rows);
//        //统计条数
//        Long total = employeeMapper.count(query);
//        pageList.setTotal(total);
//        return pageList;
//    }

    @Override
    public String checkPassword(Login login) {
        Employee employee = employeeMapper.selectByUserName(login.getUsername());
        //用户名为空
        if(employee==null){
            return "账户或密码有误请重新输入！！！！";
        }
        if(employee.getPassword().equals(MD5Utils.string2MD5(login.getPassword()))){
            return "密码正确";
        }
        return "非法请求";
    }
}
