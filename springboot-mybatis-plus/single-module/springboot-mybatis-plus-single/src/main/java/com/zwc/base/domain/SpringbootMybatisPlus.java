package com.zwc.base.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

import java.io.Serializable;

/**
 * @ClassName SpringbootMybatisPlus
 * @Desc TODO   springboot整合mybatis-plus测试表
 * @Date 2019/3/26 17:45
 * @Version 1.0
 */
@Data
public class SpringbootMybatisPlus extends Model<SpringbootMybatisPlus> {


    private static final long serialVersionUID = -7876888313791106541L;


    /**
     * 自增ID
     */
    @TableId(value = "id", type = IdType.AUTO)
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

    public static final String ID = "id";

    public static final String TYPE = "type";

    public static final String NAME = "name";

    public static final String DESCRIPTION = "description";

    @Override
    protected Serializable pkVal() {
        return this.id;
    }
}
