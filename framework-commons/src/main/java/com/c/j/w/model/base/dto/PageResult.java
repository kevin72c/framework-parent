package com.c.j.w.model.base.dto;

import com.github.pagehelper.PageInfo;
import lombok.Setter;
import lombok.Getter;

import java.util.List;

/**
 * @Author chenjw
 * @Date 2016年08月25日
 */
@Getter
@Setter
public class PageResult {

    private long totalItems;
    private List list;

    public <T> PageResult(List<T> list) {
        PageInfo pageInfo = new PageInfo(list);
        this.totalItems = pageInfo.getTotal();
        this.list = pageInfo.getList();
    }
}
