package name.wwl.demo.activemq.sendmsg;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import javax.jms.TextMessage;

/**
 * @Description:
 * @Author: 王文龙
 * @Date: 2019/12/31 16:29
 */
@Component
@Slf4j
public class SendMsgToMq {
    @Autowired
    private JmsTemplate jmsTemplate;

    @Autowired
    @Qualifier("testTopic")
    private ActiveMQTopic activeMQTopic;

    @Autowired
    @Qualifier("testQueue")
    private ActiveMQQueue activeMQQueue;


    public void sendMsgToTopic(String msg){
        jmsTemplate.send(activeMQTopic, session -> {
            TextMessage textMessage = session.createTextMessage(msg);
            return textMessage;
        });

    }

    public void sendMsgToQueue(String msg){
        jmsTemplate.send(activeMQQueue, session -> {
            TextMessage textMessage = session.createTextMessage(msg);
//                orderInfoTextMessage.setJMSType("order_info");
            return textMessage;
        });

    }

}
