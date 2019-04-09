package com.zwc.core.config;

import com.zwc.core.utils.QueueUtil;
import com.zwc.core.utils.TopicUtil;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.jms.DefaultJmsListenerContainerFactoryConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.connection.CachingConnectionFactory;
import org.springframework.jms.core.JmsTemplate;

import javax.jms.ConnectionFactory;

/**
 * @ClassName ActiveMQConfig
 * @Desc TODO   ActiveMQ 配置
 * @Date 2019/4/8 16:05
 * @Version 1.0
 */
@Configuration
@ConditionalOnClass(ActiveMQConnectionFactory.class)
@PropertySource("classpath:system.properties")
public class ActiveMQConfig {

    // ActiveMQ 用户名
    @Value("${activemq.user}")
    private String mqUser;

    // ActiveMQ 密码
    @Value("${activemq.password}")
    private String mqPassword;

    // ActiveMQ 连接主机
    @Value("${activemq.broker-url}")
    private String mqBrokerUrl;

    // 是否信任所有包
    @Value("${activemq.packages.trust-all}")
    private boolean mqPackagesTA;

    /*
     * @ClassName ActiveMQConfig
     * @Desc TODO   ActiveMQ 连接配置
     * @Date 2019/4/8 16:48
     * @Version 1.0
     */
    @Bean
    public CachingConnectionFactory cachingConnectionFactory() {
        // 连接工厂
        CachingConnectionFactory connectionFactory = new CachingConnectionFactory();
        ActiveMQConnectionFactory mqConnectionFactory = new ActiveMQConnectionFactory();
        // 连接主机
        mqConnectionFactory.setBrokerURL(mqBrokerUrl);
        // 用户名
        mqConnectionFactory.setUserName(mqUser);
        // 密码
        mqConnectionFactory.setPassword(mqPassword);
        // 是否信任所有包
        mqConnectionFactory.setTrustAllPackages(mqPackagesTA);
        // 设置连接工厂配置信息
        connectionFactory.setTargetConnectionFactory(mqConnectionFactory);
        // 返回连接工厂
        return connectionFactory;
    }

    /*
     *  有两种消息类型：queue-队列 / topic-订阅
     *  使用 pub-sub-domain 属性控制消息类型
     *  true：topic消息，false：Queue消息
     */

    /*
     * @ClassName ActiveMQConfig
     * @Desc TODO   在读取队列消息时需要配置此 bean（ PubSubDomain 默认为就是 false，可以不用配置）
     * @Date 2019/4/9 11:01
     * @Version 1.0
     */
    @Bean("queueListenerFactory")
    public DefaultJmsListenerContainerFactory queueListenerFactory(ConnectionFactory connectionFactory,
                                                                   DefaultJmsListenerContainerFactoryConfigurer configurer) {
        DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
        configurer.configure(factory, connectionFactory);
        factory.setPubSubDomain(false);
        return factory;
    }

    /*
     * @ClassName ActiveMQConfig
     * @Desc TODO   队列模式，设置 pub-sub-domain 为 false
     * @Date 2019/4/8 16:51
     * @Version 1.0
     */
    @Bean
    public JmsTemplate queueTemplate(CachingConnectionFactory cachingConnectionFactory){
        JmsTemplate jmsTemplate = new JmsTemplate(cachingConnectionFactory);
//        jmsTemplate.setReceiveTimeout();
        jmsTemplate.setPubSubDomain(false);
        return jmsTemplate;
    }

    /*
     * @ClassName ActiveMQConfig
     * @Desc TODO   在读取订阅者消息时需要配置此 bean
     * @Date 2019/4/9 11:01
     * @Version 1.0
     */
    @Bean("topicListenerFactory")
    public DefaultJmsListenerContainerFactory topicListenerFactory(ConnectionFactory connectionFactory,
                                                                   DefaultJmsListenerContainerFactoryConfigurer configurer) {
        DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
        configurer.configure(factory, connectionFactory);
        factory.setPubSubDomain(true);
        return factory;
    }

    /*
     * @ClassName ActiveMQConfig
     * @Desc TODO   订阅模式，设置 pub-sub-domain 为 true
     * @Date 2019/4/8 16:59
     * @Version 1.0
     */
    @Bean
    public JmsTemplate topicTemplate(CachingConnectionFactory connectionFactory){
        JmsTemplate jmsTemplate = new JmsTemplate(connectionFactory);
//        jmsTemplate.setReceiveTimeout();
        jmsTemplate.setPubSubDomain(true);
        return jmsTemplate;
    }

    /*
     * @ClassName ActiveMQConfig
     * @Desc TODO   把 queue 队列模式发送消息工具类注入到 spring 中
     * @Date 2019/4/8 17:05
     * @Version 1.0
     */
    @Bean
    @ConditionalOnBean(value = JmsTemplate.class, name = "queueTemplate")
    public QueueUtil queueUtil(){
        return new QueueUtil();
    }

    /*
     * @ClassName ActiveMQConfig
     * @Desc TODO   把 topic 订阅模式发送消息工具类注入到 spring 中
     * @Date 2019/4/8 17:08
     * @Version 1.0
     */
    @Bean
    @ConditionalOnBean(value = JmsTemplate.class, name = "topicTemplate")
    public TopicUtil topicUtil(){
        return new TopicUtil();
    }

}
