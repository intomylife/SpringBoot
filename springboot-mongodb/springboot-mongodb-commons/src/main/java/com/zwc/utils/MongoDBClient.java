package com.zwc.utils;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.result.DeleteResult;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;

/**
 * @ClassName MongoDBClient
 * @Desc TODO   MongoDB 工具类
 * @Date 2019/4/1 9:43
 * @Version 1.0
 */
@Component
public class MongoDBClient {

    @Autowired
    private MongoTemplate mongoTemplate;

    /*
     * @ClassName MongoDBClient
     * @Desc TODO   创建集合，并返回是否创建成功  -2：已存在 / -1：创建失败 / 1：创建成功
     * @Date 2019/4/1 10:59
     * @Version 1.0
     */
    public Integer createCollection(String collectionName){
        // 先判断集合是否存在
        if(mongoTemplate.collectionExists(collectionName)){
            return -2;
        }else{
            // 创建一个集合
            mongoTemplate.createCollection(collectionName);
            // 判断集合是否存在
            if(mongoTemplate.collectionExists(collectionName)){
                return 1;
            }else{
                return -1;
            }
        }
    }

    /*
     * @ClassName MongoDBClient
     * @Desc TODO   在指定集合中添加数据
     * @Date 2019/4/1 11:12
     * @Version 1.0
     */
    public void add(Collection<?> batchToSave , String collectionName){
        mongoTemplate.insert(batchToSave,collectionName);
    }

    /*
     * @ClassName MongoDBClient
     * @Desc TODO   根据条件和指定集合删除数据
     * @Date 2019/4/1 14:20
     * @Version 1.0
     */
    public void delete(Query query , Object obj , String collectionName){
        mongoTemplate.remove(query, obj.getClass(), collectionName);
    }

    /*
     * @ClassName MongoDBClient
     * @Desc TODO   根据条件更新数据
     * @Date 2019/4/1 14:30
     * @Version 1.0
     */
    public void update(Query query , Update update , Object obj , String collectionName){
        mongoTemplate.updateMulti(query , update , obj.getClass() , collectionName);
    }

    /*
     * @ClassName MongoDBClient
     * @Desc TODO   获取指定集合下的全部数据
     * @Date 2019/4/1 11:18
     * @Version 1.0
     */
    public List<?> getAllByCollectionName(Object obj , String collectionName){
        return mongoTemplate.findAll(obj.getClass(),collectionName);
    }

    /*
     * @ClassName MongoDBClient
     * @Desc TODO   根据条件和集合名称查询数据
     * @Date 2019/4/1 11:31
     * @Version 1.0
     */
    public List<?> getByConditionAndCollectionName(Query query , Object obj , String collectionName){
        return mongoTemplate.find(query, obj.getClass() , collectionName);
    }

}
