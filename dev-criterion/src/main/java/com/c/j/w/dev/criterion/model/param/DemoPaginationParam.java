package com.c.j.w.dev.criterion.model.param;

import com.c.j.w.dev.criterion.base.BasePage;
import io.swagger.annotations.ApiModelProperty;
import lombok.Setter;
import lombok.Getter;

/**
 * @module 标准分页查询请求参数 统一继承BasePage
 * @author chenjw
 * @date: 2016/11/4 17:23
 */
@Getter
@Setter
public class DemoPaginationParam extends BasePage {

    @ApiModelProperty("查询关键字")
    private String keyword;
}
