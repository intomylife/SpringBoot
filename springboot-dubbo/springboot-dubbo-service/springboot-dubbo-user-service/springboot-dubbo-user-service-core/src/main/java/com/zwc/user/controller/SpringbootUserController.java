package com.zwc.user.controller;

import com.zwc.base.dto.response.SpringbootBaseResponseDTO;
import com.zwc.user.dto.response.SpringbootUserResponseDTO;
import com.zwc.user.service.SpringbootUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @ClassName SpringbootUserController
 * @Desc TODO   用户表 前端控制器
 * @Date 2019/4/6 15:22
 * @Version 1.0
 */
@RestController
@RequestMapping("user")
public class SpringbootUserController {

    @Autowired
    private SpringbootUserService springbootUserService;

    /*
     * @ClassName SpringbootUserController
     * @Desc TODO   获取全部用户
     * @Date 2019/4/6 15:24
     * @Version 1.0
     */
    @RequestMapping("/getAllUser")
    @ResponseBody
    public List<SpringbootUserResponseDTO> getAllUser(){
        return springbootUserService.getAllUser();
    }

    /*
     * @ClassName SpringbootUserController
     * @Desc TODO   获取全部地区（调用 base - service 接口）
     * @Date 2019/4/6 15:37
     * @Version 1.0
     */
    @RequestMapping("/getAllBaseInUser")
    @ResponseBody
    public List<SpringbootBaseResponseDTO> getAllBase(){
        return springbootUserService.getAllBase();
    }

    /*
     * @ClassName SpringbootUserController
     * @Desc TODO   获取全部用户详情信息
     * @Date 2019/4/6 23:18
     * @Version 1.0
     */
    @RequestMapping("/getDetailInfo")
    @ResponseBody
    public List<Map<String,Object>> getDetailInfo(){
        return springbootUserService.getDetailInfo();
    }

}
