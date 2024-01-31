package org.source.basic.mapper;
import org.apache.ibatis.annotations.Mapper;
import org.source.basic.query.BaseQuery;

import java.util.List;

public interface BaseMapper<T> {
    //查询所有表里的信息的方法
    List<T> selectAll();
    //新增
    void insert(T t);
    //修改
    void update(T t);
    //删除
    T selectById(Long id);
    //删除
    void deleteById(Long id);
    //分页查询
    List<T> selectByPage(BaseQuery query);
    //查询总量
    Long count(BaseQuery query);
    //批量删除
    void batchDelete(List<Long> ids);
//    //根据id查询
//    T selectById(Long id);

}
