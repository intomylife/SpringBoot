package com.zwc.base.dto.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/*
 * @ClassName SpringbootSwaggerRequestQueryDTO
 * @Desc TODO   springboot 整合 swagger 测试表 请求实体
 * @Date 2019/4/3 11:55
 * @Version 1.0
 */
@Data
@ApiModel("springboot 整合 swagger 测试表 请求实体")
public class SpringbootSwaggerRequestDTO implements Serializable{

    private static final long serialVersionUID = -7982800455179717633L;

    /**
     * 自增ID
     */
    @ApiModelProperty(value = "主键")
    private Long id;

    /**
     * 生活用品类别：1. 家电类 2. 厨具
     */
    @ApiModelProperty(value = "生活用品类别：1. 家电类 2. 厨具")
    private String type;

    /**
     * 生活用品名称
     */
    @ApiModelProperty(value = "生活用品名称")
    private String name;

    /**
     * 生活用品描述
     */
    @ApiModelProperty(value = "生活用品描述")
    private String description;
}
