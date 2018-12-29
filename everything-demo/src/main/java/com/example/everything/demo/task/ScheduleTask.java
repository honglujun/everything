package com.example.everything.demo.task;

import lombok.extern.log4j.Log4j2;
import org.quartz.JobExecutionContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Component;

/**
 * 调度的任务
 * <p>
 * testScheduleTask 字符串名称在 quartz.xml 中配置为属性 targetObject 的 value 值。</li>
 * sayHello 方法名称在 quartz.xml 中配置为属性 targetMethod 的 value 值。</li>
 *
 * @author win10
 */
@Configuration
@Component("testScheduleTask")
@EnableScheduling
@Log4j2
public class ScheduleTask {

    public void sayHello(JobExecutionContext context) {
        log.info("====sayHello 123456789====");
        System.out.println("====sayHello 123456789====");
    }
}
