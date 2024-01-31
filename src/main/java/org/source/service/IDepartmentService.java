package org.source.service;

import org.source.basic.service.BaseService;
import org.source.domain.Department;
import org.source.query.DepartmentQuery;
import org.source.until.PageList;

import java.util.List;

public interface IDepartmentService extends BaseService<Department> {

//    //根据id查询
//    Department selectById(Long id);

    //修改
    void add(Department department);
    void updateById(Department department);


    List<Department> queryTree();

}
