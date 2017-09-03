package com.c.j.w.dev.criterion.model.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Setter;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * VO = View Object 视图对象，一般接口出参使用，用于前端数据展示
 * @author chenjw
 * @date 2017/9/1 22:48
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DemoDetailVo {

    @ApiModelProperty("演示ID")
    private String demoID;
    @ApiModelProperty("演示ID")
    private Integer demoIDInt;
    @ApiModelProperty("演示ID")
    private Long demoIDLong;
    @ApiModelProperty("演示名称")
    private String demoName;

}
