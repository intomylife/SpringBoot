package com.zwc.base.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zwc.base.dto.request.SpringbootMybatisPlusRequestQueryDTO;
import com.zwc.base.dto.response.SpringbootMybatisPlusResponseDTO;
import com.zwc.base.service.SpringbootMybatisPlusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName SpringbootMybatisPlusController
 * @Desc TODO   springboot整合mybatis-plus测试表 前端控制器
 * @Date 2019/3/26 18:14
 * @Version 1.0
 */
@RestController
@RequestMapping("smpc")
public class SpringbootMybatisPlusController {

    @Autowired
    private SpringbootMybatisPlusService springbootMybatisPlusService;

    /*
     * @ClassName SpringbootMybatisPlusController
     * @Desc TODO   新增数据
     * @Date 2019/3/27 11:40
     * @Version 1.0
     */
    @RequestMapping("/add")
    @ResponseBody
    public String add(){
        return springbootMybatisPlusService.add();
    }

    /*
     * @ClassName SpringbootMybatisPlusController
     * @Desc TODO   删除数据
     * @Date 2019/3/27 13:15
     * @Version 1.0
     */
    @RequestMapping("/delete")
    @ResponseBody
    public String delete(){
        return springbootMybatisPlusService.delete();
    }

    /*
     * @ClassName SpringbootMybatisPlusController
     * @Desc TODO   更新数据
     * @Date 2019/3/27 13:46
     * @Version 1.0
     */
    @RequestMapping("/update")
    @ResponseBody
    public String update(){
        return springbootMybatisPlusService.update();
    }

    /*
     * @ClassName SpringbootMybatisPlusController
     * @Desc TODO   分页查询测试表数据
     * @Date 2019/3/26 18:10
     * @Version 1.0
     */
    @RequestMapping("/query")
    @ResponseBody
    public Page<SpringbootMybatisPlusResponseDTO> query(@RequestParam(value = "springbootMybatisPlusRequestQueryDTO",required = false) SpringbootMybatisPlusRequestQueryDTO springbootMybatisPlusRequestQueryDTO){
        return springbootMybatisPlusService.getDataByPage(springbootMybatisPlusRequestQueryDTO);
    }
}
