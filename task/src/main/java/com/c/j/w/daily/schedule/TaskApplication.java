package com.c.j.w.daily.schedule;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * 定时任务启动类
 * @Author chenjw
 * @Date 2016年12月08日
 */
@SpringBootApplication
@EnableScheduling
public class TaskApplication {

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        new SpringApplicationBuilder(TaskApplication.class).web(false).run(args);
        System.out.println("启动成功...耗时:" + (System.currentTimeMillis() - startTime) / 1000 + "s");
    }
}
