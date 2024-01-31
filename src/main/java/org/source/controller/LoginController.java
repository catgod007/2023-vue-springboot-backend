package org.source.controller;

import org.source.domain.Login;
import org.source.service.IEmployeeService;
import org.source.until.AjaxResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
    @Autowired
    private IEmployeeService employeeService;
    @PostMapping("/login")
    public AjaxResult checkPassword(@RequestBody Login login){
        String result = employeeService.checkPassword(login);
        if(result.equals("密码正确")){
            return new AjaxResult();
        }else{
            return new AjaxResult(false,"操作失败");
        }
    }
}
