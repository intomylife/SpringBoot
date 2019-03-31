package com.zwc;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.zwc")
@MapperScan("com.zwc.base.mapper")
public class SpringbootMybatisPlusSingleApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootMybatisPlusSingleApplication.class, args);
    }

}
