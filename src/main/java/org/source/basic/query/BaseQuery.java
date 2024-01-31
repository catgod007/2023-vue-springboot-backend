package org.source.basic.query;

import lombok.Data;

@Data
public class BaseQuery {
    //创建当前页的字段
    private Integer currentPage  = 1;
    //创建每页显示的条数字段
    private Integer pageSize = 5;
    //计算起始行
    public Integer getStart(){
        return (this.currentPage - 1)*pageSize;
    }
    //关键字查询
    private String keyword;
}
