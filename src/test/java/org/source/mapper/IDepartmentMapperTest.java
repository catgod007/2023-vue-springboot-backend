package org.source.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.source.App;
import org.source.domain.Department;
import org.source.domain.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = App.class)
public class IDepartmentMapperTest {
@Autowired //引入
    private IDepartmentMapper departmentMapper;
    @Test
    public void selectAll() {
        List<Department> departments = departmentMapper.selectAll();
        System.out.println(departments);
    }

    @Test
    public void selectById() {
        Department department = departmentMapper.selectById(1L);
        System.out.println(department);
    }

    @Test
    //springboot测试
    public void insert() {
//        Department department = new Department(47L,"ch","部门6","/6/6/6",0,324L,66L);
//
//        departmentMapper.insert(department);

        Department department =new Department();
        department.setSn("number");
        department.setName("练拳");
        department.setDirPath("/5");
        //设置管理员
        Employee employee = new Employee();
        employee.setId(324L);
        department.setManager(employee);
        //设置上级部门
        Department department1 = new Department();
        department1.setId(27L);
        department.setParent(department1);
        //调用新增方法
        departmentMapper.insert(department);


    }

    @Test
    public void update() {
        Department department = new Department();
        department.setSn("number");
        department.setName("练拳");
        departmentMapper.update(department);
    }
}