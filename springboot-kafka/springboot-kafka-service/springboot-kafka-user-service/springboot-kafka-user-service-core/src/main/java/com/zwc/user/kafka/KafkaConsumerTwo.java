package com.zwc.user.kafka;

import com.zwc.core.constants.KafkaConstants;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

/**
 * @ClassName KafkaConsumer
 * @Desc TODO   Kafka 消费者 - 二号
 * @Date 2019/4/20 19:47
 * @Version 1.0
 */
@Service
public class KafkaConsumerTwo {

    /*
     * @ClassName KafkaConsumer
     * @Desc TODO   接收订阅者消息
     * @Date 2019/4/20 19:50
     * @Version 1.0
     */
    @KafkaListener(topics = KafkaConstants.KAFKA_TOPIC_NAME , groupId = KafkaConstants.KAFKA_GROUP_ID)
    public void receiveTopicMessage(String message){
        System.out.println("KafkaConsumerTwo ---> receiveTopicMessage：接收订阅者模式发送的消息，内容为：" + message);
    }

}
