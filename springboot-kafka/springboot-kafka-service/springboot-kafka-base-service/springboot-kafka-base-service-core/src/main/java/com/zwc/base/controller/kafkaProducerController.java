package com.zwc.base.controller;

import com.zwc.base.kafka.KafkaProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName kafkaProducerController
 * @Desc TODO   发送订阅者消息 - 前端控制器
 * @Date 2019/4/20 20:02
 * @Version 1.0
 */
@RestController
@RequestMapping("kafka")
public class kafkaProducerController {

    @Autowired
    private KafkaProducer kafkaProducer;

    /*
     * @ClassName kafkaProducerController
     * @Desc TODO   发送订阅者消息
     * @Date 2019/4/20 20:05
     * @Version 1.0
     */
    @RequestMapping("/send")
    @ResponseBody
    public String sendMqTopicProducer(){
        try {
            kafkaProducer.sendTopicMessage();
            return "success";
        } catch (Exception e) {
            e.printStackTrace();
            return "fial";
        }
    }

}
