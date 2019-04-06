package com.zwc.user.dto.request;

import lombok.Data;

import java.io.Serializable;

/**
 * @ClassName SpringbootUserRequestDTO
 * @Desc TODO   用户表 请求实体
 * @Date 2019/4/6 15:06
 * @Version 1.0
 */
@Data
public class SpringbootUserRequestDTO implements Serializable {

    private static final long serialVersionUID = -2029465466675294397L;

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
