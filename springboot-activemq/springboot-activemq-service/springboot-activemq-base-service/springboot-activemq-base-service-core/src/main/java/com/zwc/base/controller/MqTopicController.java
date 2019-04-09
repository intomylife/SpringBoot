package com.zwc.base.controller;

import com.zwc.base.mq.topic.MqTopicProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/*
 * @ClassName MqTopicController
 * @Desc TODO   发送订阅者消息 - 前端控制器
 * @Date 2019/4/8 18:16
 * @Version 1.0
 */
@RestController
@RequestMapping("topic")
public class MqTopicController {

    @Autowired
    private MqTopicProducer mqTopicProducer;

    /*
     * @ClassName MqTopicController
     * @Desc TODO   发送订阅者消息
     * @Date 2019/4/8 18:17
     * @Version 1.0
     */
    @RequestMapping("/send")
    @ResponseBody
    public String sendMqTopicProducer(){
        try {
            mqTopicProducer.sendTopicMessage();
            return "success";
        } catch (Exception e) {
            e.printStackTrace();
            return "fial";
        }
    }

}
