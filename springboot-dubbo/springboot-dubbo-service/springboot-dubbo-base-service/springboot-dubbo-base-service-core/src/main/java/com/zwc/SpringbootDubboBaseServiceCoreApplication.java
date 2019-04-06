package com.zwc;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
 * @ClassName SpringbootDubboBaseServiceCoreApplication
 * @Desc TODO   启动类
 * @Date 2019/4/6 15:12
 * @Version 1.0
 */
@SpringBootApplication(scanBasePackages = "com.zwc")
@MapperScan("com.zwc.base.mapper")
@EnableDubbo
public class SpringbootDubboBaseServiceCoreApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootDubboBaseServiceCoreApplication.class, args);
    }

}
