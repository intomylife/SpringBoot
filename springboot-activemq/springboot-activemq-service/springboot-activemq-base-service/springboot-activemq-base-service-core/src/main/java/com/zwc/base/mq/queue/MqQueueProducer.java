package com.zwc.base.mq.queue;

import com.zwc.core.constants.ActiveMQConstants;
import com.zwc.core.utils.QueueUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName MqQueueProducerOneToOne
 * @Desc TODO   ActiveMQ    queue 列队模式 - 提供方
 * @Date 2019/4/8 15:30
 * @Version 1.0
 */
@Service
public class MqQueueProducer {

    @Autowired
    private QueueUtil queueUtil;

    /*
     * @ClassName MqQueueProducerOneToOne
     * @Desc TODO   发送列队消息
     * @Date 2019/4/8 16:29
     * @Version 1.0
     */
    public void sendQueueMessage(){
        queueUtil.send(ActiveMQConstants.QUEUE_NAME,"EN: From springboot-activemq! I'm queue. CN: springboot 整合 activemq 发送列队消息。");
    }

}
