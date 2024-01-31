package org.source.controller;
import org.source.domain.Department;
import org.source.query.DepartmentQuery;
import org.source.service.IDepartmentService;
import org.source.until.AjaxResult;
import org.source.until.PageList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController//@Controller+@ResponseBody组成
@RequestMapping("/dept")//注解用于请求地址的解析
public class DepartmentController {
    @Autowired
    private IDepartmentService departmentService;//控制层根据前端的请求去调用相对应的业务层的代码，所以要注入业务层代码
    @GetMapping
    public List<Department> queryall(){
        return departmentService.selectAll();

    }
    @GetMapping("/{id}")
    public Department queryById(@PathVariable("id")Long id){//传id类型
        return departmentService.selectById(id);
    }

    @PostMapping
    public PageList<Department> queryByPage(@RequestBody DepartmentQuery query){
        return departmentService.queryByPage(query);
    }

    @PutMapping
    public AjaxResult AddOrUpdate(@RequestBody Department department){//传对象
        try{
            if(department.getId() == null){
                departmentService.add(department);
            }else{
                departmentService.update(department);
            }
        }catch (Exception e){
            e.printStackTrace();
            return new AjaxResult(false,"操作失败!!!!");
        }
        return new AjaxResult(true,"操作成功！！！");
    }

    @DeleteMapping("/{id}")
    public AjaxResult remove(@PathVariable("id")Long id){
        try {
            departmentService.deleteById(id);
        }catch (Exception e){
            e.printStackTrace();
            return new AjaxResult(false,"删除失败");
        }
        return new AjaxResult(true,"删除成功");

    }
    @PatchMapping
    public AjaxResult batchRemove(@RequestBody List<Long> ids){
        System.out.println(ids);
        try {
            departmentService.batchDelete(ids);
        }catch (Exception e){
            e.printStackTrace();
            return new AjaxResult(false,"删除失败");
        }
        return new AjaxResult(true,"删除成功");

    }
    @GetMapping("/tree")
    public List<Department> queryTree(){
        return departmentService.queryTree();
    }







}
