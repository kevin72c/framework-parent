package com.c.j.w.model.base.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("非pageHelper cms 分页信息，比如mongodb")
public class PageInfo<T> {

    @ApiModelProperty("总条数")
    private long totalItems;
    @ApiModelProperty("当前页数据信息")
    private List<T> list;

}
