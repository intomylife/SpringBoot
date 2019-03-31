package com.zwc.base.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zwc.base.domain.SpringbootMybatisPlus;
import com.zwc.base.dto.request.SpringbootMybatisPlusRequestQueryDTO;
import com.zwc.base.dto.response.SpringbootMybatisPlusResponseDTO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/*
 * @ClassName SpringbootMybatisPlusMapper
 * @Desc TODO   springboot整合mybatis-plus测试表 mapper 接口
 * @Date 2019/3/26 17:52
 * @Version 1.0
 */
public interface SpringbootMybatisPlusMapper extends BaseMapper<SpringbootMybatisPlus> {

    // 分页查询测试表数据
    List<SpringbootMybatisPlusResponseDTO> query(@Param("data") SpringbootMybatisPlusRequestQueryDTO springbootMybatisPlusRequestQueryDTO , Page<SpringbootMybatisPlusResponseDTO> page);

}
