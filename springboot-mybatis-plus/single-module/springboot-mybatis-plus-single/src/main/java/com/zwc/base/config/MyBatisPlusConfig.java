package com.zwc.base.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName MyBatisPlusConfig
 * @Desc TODO   mybatis-plus 配置
 * @Date 2019/3/26 16:00
 * @Version 1.0
 */
@Configuration
public class MyBatisPlusConfig {

    /*
     * @ClassName MyBatisPlusConfig
     * @Desc TODO   mybatis-plus 配置拦截
     * @Date 2019/3/26 18:13
     * @Version 1.0
     */
    @Bean
    public PaginationInterceptor paginationInterceptor(){
        PaginationInterceptor paginationInterceptor = new PaginationInterceptor();
        // 设置方言
        paginationInterceptor.setDialectType("mysql");
        return paginationInterceptor;
    }
}
