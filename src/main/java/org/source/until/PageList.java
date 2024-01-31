package org.source.until;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class PageList<T> {
    private Long total;//接收查询出来的总条数
    private List<T> rows = new ArrayList<>();//接收分页查询出来的总数据
}
