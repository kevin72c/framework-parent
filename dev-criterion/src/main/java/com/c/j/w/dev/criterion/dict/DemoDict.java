package com.c.j.w.dev.criterion.dict;

/**
 * 标准字典写法，包含属性code name
 * @Author chenjw
 * @Date 2016年11月04日
 */
public enum DemoDict {

    Alpha(0, "A"), // 字典名首字母大写，下划线分隔
    Beta(1, "B");

    public final int code;
    public final String name;

    DemoDict(int code, String name) {
        this.code = code;
        this.name = name;
    }
}
