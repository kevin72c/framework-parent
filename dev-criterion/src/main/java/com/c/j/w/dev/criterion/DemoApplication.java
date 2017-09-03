package com.c.j.w.dev.criterion;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * @desc Spring应用启动类
 * @author chenjw
 * @date: 2016/11/4 17:24
 */
@SpringBootApplication
@EnableAsync // 开启异步调用
public class DemoApplication {


    /**
     * 接口文档地址: http://localhost:8080/swagger-ui.html
     * 接口测试地址:
     * Sql统计地址: http://localhost:8080/druid/index.html
     */
    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
        System.out.println("launch success");
    }

}
