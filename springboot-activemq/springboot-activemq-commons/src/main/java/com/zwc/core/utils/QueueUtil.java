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
 * @ClassName QueueUtil
 * @Desc TODO   queue 队列模式发送消息工具类
 * @Date 2019/4/8 15:57
 * @Version 1.0
 */
public class QueueUtil {

    @Autowired
    @Qualifier("queueTemplate")
    private JmsTemplate jmsTemplate;

    /*
     * @ClassName QueueUtil
     * @Desc TODO   发送一条消息到指定的队列
     * @param  queueName 队列名称
     * @param  message 消息内容
     * @Date 2019/4/8 16:26
     * @Version 1.0
     */
    public void send(String queueName, final Serializable message) {
        jmsTemplate.send(queueName, new MessageCreator() {
            public Message createMessage(Session session) throws JMSException {
                return session.createObjectMessage(message);
            }
        });
    }

}
