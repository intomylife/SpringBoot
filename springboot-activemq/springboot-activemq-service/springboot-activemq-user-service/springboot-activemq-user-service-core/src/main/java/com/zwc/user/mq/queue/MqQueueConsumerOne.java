package com.zwc.user.mq.queue;

import com.zwc.core.constants.ActiveMQConstants;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

import javax.jms.Queue;

/**
 * @ClassName MqQueueConsumerOne
 * @Desc TODO   ActiveMQ    queue 队列模式 - 消费方 一号
 * @Date 2019/4/8 17:44
 * @Version 1.0
 */
@Service
public class MqQueueConsumerOne {

    /*
     * @ClassName MqQueueConsumerOne
     * @Desc TODO   接收队列消息
     * @Date 2019/4/8 17:48
     * @Version 1.0
     */
    @JmsListener(destination = ActiveMQConstants.QUEUE_NAME , containerFactory = "queueListenerFactory")
    public void receiveQueueMessage(String message){
        System.out.println("MqQueueConsumerOne ---> receiveQueueMessage：接收队列模式发送的消息，内容为：" + message);
    }

}
