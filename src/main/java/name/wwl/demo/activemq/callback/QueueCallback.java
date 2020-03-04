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
public class QueueCallback {

    @JmsListener(destination = "spiderTest",containerFactory="jmsListenerContainerQueue")
    public void receiveTopic(TextMessage textMessage) throws JMSException, InterruptedException {


        log.info("节点2queue测试数据：{}",textMessage.getText());
//        Thread.sleep(50000);
        log.info("节点2queue测试数据处理完毕：{}",textMessage.getText());
    }
}
