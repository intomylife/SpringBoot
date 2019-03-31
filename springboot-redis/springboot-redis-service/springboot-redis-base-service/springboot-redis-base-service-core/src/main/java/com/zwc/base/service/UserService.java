package com.zwc.base.service;

import com.alibaba.fastjson.JSON;
import com.zwc.base.constant.BaseServiceConstant;
import com.zwc.base.domain.UserRedisModel;
import com.zwc.utils.RedisClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName UserService
 * @Desc TODO   springboot整合redis 实现服务类
 * @Date 2019/3/31 14:06
 * @Version 1.0
 */
@Service
public class UserService {

    @Autowired
    private RedisClient redisClient;

    /*
     * @ClassName UserService
     * @Desc TODO   设置用户信息
     * @Date 2019/3/31 14:15
     * @Version 1.0
     */
    public String setUserToRedis(){
        // 封装两个用户对象
        List<UserRedisModel> userRedisModels = new ArrayList<>();
        UserRedisModel uOne = new UserRedisModel();
        uOne.setName("zwc");
        uOne.setAge(3);
        userRedisModels.add(uOne);
        UserRedisModel uTwo = new UserRedisModel();
        uTwo.setName("cdy");
        uTwo.setAge(2);
        userRedisModels.add(uTwo);
        redisClient.set(BaseServiceConstant.USER_REDIS_KEY,userRedisModels);
        return JSON.toJSONString(redisClient.get(BaseServiceConstant.USER_REDIS_KEY));
    }

    /*
     * @ClassName UserService
     * @Desc TODO   设置用户信息和失效时间
     * @Date 2019/3/31 14:15
     * @Version 1.0
     */
    public String setUserAndExpireToRedis(){
        // 封装两个用户对象
        List<UserRedisModel> userRedisModels = new ArrayList<>();
        UserRedisModel uOne = new UserRedisModel();
        uOne.setName("zwc");
        uOne.setAge(6);
        userRedisModels.add(uOne);
        UserRedisModel uTwo = new UserRedisModel();
        uTwo.setName("cdy");
        uTwo.setAge(9);
        userRedisModels.add(uTwo);
        redisClient.set(BaseServiceConstant.USER_REDIS_KEY,userRedisModels,666);
        return JSON.toJSONString(redisClient.get(BaseServiceConstant.USER_REDIS_KEY));
    }

    /*
     * @ClassName UserService
     * @Desc TODO   删除用户信息
     * @Date 2019/3/31 14:26
     * @Version 1.0
     */
    public String delete(){
        if(redisClient.delete(BaseServiceConstant.USER_REDIS_KEY)){
            return "删除成功";
        }else{
            return "删除失败";
        }
    }

    /*
     * @ClassName UserService
     * @Desc TODO   获取用户信息
     * @Date 2019/3/31 14:14
     * @Version 1.0
     */
    public String getUserFromRedis(){
        return JSON.toJSONString(redisClient.get((BaseServiceConstant.USER_REDIS_KEY)));
    }

    /*
     * @ClassName UserService
     * @Desc TODO   获取失效时间
     * @Date 2019/3/31 14:27
     * @Version 1.0
     */
    public String getExpire(){
        return "还有：" + redisClient.getExpire(BaseServiceConstant.USER_REDIS_KEY) + " 秒失效！";
    }

}
