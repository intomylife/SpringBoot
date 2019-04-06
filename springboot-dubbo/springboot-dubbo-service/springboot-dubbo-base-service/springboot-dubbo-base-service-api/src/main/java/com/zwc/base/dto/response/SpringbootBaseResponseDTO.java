package com.zwc.base.dto.response;

import lombok.Data;

import java.io.Serializable;

/**
 * @ClassName SpringbootBaseResponseDTO
 * @Desc TODO   地区表 响应结果
 * @Date 2019/4/6 14:14
 * @Version 1.0
 */
@Data
public class SpringbootBaseResponseDTO implements Serializable {

    private static final long serialVersionUID = -5291785859839669548L;

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
