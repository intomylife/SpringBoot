package com.zwc.base.api.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.zwc.base.api.SpringbootBaseApi;
import com.zwc.base.dto.response.SpringbootBaseResponseDTO;
import com.zwc.base.service.SpringbootBaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @ClassName SpringbootBaseApiImpl
 * @Desc TODO   地区表 服务实现类
 * @Date 2019/4/6 14:25
 * @Version 1.0
 */
@Service(interfaceClass = SpringbootBaseApi.class)
public class SpringbootBaseApiImpl implements SpringbootBaseApi {

    @Autowired
    private SpringbootBaseService springbootBaseService;

    /*
     * @ClassName SpringbootBaseApiImpl
     * @Desc TODO   获取全部地区
     * @Date 2019/4/6 14:28
     * @Version 1.0
     */
    @Override
    public List<SpringbootBaseResponseDTO> getAllBase() {
        return springbootBaseService.getAllBase();
    }

}
