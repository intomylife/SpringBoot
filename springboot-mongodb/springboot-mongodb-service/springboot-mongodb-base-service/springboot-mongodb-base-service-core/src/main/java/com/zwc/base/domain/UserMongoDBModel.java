package com.zwc.base.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.io.Serializable;

/**
 * @ClassName UserMongoDBModel
 * @Desc TODO   封装用户信息（MongoDB用）
 * @Date 2019/4/1 11:38
 * @Version 1.0
 */
@Data
public class UserMongoDBModel implements Serializable {


    private static final long serialVersionUID = 4323601054963453176L;

    @Id
    private String id;
    /**
     * 姓名
     */
    private String name;
    /**
     * 年龄
     */
    private Integer age;
}
