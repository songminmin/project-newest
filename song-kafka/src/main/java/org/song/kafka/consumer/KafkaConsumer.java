package org.song.kafka.consumer;

import java.util.Optional;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumer {

	@KafkaListener(topics = {"topic"})
    public void listen(ConsumerRecord<?, ?> record) {
		System.out.println(record.key());
		System.out.println(record.offset());
        Optional<?> kafkaMessage = Optional.ofNullable(record.value());
        if (kafkaMessage.isPresent()) {
            Object message = kafkaMessage.get();
            
            System.out.println("+++++++++++++++++receive:"+ message);
        }

    }
	
}
