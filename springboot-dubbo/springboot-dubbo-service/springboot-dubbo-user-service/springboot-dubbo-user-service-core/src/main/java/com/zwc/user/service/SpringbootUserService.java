package com.zwc.user.service;

import com.alibaba.dubbo.config.annotation.Reference;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zwc.base.api.SpringbootBaseApi;
import com.zwc.base.dto.response.SpringbootBaseResponseDTO;
import com.zwc.user.domain.SpringbootUser;
import com.zwc.user.dto.response.SpringbootUserResponseDTO;
import com.zwc.user.mapper.SpringbootUserMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName SpringbootUserService
 * @Desc TODO   用户表 实现服务类
 * @Date 2019/4/6 15:16
 * @Version 1.0
 */
@Service
public class SpringbootUserService extends ServiceImpl<SpringbootUserMapper,SpringbootUser> {

    @Resource
    private SpringbootUserMapper springbootUserMapper;

    // 引入 base - service 工程的接口
    @Reference
    private SpringbootBaseApi springbootBaseApi;

    /*
     * @ClassName SpringbootUserService
     * @Desc TODO   获取全部用户
     * @Date 2019/4/6 15:18
     * @Version 1.0
     */
    public List<SpringbootUserResponseDTO> getAllUser(){
        // 返回
        List<SpringbootUserResponseDTO> result = new ArrayList<>();
        // 调用查询
        List<SpringbootUser> list = super.list(new QueryWrapper<>());
        // 遍历结果
        list.forEach(user -> {
            SpringbootUserResponseDTO springbootUserResponseDTO = new SpringbootUserResponseDTO();
            // 复值
            BeanUtils.copyProperties(user,springbootUserResponseDTO);
            // 添加到返回集合中
            result.add(springbootUserResponseDTO);
        });

        // 返回
        return result;
    }


    /*
     * @ClassName SpringbootUserService
     * @Desc TODO   获取全部地区（调用 base - service 接口）
     * @Date 2019/4/6 15:36
     * @Version 1.0
     */
    public List<SpringbootBaseResponseDTO> getAllBase(){
        // 调用 base - service 工程的接口
        List<SpringbootBaseResponseDTO> result = springbootBaseApi.getAllBase();
        // 返回
        return result;
    }

    /*
     * @ClassName SpringbootUserService
     * @Desc TODO   获取全部用户详情信息
     * @Date 2019/4/6 23:11
     * @Version 1.0
     */
    public List<Map<String,Object>> getDetailInfo(){
        // 返回对象
        List<Map<String,Object>> result = new ArrayList<>();
        // 调用查询 获取全部用户信息
        List<SpringbootUser> userList = super.list(new QueryWrapper<>());
        // 调用接口 获取全部地区信息
        List<SpringbootBaseResponseDTO> baseList = springbootBaseApi.getAllBase();

        // 遍历所有用户
        userList.forEach(user -> {
            // 一个用户存一个 map
            Map<String,Object> map = new HashMap<>();
            map.put("id",user.getId());
            map.put("name",user.getName());
            // 遍历所有地区
            baseList.forEach(base -> {
                if(user.getRegoinId() == base.getId()){
                    map.put("area",base.getRegionName());
                }
            });
            // 放入返回集合对象中
            result.add(map);
        });

        // 返回结果
        return result;
    }

}
