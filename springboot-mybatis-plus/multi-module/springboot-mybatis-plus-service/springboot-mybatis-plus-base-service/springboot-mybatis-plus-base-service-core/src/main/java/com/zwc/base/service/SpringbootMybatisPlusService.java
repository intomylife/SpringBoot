package com.zwc.base.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zwc.base.domain.SpringbootMybatisPlus;
import com.zwc.base.dto.request.SpringbootMybatisPlusRequestQueryDTO;
import com.zwc.base.dto.response.SpringbootMybatisPlusResponseDTO;
import com.zwc.base.mapper.SpringbootMybatisPlusMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName SpringbootMybatisPlusService
 * @Desc TODO   springboot整合mybatis-plus测试表 实现服务类
 * @Date 2019/3/26 18:00
 * @Version 1.0
 */
@Service
public class SpringbootMybatisPlusService extends ServiceImpl<SpringbootMybatisPlusMapper,SpringbootMybatisPlus> {


    @Resource
    private SpringbootMybatisPlusMapper springbootMybatisPlusMapper;

    /*
     * @ClassName SpringbootMybatisPlusService
     * @Desc TODO   新增数据
     * @Date 2019/3/27 11:31
     * @Version 1.0
     */
    public String add(){
        // 返回结果
        String result = "";
        // 新增对象
        SpringbootMybatisPlus springbootMybatisPlus = new SpringbootMybatisPlus();
        // 设置属性
        springbootMybatisPlus.setType("1");
        springbootMybatisPlus.setName("洗衣机");
        springbootMybatisPlus.setDescription("用来洗衣服");
        if(super.save(springbootMybatisPlus)){
            result = "success";
        }else{
            result = "fail";
        }
        return result;
    }

    /*
     * @ClassName SpringbootMybatisPlusService
     * @Desc TODO   删除数据
     * @Date 2019/3/27 13:08
     * @Version 1.0
     */
    @Transactional
    public String delete(){
        // 返回结果
        String result = "";
        // 根据主键 id 删除
        boolean bool = super.removeById(Long.parseLong("1"));
        // 根据条件删除
        bool = super.remove(new QueryWrapper<SpringbootMybatisPlus>().eq(SpringbootMybatisPlus.NAME,"电热壶"));
        if(bool){
            result = "success";
        }else{
            result = "fail";
        }
        return result;
    }

    /*
     * @ClassName SpringbootMybatisPlusService
     * @Desc TODO   更新数据
     * @Date 2019/3/27 13:08
     * @Version 1.0
     */
    @Transactional
    public String update(){
        // 返回结果
        String result = "";
        // 根据 id 更新
        SpringbootMybatisPlus updateById = new SpringbootMybatisPlus();
        updateById.setId(Long.parseLong("3"));
        updateById.setName("制冷");
        boolean bool = super.updateById(updateById);

        // 根据条件更新
        // 修改列
        SpringbootMybatisPlus updateColumn = new SpringbootMybatisPlus();
        updateColumn.setDescription("我爱搅拌鸡蛋");
        // 条件列
        QueryWrapper<SpringbootMybatisPlus> updateCondition = new QueryWrapper<>();
        updateCondition.eq("name","打蛋器");
        bool = super.update(updateColumn,updateCondition);

        if(bool){
            result = "success";
        }else{
            result = "fail";
        }
        return result;
    }

    /*
     * @ClassName SpringbootMybatisPlusService
     * @Desc TODO   分页查询测试表数据
     * @Date 2019/3/26 18:04
     * @Version 1.0
     */
    public Page<SpringbootMybatisPlusResponseDTO> getDataByPage(SpringbootMybatisPlusRequestQueryDTO springbootMybatisPlusRequestQueryDTO){
        // 如果没有传入分页信息
        if(springbootMybatisPlusRequestQueryDTO == null){
            // 默认查询前三条
            springbootMybatisPlusRequestQueryDTO = new SpringbootMybatisPlusRequestQueryDTO();
            springbootMybatisPlusRequestQueryDTO.setPageNum(1);
            springbootMybatisPlusRequestQueryDTO.setPageSize(3);
            // 添加条件
            springbootMybatisPlusRequestQueryDTO.setType("2");
        }
        // 分页条件
        Page<SpringbootMybatisPlusResponseDTO> page = new Page<>(springbootMybatisPlusRequestQueryDTO.getPageNum(),springbootMybatisPlusRequestQueryDTO.getPageSize());
        // 查询结果
        List<SpringbootMybatisPlusResponseDTO> springbootMybatisPlusResponseDTOS = springbootMybatisPlusMapper.query(springbootMybatisPlusRequestQueryDTO,page);
        // 封装分页结果
        page.setRecords(springbootMybatisPlusResponseDTOS);
        // 返回
        return page;
    }
}
