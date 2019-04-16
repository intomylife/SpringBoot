package com.zwc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/*
 * @ClassName SpringbootSchedulingBaseServiceCoreApplication
 * @Desc TODO   SpringBoot 启动类
 * @Date 2019/4/16 21:07
 * @Version 1.0
 */
@SpringBootApplication
@EnableScheduling
public class SpringbootSchedulingBaseServiceCoreApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootSchedulingBaseServiceCoreApplication.class, args);
    }

}
