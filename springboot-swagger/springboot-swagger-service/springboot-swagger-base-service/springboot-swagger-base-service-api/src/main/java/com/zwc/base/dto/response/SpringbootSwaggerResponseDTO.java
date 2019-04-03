package com.zwc.base.dto.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @ClassName SpringbootMybatisPlusResponseDTO
 * @Desc TODO   springboot 整合 swagger 测试表 响应结果
 * @Date 2019/3/26 17:50
 * @Version 1.0
 */
@Data
@ApiModel("springboot 整合 swagger 测试表 响应结果")
public class SpringbootSwaggerResponseDTO implements Serializable {


    private static final long serialVersionUID = 4545299466186896439L;

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