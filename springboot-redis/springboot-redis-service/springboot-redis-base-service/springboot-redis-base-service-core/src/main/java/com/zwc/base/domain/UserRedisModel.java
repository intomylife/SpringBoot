package com.zwc.base.domain;

import lombok.Data;

import java.io.Serializable;

/**
 * @ClassName UserRedisModel
 * @Desc TODO   封装用户信息（Redis用）
 * @Date 2019/3/31 14:01
 * @Version 1.0
 */
@Data
public class UserRedisModel implements Serializable {

    private static final long serialVersionUID = 6659067190960087996L;

    /**
     * 姓名
     */
    private String name;
    /**
     * 年龄
     */
    private Integer age;
}
