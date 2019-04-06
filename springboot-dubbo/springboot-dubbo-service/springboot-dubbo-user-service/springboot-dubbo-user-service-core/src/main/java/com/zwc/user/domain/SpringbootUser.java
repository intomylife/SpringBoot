package com.zwc.user.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

import java.io.Serializable;

/**
 * @ClassName SpringbootUser
 * @Desc TODO   用户表
 * @Date 2019/4/6 15:03
 * @Version 1.0
 */
@Data
public class SpringbootUser extends Model<SpringbootUser> {

    private static final long serialVersionUID = -1618223815247059296L;

    /**
     * 自增ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 地区 id
     */
    private Long regoinId;

    /**
     * 姓名
     */
    private String name;

    public static final String ID = "id";

    public static final String REGOIN_ID = "regoin_id";

    public static final String NAME = "name";

    @Override
    protected Serializable pkVal() {
        return null;
    }
}
