package com.c.j.w.dev.criterion.controller;

import com.c.j.w.dev.criterion.model.common.Resp;
import com.c.j.w.dev.criterion.model.param.DemoPaginationParam;
import com.c.j.w.dev.criterion.model.param.DemoParam;
import com.c.j.w.dev.criterion.service.sample.DemoService;
import com.c.j.w.dev.criterion.model.vo.DemoDetailVo;
import com.c.j.w.xcheck.support.annotation.Check;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 接口演示
 * 类注释带上功能模块名称，时间，开发人员
 * @author chenjw
 * @date 2016年9月21日 下午8:19:10
 */
@RestController
@RequestMapping("demo")
@Api(tags = "demo", description = "接口标准规范")
public class DemoController {

    @Autowired
    private DemoService demoService;

    @ApiOperation("创建Demo")
    @PostMapping
    @Check({"[demoID@d, demoName]"})
    public Resp post(@ModelAttribute DemoDetailVo standardDetailVo) {
        return demoService.post(standardDetailVo);
    }

    @ApiOperation("详情查询")
    @GetMapping(value = "{demoID}")
    public Resp<DemoDetailVo> detail(@PathVariable String demoID) {
        return demoService.detail(demoID);
    }

    @ApiOperation("列表查询")
    @GetMapping
    public Resp<List<DemoDetailVo>> list(@ModelAttribute DemoPaginationParam standardPageQueryParam) {
        return demoService.list(standardPageQueryParam);
    }

    @ApiOperation("删除Demo")
    @DeleteMapping("{demoID}")
    public Resp delete(@PathVariable String demoID) {
        return demoService.delete(demoID);
    }

    @ApiOperation("全量更新")
    @PutMapping
    @Check({"[demoIDLong,demoID]@d", "demoName@ml(128)"})
    public Resp put(@ModelAttribute DemoDetailVo StandardDetailVo) {
        return demoService.put(StandardDetailVo);
    }

    @ApiOperation("差量更新")
    @PatchMapping
    @Check({"demoID@d", "demoName@ml(128)"})
    public Resp patch(@ModelAttribute DemoParam standardParam) {
        return demoService.patch(standardParam);
    }

}
