package com.zwc.user.mq.topic;

import com.zwc.core.constants.ActiveMQConstants;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

/*
 * @ClassName MqTopicConsumerOne
 * @Desc TODO   ActiveMQ    topic 订阅者模式 - 消费方 一号
 * @Date 2019/4/8 18:11
 * @Version 1.0
 */
@Service
public class MqTopicConsumerOne {

    /*
     * @ClassName MqTopicConsumerOne
     * @Desc TODO   接收订阅者消息
     * @Date 2019/4/8 18:12
     * @Version 1.0
     */
    @JmsListener(destination = ActiveMQConstants.TOPIC_NAME , containerFactory = "topicListenerFactory")
    public void receiveTopicMessage(String message){
        System.out.println("MqTopicConsumerOne ---> receiveTopicMessage：接收订阅者模式发送的消息，内容为：" + message);
    }

}
