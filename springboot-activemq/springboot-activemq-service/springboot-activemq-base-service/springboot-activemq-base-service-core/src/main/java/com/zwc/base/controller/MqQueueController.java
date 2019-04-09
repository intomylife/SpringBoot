package com.zwc.base.controller;

import com.zwc.base.mq.queue.MqQueueProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName MqQueueController
 * @Desc TODO   发送列队消息 - 前端控制器
 * @Date 2019/4/8 17:30
 * @Version 1.0
 */
@RestController
@RequestMapping("queue")
public class MqQueueController {

    @Autowired
    private MqQueueProducer mqQueueProducer;

    /*
     * @ClassName MqQueueController
     * @Desc TODO   发送列队消息
     * @Date 2019/4/8 17:32
     * @Version 1.0
     */
    @RequestMapping("/send")
    @ResponseBody
    public String sendMqQueueProducer(){
        try {
            mqQueueProducer.sendQueueMessage();
            return "success";
        } catch (Exception e) {
            e.printStackTrace();
            return "fial";
        }
    }

}
