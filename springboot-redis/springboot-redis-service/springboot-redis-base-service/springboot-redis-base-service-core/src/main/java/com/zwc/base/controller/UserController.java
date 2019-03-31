package com.zwc.base.controller;

import com.zwc.base.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName UserController
 * @Desc TODO   springboot整合redis 前端控制器
 * @Date 2019/3/31 14:04
 * @Version 1.0
 */
@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    /*
     * @ClassName UserController
     * @Desc TODO   设置用户信息
     * @Date 2019/3/31 14:31
     * @Version 1.0
     */
    @RequestMapping("/addUser")
    @ResponseBody
    public String setUserToRedis(){
        return userService.setUserToRedis();
    }

    /*
     * @ClassName UserController
     * @Desc TODO   设置用户信息和失效时间
     * @Date 2019/3/31 14:32
     * @Version 1.0
     */
    @RequestMapping("/addUserAndExpire")
    @ResponseBody
    public String setUserAndExpireToRedis(){
        return userService.setUserAndExpireToRedis();
    }

    /*
     * @ClassName UserController
     * @Desc TODO   删除用户信息
     * @Date 2019/3/31 14:32
     * @Version 1.0
     */
    @RequestMapping("/deleteUser")
    @ResponseBody
    public String delete(){
        return userService.delete();
    }

    /*
     * @ClassName UserController
     * @Desc TODO   获取用户信息
     * @Date 2019/3/31 14:33
     * @Version 1.0
     */
    @RequestMapping("/getUser")
    @ResponseBody
    public String getUserFromRedis(){
        return userService.getUserFromRedis();
    }

    /*
     * @ClassName UserController
     * @Desc TODO   获取失效时间
     * @Date 2019/3/31 14:33
     * @Version 1.0
     */
    @RequestMapping("/getExpire")
    @ResponseBody
    public String getExpire(){
        return userService.getExpire();
    }

}
