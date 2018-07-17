package org.song.kafka;

import org.song.kafka.producer.KafkaProducer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.mongo.MongoDataAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication(exclude={MongoAutoConfiguration.class, MongoDataAutoConfiguration.class})
public class KafkaApplication 
{
    public static void main( String[] args )
    {
    	ConfigurableApplicationContext context = SpringApplication.run(KafkaApplication.class, args);

        KafkaProducer sender = context.getBean(KafkaProducer.class);

        for (int i = 0; i < 1; i++) {
            //调用消息发送类中的消息发送方法
            sender.send(6L);

            /*try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }*/
        }
    }
}
