package com.c.j.w.dev.criterion.model.param;

import io.swagger.annotations.ApiModelProperty;

/**
 * @module 普通表单参数
 * @author chenjw
 * @date: 2016/11/4 17:23
 */
public class DemoParam {

    @ApiModelProperty("演示ID")
    private Integer demoID;
    @ApiModelProperty("演示名称")
    private String demoName;

    public Integer getDemoID() {
        return demoID;
    }

    public void setDemoID(Integer demoID) {
        this.demoID = demoID;
    }

    public String getDemoName() {
        return demoName;
    }

    public void setDemoName(String demoName) {
        this.demoName = demoName;
    }
}
