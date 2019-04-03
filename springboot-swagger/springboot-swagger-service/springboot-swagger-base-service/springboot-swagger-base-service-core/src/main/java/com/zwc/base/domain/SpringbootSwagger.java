package com.zwc.base.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/*
 * @ClassName SpringBootSwagger
 * @Desc TODO   springboot 整合 swagger 测试表
 * @Date 2019/4/3 11:07
 * @Version 1.0
 */
@Data
@ApiModel("springboot 整合 swagger 测试表")
public class SpringbootSwagger extends Model<SpringbootSwagger> {

    private static final long serialVersionUID = -7876888313791106541L;


    /**
     * 自增ID
     */
    @ApiModelProperty(value = "主键")
    @TableId(value = "id", type = IdType.AUTO)
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

    public static final String ID = "id";

    public static final String TYPE = "type";

    public static final String NAME = "name";

    public static final String DESCRIPTION = "description";

    @Override
    protected Serializable pkVal() {
        return this.id;
    }
}
