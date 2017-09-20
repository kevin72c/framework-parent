package com.c.j.w.cms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author chenjw
 * @date 2016年9月21日
 */
@SpringBootApplication
public class CMSApplication {

    /**
     * 登陆页面: http://localhost:8080/login.html
     * 首页：http://localhost:8080/
     * 接口文档地址: http://localhost:8080/swagger-ui.html#/
     * 接口测试地址:
     * Sql统计地址: http://localhost:8080/druid/index.html
     */
    public static void main(String[] args) {
        SpringApplication.run(CMSApplication.class, args);
    }
}
