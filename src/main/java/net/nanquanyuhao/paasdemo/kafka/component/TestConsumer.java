package net.nanquanyuhao.paasdemo.kafka.component;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * Created by nanquanyuhao on 2019/4/4.
 */
@Component
public class TestConsumer {

    @KafkaListener(topics = "test_topic")
    public void listen(ConsumerRecord<?, ?> record) throws Exception {
        System.out.printf("topic = %s, offset = %d, value = %s \n", record.topic(), record.offset(), record.value());
        System.out.printf("topic = %s, offset = %d, value = %s \n", record.topic(), record.offset(), record.value());
        System.out.printf("topic = %s, offset = %d, value = %s \n", record.topic(), record.offset(), record.value());
    }
}
