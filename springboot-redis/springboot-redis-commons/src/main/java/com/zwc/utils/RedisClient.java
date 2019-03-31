package com.zwc.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * @ClassName RedisClient
 * @Desc TODO   Redis 工具类
 * @Date 2019/3/30 23:53
 * @Version 1.0
 */
@Component
public class RedisClient {

    @Autowired
    private RedisTemplate<String,Object> redisTemplate;

    /*
     * @ClassName RedisClient
     * @Desc TODO   设置缓存（没有时间限制）
     * @Date 2019/3/30 23:55
     * @Version 1.0
     */
    public void set(String key, Object value){
        redisTemplate.opsForValue().set(key, value);
    }

    /*
     * @ClassName RedisClient
     * @Desc TODO   设置缓存（有时间限制，单位为 秒）
     * @Date 2019/3/30 23:55
     * @Version 1.0
     */
    public void set(String key, Object value,long timeout){
        redisTemplate.opsForValue().set(key, value,timeout,TimeUnit.SECONDS);
    }

    /*
     * @ClassName RedisClient
     * @Desc TODO   删除缓存，并返回是否删除成功
     * @Date 2019/3/31 14:19
     * @Version 1.0
     */
    public boolean delete(String key){
        redisTemplate.delete(key);
        // 如果还存在这个 key 就证明删除失败
        if(redisTemplate.hasKey(key)){
            return false;
        // 不存在就证明删除成功
        }else{
            return true;
        }
    }

    /*
     * @ClassName RedisClient
     * @Desc TODO   取出缓存
     * @Date 2019/3/30 23:57
     * @Version 1.0
     */
    public Object get(String key){
        redisTemplate.getExpire(key);
        return redisTemplate.opsForValue().get(key);
    }

    /*
     * @ClassName RedisClient
     * @Desc TODO   获取失效时间（-2：失效 / -1：没有时间限制）
     * @Date 2019/3/31 14:18
     * @Version 1.0
     */
    public long getExpire(String key){
        // 判断是否存在
        if(redisTemplate.hasKey(key)){
            return redisTemplate.getExpire(key);
        }else{
            return Long.parseLong(-2+"");
        }
    }

}
