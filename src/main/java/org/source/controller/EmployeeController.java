package org.source.controller;

import org.source.domain.Employee;

import org.source.service.IEmployeeService;
import org.source.until.AjaxResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

    @RestController//@Controller+@ResponseBody组成
    @RequestMapping("/emp")//注解用于请求地址的解析
    public class EmployeeController {
        @Autowired
        private IEmployeeService employeeService;//控制层根据前端的请求去调用相对应的业务层的代码，所以要注入业务层代码

        @GetMapping
        public List<Employee> queryall() {
            return employeeService.selectAll();

        }

        @GetMapping("/{id}")
        public Employee queryById(@PathVariable("id") Long id) {//传id类型
            return employeeService.selectById(id);
        }


//        @PostMapping
//        public PageList<Employee> queryByPage(@RequestBody EmployeeQuery query) {
//            return employeeService.queryByPage(query);
//        }

        @PutMapping
        public AjaxResult AddOrUpdate(@RequestBody Employee employee) {//传对象
            try {
                if (employee.getId() == null) {
                    employeeService.insert(employee);
                } else {
                    employeeService.update(employee);
                }
            } catch (Exception e) {
                e.printStackTrace();
                return new AjaxResult(false, "操作失败!!!!");
            }
            return new AjaxResult(true, "操作成功！！！");
        }

        @DeleteMapping("/{id}")
        public AjaxResult remove(@PathVariable("id") Long id) {
            try {
                employeeService.deleteById(id);
            } catch (Exception e) {
                e.printStackTrace();
                return new AjaxResult(false, "删除失败");
            }
            return new AjaxResult(true, "删除成功");

        }

        @PatchMapping
        public AjaxResult batchRemove(@RequestBody List<Long> ids) {
            System.out.println(ids);
            try {
                employeeService.batchDelete(ids);
            } catch (Exception e) {
                e.printStackTrace();
                return new AjaxResult(false, "删除失败");
            }
            return new AjaxResult(true, "删除成功");

        }

    }

