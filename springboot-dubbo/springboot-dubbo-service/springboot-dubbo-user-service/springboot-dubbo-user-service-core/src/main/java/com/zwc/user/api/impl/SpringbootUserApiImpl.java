package com.zwc.user.api.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.zwc.user.api.SpringbootUserApi;
import com.zwc.user.dto.response.SpringbootUserResponseDTO;
import com.zwc.user.service.SpringbootUserService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @ClassName SpringbootUserApiImpl
 * @Desc TODO   用户表 服务实现类
 * @Date 2019/4/6 15:10
 * @Version 1.0
 */
@Service(interfaceClass = SpringbootUserApi.class)
public class SpringbootUserApiImpl implements SpringbootUserApi {

    @Autowired
    private SpringbootUserService springbootUserService;

    /*
     * @ClassName SpringbootUserApiImpl
     * @Desc TODO   获取全部用户
     * @Date 2019/4/6 15:11
     * @Version 1.0
     */
    @Override
    public List<SpringbootUserResponseDTO> getAllUser() {
        return springbootUserService.getAllUser();
    }

}
