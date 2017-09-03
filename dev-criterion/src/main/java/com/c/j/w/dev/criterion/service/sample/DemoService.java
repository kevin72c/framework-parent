package com.c.j.w.dev.criterion.service.sample;

import com.c.j.w.dev.criterion.model.common.Resp;
import com.c.j.w.dev.criterion.model.param.DemoPaginationParam;
import com.c.j.w.dev.criterion.model.param.DemoParam;
import com.c.j.w.dev.criterion.model.vo.DemoDetailVo;

import java.util.List;

/**
 * @Author chenjw
 * @Date 2016年11月04日
 */
public interface DemoService {

    /**
     * 创建
     * @param standardDetailVo
     * @return
     */
    Resp post(DemoDetailVo standardDetailVo);

    /**
     * 详情查询
     * @param demoID
     * @return
     */
    Resp<DemoDetailVo> detail(String demoID);

    /**
     * 列表查询
     * @param standardPageQueryParam
     * @return
     */
    Resp<List<DemoDetailVo>> list(DemoPaginationParam standardPageQueryParam);

    /**
     * 删除
     * @param demoID
     * @return
     */
    Resp delete(String demoID);

    /**
     * 全量更新
     * @param StandardDetailVo
     * @return
     */
    Resp put(DemoDetailVo StandardDetailVo);

    /**
     * 差量更新
     * @param standardParam
     * @return
     */
    Resp patch(DemoParam standardParam);

}
