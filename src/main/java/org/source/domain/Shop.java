package org.source.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.source.basic.domain.BaseDomain;

import java.util.Date;
@Data
public class Shop extends BaseDomain {
    private String name;
    private String tel;
    private String address;
    private String logo;
    private Integer state;

    private Long admin_id;
    private Employee admin;//部门管理员对象

    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    private Date registerTime=new Date();
}
