package com.zwc.base.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zwc.base.domain.SpringbootSwagger;
import com.zwc.base.dto.request.SpringbootSwaggerRequestAddDTO;
import com.zwc.base.dto.request.SpringbootSwaggerRequestDTO;
import com.zwc.base.dto.request.SpringbootSwaggerRequestQueryDTO;
import com.zwc.base.dto.response.SpringbootSwaggerResponseDTO;
import com.zwc.base.mapper.SpringbootSwaggerMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName SpringbootSwaggerService
 * @Desc TODO   springboot 整合 swagger 测试表 实现服务类
 * @Date 2019/4/3 13:37
 * @Version 1.0
 */
@Service
public class SpringbootSwaggerService extends ServiceImpl<SpringbootSwaggerMapper,SpringbootSwagger> {

    @Resource
    private SpringbootSwaggerMapper springbootSwaggerMapper;

    /*
     * @ClassName SpringbootSwaggerService
     * @Desc TODO   新增数据
     * @Date 2019/4/3 13:39
     * @Version 1.0
     */
    public String add(SpringbootSwaggerRequestAddDTO springbootSwaggerRequestAddDTO){
        if(StringUtils.isEmpty(springbootSwaggerRequestAddDTO.getType())
                && StringUtils.isEmpty(springbootSwaggerRequestAddDTO.getName())
                && StringUtils.isEmpty(springbootSwaggerRequestAddDTO.getDescription())){
            return "object is null";
        }
        // 返回结果
        String result = "";
        // 添加对象
        SpringbootSwagger springbootSwagger = new SpringbootSwagger();
        // 复值
        BeanUtils.copyProperties(springbootSwaggerRequestAddDTO,springbootSwagger);
        // 调用新增方法
        if(super.save(springbootSwagger)){
            result = "success";
        }else{
            result = "fail";
        }
        return result;
    }

    /*
     * @ClassName SpringbootSwaggerService
     * @Desc TODO   删除数据
     * @Date 2019/4/3 13:39
     * @Version 1.0
     */
    @Transactional
    public String delete(long id){
        // 返回结果
        String result = "";
        // 根据主键 id 删除
        boolean bool = super.removeById(id);
        if(bool){
            result = "success";
        }else{
            result = "fail";
        }
        return result;
    }

    /*
     * @ClassName SpringbootSwaggerService
     * @Desc TODO   更新数据
     * @Date 2019/4/3 13:40
     * @Version 1.0
     */
    @Transactional
    public String update(SpringbootSwaggerRequestDTO springbootSwaggerRequestDTO){
        // 非空判断
        if(springbootSwaggerRequestDTO.getId()==null){
            return "id is null";
        }
        if(StringUtils.isEmpty(springbootSwaggerRequestDTO.getType())
                && StringUtils.isEmpty(springbootSwaggerRequestDTO.getName())
                && StringUtils.isEmpty(springbootSwaggerRequestDTO.getDescription())){
            return "object is null";
        }
        // 返回结果
        String result = "";
        // 根据 id 更新
        SpringbootSwagger updateById = new SpringbootSwagger();
        // 复值
        BeanUtils.copyProperties(springbootSwaggerRequestDTO,updateById);
        // 调用更新方法
        boolean bool = super.updateById(updateById);
        if(bool){
            result = "success";
        }else{
            result = "fail";
        }
        return result;
    }

    /*
     * @ClassName SpringbootSwaggerService
     * @Desc TODO   分页查询测试表数据
     * @Date 2019/4/3 13:40
     * @Version 1.0
     */
    public Page<SpringbootSwaggerResponseDTO> getDataByPage(SpringbootSwaggerRequestQueryDTO springbootSwaggerRequestQueryDTO){
        // 分页条件
        Page<SpringbootSwaggerResponseDTO> page = new Page<>(springbootSwaggerRequestQueryDTO.getPageNum(),springbootSwaggerRequestQueryDTO.getPageSize());
        // 查询结果
        List<SpringbootSwaggerResponseDTO> springbootSwaggerResponseDTOS = springbootSwaggerMapper.query(springbootSwaggerRequestQueryDTO,page);
        // 封装分页结果
        page.setRecords(springbootSwaggerResponseDTOS);
        // 返回
        return page;
    }

}
