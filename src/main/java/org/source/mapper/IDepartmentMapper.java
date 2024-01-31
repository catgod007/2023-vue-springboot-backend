package org.source.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.source.basic.mapper.BaseMapper;
import org.source.domain.Department;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;

@Mapper

public interface IDepartmentMapper extends BaseMapper<Department> {
//    //根据id查询
//    Department selectById(Long id);

}
