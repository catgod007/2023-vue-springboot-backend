package org.source.basic.service.impl;

import org.source.basic.mapper.BaseMapper;
import org.source.basic.query.BaseQuery;
import org.source.basic.service.BaseService;
import org.source.until.PageList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

public class BaseServiceImpl<T> implements BaseService<T> {

@Autowired
    private BaseMapper<T> baseMapper;
    @Override
    public List<T> selectAll() {
        return baseMapper.selectAll();
    }

    @Override
    public void insert(T t) {
        baseMapper.insert(t);
    }

    @Override
    public T selectById(Long id) {
        return baseMapper.selectById(id);
    }

    @Override
    public void update(T t) {
        baseMapper.update(t);

    }

    @Override
    public void deleteById(Long id) {
        baseMapper.deleteById(id);

    }

    @Override
    public PageList<T> queryByPage(BaseQuery query) {
        PageList<T> pageList = new PageList<>();
        //查询当前页的数据
        List<T> rows = baseMapper.selectByPage(query);
        pageList.setRows(rows);
        //统计条数
        Long total = baseMapper.count(query);
        pageList.setTotal(total);
        return pageList;
    }

    @Override
    public void batchDelete(List ids) {
        baseMapper.batchDelete(ids);
    }
}

















































