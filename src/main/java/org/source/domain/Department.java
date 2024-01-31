package org.source.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import org.source.basic.domain.BaseDomain;

import java.util.List;

@Data
public class Department extends BaseDomain {
    private String sn; //部门编号
    private String name; //部门名称
    private String dirPath; //部门的上级层级id
    private Integer state; //部门状态
    private Long manager_id;//部门管理员，关联Employee表id
    private Employee manager;//部门管理员对象
    private Long parent_id; //部门的上级,关联自己
    private Department parent;//上级部门对象
    @JsonInclude(JsonInclude.Include.NON_DEFAULT)//为空不显示
    List<Department> Children;  //儿子部门集合

}
