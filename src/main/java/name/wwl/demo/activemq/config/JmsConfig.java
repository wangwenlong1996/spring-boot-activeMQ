package name.wwl.demo.activemq.config;

import lombok.extern.slf4j.Slf4j;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;

import org.springframework.boot.autoconfigure.jms.JmsPoolConnectionFactoryFactory;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;


import javax.jms.*;

    /**
     * @Description:
     * @Author: 王文龙
     * @Date: 2019/8/30 15:51
     */
    @Slf4j
    @Configuration
    @EnableConfigurationProperties
    @EnableJms
    public class JmsConfig {



        @Bean("testTopic")
        public ActiveMQTopic activeMQTopic(){
            return  new ActiveMQTopic("spiderTest");

        }

        @Bean("testQueue")
        public ActiveMQQueue activeMQQueue(){
            return  new ActiveMQQueue("spiderTest");

        }


        @Bean
        public JmsListenerContainerFactory<?> jmsListenerContainerQueue(ConnectionFactory connectionFactory) {
            DefaultJmsListenerContainerFactory bean = new DefaultJmsListenerContainerFactory();
            bean.setConnectionFactory(connectionFactory);
            return bean;
        }


        @Bean
        public JmsListenerContainerFactory<?> jmsListenerContainerTopic(ConnectionFactory connectionFactory) {
            DefaultJmsListenerContainerFactory bean = new DefaultJmsListenerContainerFactory();
            bean.setPubSubDomain(true);
            bean.setConnectionFactory(connectionFactory);
            return bean;
        }


    }

