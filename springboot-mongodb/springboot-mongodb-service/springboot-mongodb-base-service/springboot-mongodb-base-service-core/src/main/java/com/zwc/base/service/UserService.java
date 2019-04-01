package com.zwc.base.service;

import com.alibaba.fastjson.JSON;
import com.zwc.base.constant.BaseServiceConstant;
import com.zwc.base.domain.UserMongoDBModel;
import com.zwc.utils.MongoDBClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @ClassName UserService
 * @Desc TODO   springboot整合mongodb 实现服务类
 * @Date 2019/4/1 11:44
 * @Version 1.0
 */
@Service
public class UserService {

    @Autowired
    private MongoDBClient mongoDBClient;

    /*
     * @ClassName UserService
     * @Desc TODO   创建集合
     * @Date 2019/4/1 11:47
     * @Version 1.0
     */
    public String createCollection(){
        // 调用创建方法
        Integer result = mongoDBClient.createCollection(BaseServiceConstant.MONGODB_COLLECTION_NAME);
        // 创建成功
        if(result > 0){
            return "创建：" + BaseServiceConstant.MONGODB_COLLECTION_NAME + " 集合成功！";
        // 已存在
        }else if(result == -2){
            return BaseServiceConstant.MONGODB_COLLECTION_NAME + " 集合已存在！";
        // 创建失败
        }else{
            return "创建：" + BaseServiceConstant.MONGODB_COLLECTION_NAME + " 集合失败！";
        }
    }

    /*
     * @ClassName UserService
     * @Desc TODO   在指定集合中添加数据
     * @Date 2019/4/1 13:38
     * @Version 1.0
     */
    public String add(){
        try {
            // 封装两个用户对象
            Collection<UserMongoDBModel> batchToSave = new ArrayList<>();
            UserMongoDBModel uOne = new UserMongoDBModel();
            uOne.setName("zwc");
            uOne.setAge(3);
            batchToSave.add(uOne);
            UserMongoDBModel uTwo = new UserMongoDBModel();
            uTwo.setName("cdy");
            uTwo.setAge(2);
            batchToSave.add(uTwo);
            // 调用添加方法
            mongoDBClient.add(batchToSave,BaseServiceConstant.MONGODB_COLLECTION_NAME);
            return "success";
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
    }

    /*
     * @ClassName UserService
     * @Desc TODO   根据条件和指定集合删除数据
     * @Date 2019/4/1 14:23
     * @Version 1.0
     */
    public String delete (){
        // 封装查询条件
        Query query = new Query();
        // 添加条件 age 为 3 的小朋友
        // 注：MongoDB 对于数据类型很敏感，如 age 字段存入时类型为 int，却在设置条件是写为 is("3")，这种条件是无效的
        query.addCriteria(new Criteria().and("age").is(3));
        // 调用删除方法
        mongoDBClient.delete(query,new UserMongoDBModel(),BaseServiceConstant.MONGODB_COLLECTION_NAME);
        // 调用查询方法
        List<UserMongoDBModel> result = (List<UserMongoDBModel>) mongoDBClient.getByConditionAndCollectionName(query, new UserMongoDBModel(), BaseServiceConstant.MONGODB_COLLECTION_NAME);
        // 是否还存在已删除的数据
        if(result.size()>0){
            return "fail";
        }else{
            return "success";
        }
    }

    /*
     * @ClassName UserService
     * @Desc TODO   根据条件更新数据
     * @Date 2019/4/1 14:40
     * @Version 1.0
     */
    public String update (){
        // 封装查询条件
        Query query = new Query();
        // 添加条件 age 为 2 的小朋友
        // 注：MongoDB 对于数据类型很敏感，如 age 字段存入时类型为 int，却在设置条件是写为 is("2")，这种条件是无效的
        query.addCriteria(new Criteria().and("age").is(2));
        // 封装修改列
        Update update = new Update();
        // 添加列值
        update.set("name","cdyyyy");
        // 调用查询方法（更新前）
        List<UserMongoDBModel> before = (List<UserMongoDBModel>) mongoDBClient.getByConditionAndCollectionName(query, new UserMongoDBModel(), BaseServiceConstant.MONGODB_COLLECTION_NAME);
        // 调用更新方法
        mongoDBClient.update(query , update , new UserMongoDBModel() , BaseServiceConstant.MONGODB_COLLECTION_NAME);
        // 调用查询方法（更新后）
        List<UserMongoDBModel> after = (List<UserMongoDBModel>) mongoDBClient.getByConditionAndCollectionName(query, new UserMongoDBModel(), BaseServiceConstant.MONGODB_COLLECTION_NAME);
        return "更新前：" + JSON.toJSONString(before) + "   |   " + "更新后：" + JSON.toJSONString(after);
    }

    /*
     * @ClassName UserService
     * @Desc TODO   根据集合名称获取全部数据
     * @Date 2019/4/1 13:55
     * @Version 1.0
     */
    public List<UserMongoDBModel> getAllByCollectionName(){
        // 调用查询方法
        return (List<UserMongoDBModel>)mongoDBClient.getAllByCollectionName(new UserMongoDBModel(),BaseServiceConstant.MONGODB_COLLECTION_NAME);
    }

    /*
     * @ClassName UserService
     * @Desc TODO   根据条件和集合名称查询数据
     * @Date 2019/4/1 14:07
     * @Version 1.0
     */
    public List<UserMongoDBModel> getByConditionAndCollectionName(){
        // 封装查询条件
        Query query = new Query();
        // 添加条件 age 为 2 的小朋友
        // 注：MongoDB 对于数据类型很敏感，如 age 字段存入时类型为 int，却在设置条件是写为 is("2")，这样是查询不到结果的
        query.addCriteria(new Criteria().and("age").is(2));
        // 调用查询方法
        return (List<UserMongoDBModel>)mongoDBClient.getByConditionAndCollectionName(query, new UserMongoDBModel(), BaseServiceConstant.MONGODB_COLLECTION_NAME);
    }

}
