package com.zwc.base.mq.topic;

import com.zwc.core.constants.ActiveMQConstants;
import com.zwc.core.utils.TopicUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/*
 * @ClassName MqTopicProducer
 * @Desc TODO   ActiveMQ    topic 订阅者模式 - 提供方
 * @Date 2019/4/8 18:09
 * @Version 1.0
 */
@Service
public class MqTopicProducer {

    @Autowired
    private TopicUtil topicUtil;

    /*
     * @ClassName MqTopicProducer
     * @Desc TODO   发送订阅者消息
     * @Date 2019/4/8 18:09
     * @Version 1.0
     */
    public void sendTopicMessage(){
        topicUtil.send(ActiveMQConstants.TOPIC_NAME,"EN: From springboot-activemq! I'm topic. CN: springboot 整合 activemq 发送订阅者消息。");
    }

}
