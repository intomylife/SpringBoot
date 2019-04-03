package com.zwc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @ClassName SwaggerConfig
 * @Desc TODO   swagger 配置
 * @Date 2019/4/3 10:33
 * @Version 1.0
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    /*
     * @ClassName SwaggerConfig
     * @Desc TODO   swagger 配置信息
     * @Date 2019/4/3 11:00
     * @Version 1.0
     */
    @Bean
    public Docket docket(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())     // swagger 网页描述信息
                .enable(true)   // 是否开启
                .select()       // 选择那些路径和 api 会生成 document
                .apis(RequestHandlerSelectors.basePackage("com.zwc"))   // com.zwc 包下的 api 会生成 document
                .paths(PathSelectors.any()) // 表示所有路径都符合。PathSelectors.none() 表示所有路径都不符合
                .build();
    }

    /*
     * @ClassName SwaggerConfig
     * @Desc TODO   swagger 网页描述信息
     * @Date 2019/4/3 10:40
     * @Version 1.0
     */
    private ApiInfo apiInfo(){
        return new ApiInfoBuilder()
                .title("springboot 整合 swagger") // 标题
                .description("使用 springboot 整合 swagger 来构建 api 文档") // 描述
                .version("1.0.1")   // 版本
                .build();
    }

}
