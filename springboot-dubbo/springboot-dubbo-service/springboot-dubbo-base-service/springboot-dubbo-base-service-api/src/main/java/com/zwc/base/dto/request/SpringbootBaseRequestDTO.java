package com.zwc.base.dto.request;

import lombok.Data;

import java.io.Serializable;

/**
 * @ClassName SpringbootBaseRequestDTO
 * @Desc TODO   地区表 请求实体
 * @Date 2019/4/6 14:06
 * @Version 1.0
 */
@Data
public class SpringbootBaseRequestDTO implements Serializable {

    private static final long serialVersionUID = -6033774869534641513L;

    /**
     * 自增ID
     */
    private Long id;

    /**
     * 父 id
     */
    private Long parentId;

    /**
     * 地区名
     */
    private String regionName;

}
