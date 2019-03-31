package com.zwc.base.dto.response;

import lombok.Data;

import java.io.Serializable;

/**
 * @ClassName SpringbootMybatisPlusResponseDTO
 * @Desc TODO   springboot整合mybatis-plus测试表 响应结果
 * @Date 2019/3/26 17:50
 * @Version 1.0
 */
@Data
public class SpringbootMybatisPlusResponseDTO implements Serializable {


    private static final long serialVersionUID = 4545299466186896439L;

    /**
     * 自增 id
     */
    private Long id;

    /**
     * 生活用品类别：1. 家电类 2. 厨具
     */
    private String type;

    /**
     * 生活用品名称
     */
    private String name;

    /**
     * 生活用品描述
     */
    private String description;
}
