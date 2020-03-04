package name.wwl.demo.activemq.sendmsg;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Description:
 * @Author: 王文龙
 * @Date: 2019/12/31 17:04
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class SendMsgToMqTest {
    @Autowired
    private SendMsgToMq sendMsgToMq;
    @Test
    public void testSendMsgToTopic(){
        for (int i=0;i<100;i++){
            sendMsgToMq.sendMsgToTopic(String.format("发送Topic消息%s",i));
        }

    }

    @Test
    public void testSendMsgToQueue(){
        for (int i=0;i<100;i++){
            sendMsgToMq.sendMsgToQueue(String.format("发送Queue消息%s",i));
        }
    }
}
