package com.zwc.base.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zwc.base.domain.SpringbootSwagger;
import com.zwc.base.dto.request.SpringbootSwaggerRequestQueryDTO;
import com.zwc.base.dto.response.SpringbootSwaggerResponseDTO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @ClassName SpringbootSwaggerMapper
 * @Desc TODO   springboot 整合 swagger 测试表 mapper 接口
 * @Date 2019/4/3 13:32
 * @Version 1.0
 */
public interface SpringbootSwaggerMapper extends BaseMapper<SpringbootSwagger> {

    // 分页查询测试表数据
    List<SpringbootSwaggerResponseDTO> query(@Param("data") SpringbootSwaggerRequestQueryDTO springbootSwaggerRequestQueryDTO , Page<SpringbootSwaggerResponseDTO> page);

}
