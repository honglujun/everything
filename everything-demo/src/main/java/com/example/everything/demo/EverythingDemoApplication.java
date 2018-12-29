package com.example.everything.demo;

import lombok.extern.log4j.Log4j2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

/**
 * 简单 Quartz-Cluster 微服务,支持集群分布式,并支持动态修改 Quartz 任务的 cronExpression 执行时间。
 *
 * @author win10
 */
@SpringBootApplication
@ImportResource("quartz.xml")
@Log4j2
public class EverythingDemoApplication {

    public static void main(String[] args) {
        log.info("简单Quartz-Cluster微服务入口函数编码-" + System.getProperty("file.encoding"));
        SpringApplication.run(EverythingDemoApplication.class, args);
        System.out.println("【【【【【【 简单Quartz-Cluster微服务 】】】】】】已启动.");
    }

}

