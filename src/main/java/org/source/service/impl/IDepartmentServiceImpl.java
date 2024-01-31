package org.source.service.impl;

import org.source.basic.service.BaseService;
import org.source.basic.service.impl.BaseServiceImpl;
import org.source.domain.Department;
import org.source.mapper.IDepartmentMapper;
import org.source.query.DepartmentQuery;
import org.source.service.IDepartmentService;
import org.source.until.PageList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service //业务层
public class IDepartmentServiceImpl extends BaseServiceImpl<Department> implements IDepartmentService {
    @Autowired
    private IDepartmentMapper departmentMapper;
//    @Override
//    public Department selectById(Long id) {
//        return departmentMapper.selectById(id);
//    }
    @Override
    public void add(Department department) {
        departmentMapper.insert(department);
        //先设置空dirPath
        String dirPath="";
        //无上级部门dirPath新增规则
        if(department.getParent() == null){
            dirPath="/"+ department.getId();
        }else{
            Department parent = departmentMapper.selectById(department.getParent().getId());
            dirPath= parent.getDirPath()+"/"+department.getId();
        }
        department.setDirPath(dirPath);
        departmentMapper.update(department);
    }

    @Override
    public void updateById(Department department) {
        //先设置空dirPath
        String dirPath="";
        //无上级部门dirPath新增规则
        if(department.getParent() == null){
            dirPath="/"+ department.getId();
        }else{
            Department parent = departmentMapper.selectById(department.getParent().getId());
            dirPath= parent.getDirPath()+"/"+department.getId();
        }
        department.setDirPath(dirPath);

        departmentMapper.update(department);

    }

//    @Override
//    public void deleteById(Long id) {
//        departmentMapper.deleteById(id);
//    }
//
//    @Override
//    public PageList<Department> queryByPage(DepartmentQuery query) {
//        PageList<Department> pageList = new PageList<>();
//        //查询当前页的数据
//        List<Department> rows = departmentMapper.selectByPage(query);
//        pageList.setRows(rows);
//        //统计条数
//        Long total = departmentMapper.count(query);
//        pageList.setTotal(total);
//        return pageList;
//    }


    @Override
    public List<Department> queryTree() {
        //首先查询所有的部门数据，然后根据此条件进行筛选
        List<Department> departments = departmentMapper.selectAll();
        //查询顶级部门parent_id=null
        ArrayList<Department> level = new ArrayList<>();//装顶级部门
        for(Department department : departments){
            if(department.getParent_id() == null){
                level.add(department);//把顶级域名添加到level集合中
            }else {
                //找到有上级部门的部门，然后让他们把自己当作儿子设置到父亲的子集中去
                for(Department department1 : departments){
                    if (department.getParent_id() == department1.getId()) {
                        if(department.getChildren() == null){
                            department1.setChildren(new ArrayList<>());
                        }
                        department1.getChildren().add(department);
                    }
                }
            }
        }
        return level;
    }

}
