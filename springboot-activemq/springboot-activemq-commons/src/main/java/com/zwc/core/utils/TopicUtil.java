package com.zwc.core.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import java.io.Serializable;

/**
 * @ClassName TopicUtil
 * @Desc TODO   topic 订阅模式发送消息工具类
 * @Date 2019/4/8 17:03
 * @Version 1.0
 */
public class TopicUtil {

    @Autowired
    @Qualifier("topicTemplate")
    private JmsTemplate jmsTemplate;

    /*
     * @ClassName QueueUtil
     * @Desc TODO   发送一条消息到指定的订阅者
     * @param  queueName 队列名称
     * @param  message 消息内容
     * @Date 2019/4/8 16:36
     * @Version 1.0
     */
    public void send(String topicName, final Serializable message) {
        jmsTemplate.send(topicName, new MessageCreator() {
            public Message createMessage(Session session) throws JMSException {
                return session.createObjectMessage(message);
            }
        });
    }

}
