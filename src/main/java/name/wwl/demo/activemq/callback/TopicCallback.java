package name.wwl.demo.activemq.callback;

import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.TextMessage;

/**
 * @Description:
 * @Author: 王文龙
 * @Date: 2019/12/25 10:57
 */
@Slf4j
@Component
public class TopicCallback {

    @JmsListener(destination = "spiderTest",containerFactory="jmsListenerContainerTopic")
    public void receiveTopic(TextMessage textMessage) throws JMSException, InterruptedException {

        log.info("节点2topic测试数据：{}",textMessage.getText());
//        Thread.sleep(10000);
        log.info("节点2topic测试数据消费成功：{}",textMessage.getText());

    }
}
