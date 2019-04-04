package net.nanquanyuhao.paasdemo.kafka;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by nanquanyuhao on 2019/4/4.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Test
    public void contextLoads() {
        kafkaTemplate.send("test_topic", "测试消息收发！！");

        // 强制睡眠10s延长进程杀死时间，保证消息消费
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
