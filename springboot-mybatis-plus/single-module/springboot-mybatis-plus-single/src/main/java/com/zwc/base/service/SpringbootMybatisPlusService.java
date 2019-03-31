package com.zwc.base.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zwc.base.dto.request.SpringbootMybatisPlusRequestQueryDTO;
import com.zwc.base.dto.response.SpringbootMybatisPlusResponseDTO;

/*
 * @ClassName SpringbootMybatisPlusService
 * @Desc TODO   springboot整合mybatis-plus测试表 服务类
 * @Date 2019/3/26 17:55
 * @Version 1.0
 */
public interface SpringbootMybatisPlusService {

    // 新增数据
    String add();

    // 删除数据
    String delete();

    // 更新数据
    String update();

    // 分页查询测试表数据
    Page<SpringbootMybatisPlusResponseDTO> getDataByPage(SpringbootMybatisPlusRequestQueryDTO springbootMybatisPlusRequestQueryDTO);
}
