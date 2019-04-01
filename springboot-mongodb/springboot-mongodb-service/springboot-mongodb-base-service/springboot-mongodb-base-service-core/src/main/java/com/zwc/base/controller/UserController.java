package com.zwc.base.controller;

import com.zwc.base.domain.UserMongoDBModel;
import com.zwc.base.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @ClassName UserController
 * @Desc TODO   springboot整合mongodb 前端控制器
 * @Date 2019/4/1 11:50
 * @Version 1.0
 */
@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    /*
     * @ClassName UserController
     * @Desc TODO   创建集合
     * @Date 2019/4/1 11:52
     * @Version 1.0
     */
    @RequestMapping("/createCollection")
    @ResponseBody
    public String createCollection(){
        return userService.createCollection();
    }

    /*
     * @ClassName UserController
     * @Desc TODO   新增
     * @Date 2019/4/1 13:51
     * @Version 1.0
     */
    @RequestMapping("/add")
    @ResponseBody
    public String add(){
        return userService.add();
    }

    /*
     * @ClassName UserController
     * @Desc TODO   删除
     * @Date 2019/4/1 14:27
     * @Version 1.0
     */
    @RequestMapping("/delete")
    @ResponseBody
    public String delete(){
        return userService.delete();
    }

    /*
     * @ClassName UserController
     * @Desc TODO   更新
     * @Date 2019/4/1 14:41
     * @Version 1.0
     */
    @RequestMapping("/update")
    @ResponseBody
    public String update(){
        return userService.update();
    }

    /*
     * @ClassName UserController
     * @Desc TODO   查询全部
     * @Date 2019/4/1 13:56
     * @Version 1.0
     */
    @RequestMapping("/getAll")
    @ResponseBody
    public List<UserMongoDBModel> getAllByCollectionName(){
        return userService.getAllByCollectionName();
    }

    /*
     * @ClassName UserController
     * @Desc TODO   根据条件查询
     * @Date 2019/4/1 14:11
     * @Version 1.0
     */
    @RequestMapping("/get")
    @ResponseBody
    public List<UserMongoDBModel> getByConditionAndCollectionName(){
        return userService.getByConditionAndCollectionName();
    }
}
