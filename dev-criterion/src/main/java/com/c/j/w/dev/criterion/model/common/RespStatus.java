package com.c.j.w.dev.criterion.model.common;

public enum RespStatus {

    Success(200, "业务处理成功，付款与退款结果表示处理完成"),//业务处理成功
    Failure(400, "业务处理失败"), // 提示message消息内容
    Error(500, "服务器内部异常");// 显示系统异常占位图

    public final int code;
    public final String name;

    RespStatus(int code, String name) {
        this.code = code;
        this.name = name;
    }

}
