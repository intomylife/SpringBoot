package com.zwc.base.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

import java.io.Serializable;

/**
 * @ClassName SpringbootBase
 * @Desc TODO   地区表
 * @Date 2019/4/6 11:04
 * @Version 1.0
 */
@Data
public class SpringbootBase extends Model<SpringbootBase> {

    private static final long serialVersionUID = -1060341777312635327L;

    /**
     * 自增ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 父 id
     */
    private Long parentId;

    /**
     * 地区名
     */
    private String regionName;

    public static final String ID = "id";

    public static final String PARENT_ID = "parent_id";

    public static final String REGION_NAME = "region_name";

    @Override
    protected Serializable pkVal() {
        return null;
    }

}
