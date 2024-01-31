package org.source.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.source.App;
import org.source.domain.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest(classes = App.class)
public class IEmployeeMapperTest {
@Autowired
    private IEmployeeMapper employeeMapper;
    @Test
    public void selectAll() {
        List<Employee> employees = employeeMapper.selectAll();
        System.out.println(employees);
    }

    @Test
    public void selectById() {
        Employee employee = employeeMapper.selectById(324l);
        System.out.println(employee);
    }

    @Test
    public void insert() {
        Employee employee = new Employee();
        employee.setId(11L);
        employee.setAge(22);
        employee.setEmail("333@qq.com");
        employee.setPassword("4444");
        employee.setPhone("5555555555");
        employee.setUsername("66666");
        employee.setSalt("7777");
        employee.setState(0);//0正常 -1禁用
        employee.setDepartment_id(47L);
        employee.setLogininfo_id(333L);
        employee.setShop_id(27L);

        employeeMapper.insert(employee);
    }

    @Test
    public void insertUser() {
        Employee employee = new Employee();
        employee.setId(324L);
        employee.setEmail("9876333456@qq.com");
        employee.setPhone("153983376544");

        employeeMapper.insertUser(employee);
    }

    @Test
    public void update() {
        Employee employee = new Employee();
        employee.setId(332L);
        employee.setEmail("Spring@qq.com");
        employee.setUsername("springboot");

        employeeMapper.update(employee);
    }

    @Test
    public void deleteById() {
        employeeMapper.deleteById(324L);

    }
}