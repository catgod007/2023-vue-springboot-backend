package org.source.domain;

import lombok.Data;
import org.source.basic.domain.BaseDomain;

@Data
public class Employee extends BaseDomain {
    private String username;
    private String email;
    private String phone;
    private Integer state;
    private String salt; //盐值
    private String password; //密码
    private Integer age;
    private Long department_id;
    private Long logininfo_id;
    private Long shop_id;


}
