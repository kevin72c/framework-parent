package com.c.j.w.model.base.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 分页基础类
 */
@ApiModel("分页参数基类")
public class BasePage {

    @ApiModelProperty(value = "当前页序号", required = true, allowableValues = "1")
    private Integer pageNum;
    @ApiModelProperty(value = "每页查询行数", required = true, allowableValues = "10")
    private Integer pageSize;

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}
