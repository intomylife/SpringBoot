package com.zwc.base.kafka;

import com.zwc.core.constants.KafkaConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

/**
 * @ClassName kafkaProducer
 * @Desc TODO   Kafka 提供者
 * @Date 2019/4/20 19:41
 * @Version 1.0
 */
@Service
public class KafkaProducer {

    @Autowired
    private KafkaTemplate kafkaTemplate;

    /*
     * @ClassName kafkaProducer
     * @Desc TODO   发送订阅者消息
     * @Date 2019/4/20 19:46
     * @Version 1.0
     */
    public void sendTopicMessage(){
        kafkaTemplate.send(KafkaConstants.KAFKA_TOPIC_NAME,"EN: From springboot-kafka! I'm topic. CN: springboot 整合 kafka 发送订阅者消息。");
    }

}
