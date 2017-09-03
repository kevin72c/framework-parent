package com.c.j.w.dev.criterion.service.sample.impl;

import com.c.j.w.dev.criterion.base.BaseService;
import com.c.j.w.dev.criterion.model.common.Resp;
import com.c.j.w.dev.criterion.model.param.DemoPaginationParam;
import com.c.j.w.dev.criterion.model.param.DemoParam;
import com.c.j.w.dev.criterion.service.sample.DemoService;
import com.c.j.w.dev.criterion.model.vo.DemoDetailVo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Service demo
 * @Author chenjw
 * @Date 2016年11月04日
 */
@Service
public class DemoServiceImpl extends BaseService implements DemoService {
    // 统一继承baseService接口

    @Transactional // 使用注解管理事务
    @Override
    public Resp post(DemoDetailVo standardDetailVo) {
        return Resp.success("demo创建成功");
    }

    @Override
    public Resp<DemoDetailVo> detail(String demoID) {
        DemoDetailVo demoDetailVo = new DemoDetailVo();
        demoDetailVo.setDemoID(demoID);
        demoDetailVo.setDemoName("Demo查询演示详情");
        return Resp.success(demoDetailVo);
    }

    @Override
    public Resp<List<DemoDetailVo>> list(DemoPaginationParam standardPageQueryParam) {
        // 使用startPage方法设置分页
        startPage(standardPageQueryParam);
        return Resp.success(new ArrayList<>());
    }

    @Override
    public Resp delete(String demoID) {
        return Resp.success("删除"+ demoID + "成功");
    }

    @Override
    public Resp put(DemoDetailVo StandardDetailVo) {
        return Resp.success("全量更新成功");
    }

    @Override
    public Resp patch(DemoParam standardParam) {
        return Resp.success("差量更新成功");
    }
}
