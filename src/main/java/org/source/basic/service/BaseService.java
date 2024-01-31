package org.source.basic.service;
import org.source.basic.query.BaseQuery;
import org.source.until.PageList;

import java.util.List;

public interface BaseService<T> {
    //查询所有表里的信息的方法
    List<T> selectAll();
    //新增
    void insert(T t);
    T selectById(Long id);
    //修改
    void update(T t);
    //删除
    void deleteById(Long id);
    //分页查询+统计条数
    PageList<T> queryByPage(BaseQuery query);
    //批量删除
    void batchDelete(List<Long> ids);

}
