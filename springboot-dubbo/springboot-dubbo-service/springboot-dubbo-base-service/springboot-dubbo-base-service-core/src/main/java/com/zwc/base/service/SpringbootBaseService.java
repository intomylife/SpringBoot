package com.zwc.base.service;

import com.alibaba.dubbo.config.annotation.Reference;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zwc.base.domain.SpringbootBase;
import com.zwc.base.dto.response.SpringbootBaseResponseDTO;
import com.zwc.base.mapper.SpringbootBaseMapper;
import com.zwc.user.api.SpringbootUserApi;
import com.zwc.user.dto.response.SpringbootUserResponseDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName SpringbootBaseService
 * @Desc TODO   地区表 实现服务类
 * @Date 2019/4/6 14:04
 * @Version 1.0
 */
@Service
public class SpringbootBaseService extends ServiceImpl<SpringbootBaseMapper,SpringbootBase> {

    @Resource
    private SpringbootBaseMapper springbootBaseMapper;

    /*
     * @ClassName SpringbootBaseService
     * @Desc TODO   获取全部地区
     * @Date 2019/4/6 14:31
     * @Version 1.0
     */
    public List<SpringbootBaseResponseDTO> getAllBase(){
        // 返回
        List<SpringbootBaseResponseDTO> result = new ArrayList<>();
        // 调用查询
        List<SpringbootBase> list = super.list(new QueryWrapper<>());
        // 遍历结果
        list.forEach(base -> {
            SpringbootBaseResponseDTO springbootBaseResponseDTO = new SpringbootBaseResponseDTO();
            // 复值
            BeanUtils.copyProperties(base,springbootBaseResponseDTO);
            // 添加到返回集合中
            result.add(springbootBaseResponseDTO);
        });

        // 返回
        return result;
    }

}
