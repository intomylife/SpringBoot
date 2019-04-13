package com.zwc.base.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zwc.base.dto.request.SpringbootSwaggerRequestAddDTO;
import com.zwc.base.dto.request.SpringbootSwaggerRequestDTO;
import com.zwc.base.dto.request.SpringbootSwaggerRequestQueryDTO;
import com.zwc.base.dto.response.SpringbootSwaggerResponseDTO;
import com.zwc.base.service.SpringbootSwaggerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

/**
 * @ClassName SpringbootSwaggerController
 * @Desc TODO   springboot 整合 swagger 测试表 前端控制器
 * @Date 2019/4/3 13:48
 * @Version 1.0
 */
@RestController
@RequestMapping(value = "swagger") //  , produces = MediaType.APPLICATION_JSON_VALUE
@Api(value = "springboot 整合 swagger 测试表 前端控制器" , description = "springboot 整合 swagger 测试表 api")
// 此注解用在类上整个类都不会出现在 swagger 里；用在此类方法上，此类该方法不会出现在 swagger 里，其他方法依旧会出现在 swagger 里
// @ApiIgnore
public class SpringbootSwaggerController {

    @Autowired
    private SpringbootSwaggerService springbootSwaggerService;

    /*
     * @ClassName SpringbootSwaggerController
     * @Desc TODO   新增信息
     * @Date 2019/4/3 14:38
     * @Version 1.0
     */
    @RequestMapping(value = "/add" , method = RequestMethod.POST)
    @ApiOperation(value = "新增信息")
    public String add(SpringbootSwaggerRequestAddDTO springbootSwaggerRequestAddDTO){
        return springbootSwaggerService.add(springbootSwaggerRequestAddDTO);
    }

    /*
     * @ClassName SpringbootSwaggerController
     * @Desc TODO   根据 id 删除信息 ， 使用 @ApiParam 注解添加字段的描述，参数是否必填以 @ApiParam 注解中的 required 值为准
     * @Date 2019/4/3 14:56
     * @Version 1.0
     */
    @RequestMapping(value = "/delete/{id}" , method = RequestMethod.GET)
    @ApiOperation(value = "根据 id 删除信息")
    public String delete(@ApiParam(value = "主键 id" , required = true) @PathVariable(value = "id" , required = true) long id){
        return springbootSwaggerService.delete(id);
    }

    /*
     * @ClassName SpringbootSwaggerController
     * @Desc TODO   更新信息
     * @Date 2019/4/3 15:03
     * @Version 1.0
     */
    @RequestMapping(value = "/update" , method = RequestMethod.POST)
    @ApiOperation(value = "更新信息")
    public String update(SpringbootSwaggerRequestDTO springbootSwaggerRequestDTO){
        return springbootSwaggerService.update(springbootSwaggerRequestDTO);
    }

    /*
     * @ClassName SpringbootSwaggerController
     * @Desc TODO   分页查询信息
     * @Date 2019/4/3 14:02
     * @Version 1.0
     */
    @RequestMapping(value = "/pageUser" , method = RequestMethod.POST)
    @ApiOperation(value = "分页查询信息")
    public Page<SpringbootSwaggerResponseDTO> pageUser(SpringbootSwaggerRequestQueryDTO springbootSwaggerRequestQueryDTO){
        return springbootSwaggerService.getDataByPage(springbootSwaggerRequestQueryDTO);
    }

}
