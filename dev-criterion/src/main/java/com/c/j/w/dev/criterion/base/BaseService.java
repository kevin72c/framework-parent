package com.c.j.w.dev.criterion.base;

import com.github.pagehelper.PageHelper;

import java.lang.reflect.Method;

/**
 * Service基类，提供分页方法
 * @Author chenjw
 * @Date 2016年11月04日
 */
public abstract class BaseService {

    /**
     * sql分页查询设置
     * @param obj
     */
    protected void startPage(Object obj) {
        try {
            Method getMethod = obj.getClass().getMethod("getPageNum");
            Object invokePageNum = getMethod.invoke(obj);
            int pageNum, pageSize;
            if (invokePageNum == null) {
                pageNum = 1;
            } else {
                pageNum = Integer.parseInt(getMethod.invoke(obj).toString());
            }
            getMethod = obj.getClass().getMethod("getPageSize");
            Object invokePageSize = getMethod.invoke(obj);
            if (invokePageSize == null) {
                pageSize = 10;
            } else {
                pageSize = Integer.parseInt(getMethod.invoke(obj).toString());
            }
            startPage(pageNum, pageSize);
        } catch (Exception e) {
            e.printStackTrace();
            throw new IllegalArgumentException("参数请继承BaseParam、或BasePage");
        }
    }

    protected void startPage(int pageNum, int pageSize) {
        pageNum = pageNum <= 0 ? 1 : pageNum;
        pageSize = pageSize > 50 ? 50 : pageSize;
        PageHelper.startPage(pageNum, pageSize);
    }
}
