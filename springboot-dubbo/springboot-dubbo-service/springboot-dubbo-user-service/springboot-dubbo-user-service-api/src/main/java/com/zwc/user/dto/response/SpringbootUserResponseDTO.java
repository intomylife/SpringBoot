package com.zwc.user.dto.response;

import lombok.Data;

import java.io.Serializable;

/**
 * @ClassName SpringbootUserResponseDTO
 * @Desc TODO   用户表 响应结果
 * @Date 2019/4/6 15:08
 * @Version 1.0
 */
@Data
public class SpringbootUserResponseDTO implements Serializable {

    private static final long serialVersionUID = 1523346474077849028L;

    /**
     * 自增ID
     */
    private Long id;

    /**
     * 地区 id
     */
    private Long regoinId;

    /**
     * 姓名
     */
    private String name;

}
