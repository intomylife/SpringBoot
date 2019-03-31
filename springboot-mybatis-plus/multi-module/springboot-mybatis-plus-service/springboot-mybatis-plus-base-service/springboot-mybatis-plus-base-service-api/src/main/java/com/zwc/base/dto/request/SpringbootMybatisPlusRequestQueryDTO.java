package com.zwc.base.dto.request;

import lombok.Data;

import java.io.Serializable;

/**
 * @ClassName SpringbootMybatisPlusRequestQueryDTO
 * @Desc TODO   springboot整合mybatis-plus测试表 请求实体
 * @Date 2019/3/26 17:48
 * @Version 1.0
 */
@Data
public class SpringbootMybatisPlusRequestQueryDTO implements Serializable {


    private static final long serialVersionUID = 6944556848931852242L;

    /*
     * 分页条件
     */
    private int pageNum;
    private int pageSize;

    /**
     * 自增ID
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
