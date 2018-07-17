package org.song.kafka.producer;

import java.util.Date;
import java.util.UUID;
import java.util.concurrent.ExecutionException;

import org.song.kafka.message.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;

import com.alibaba.fastjson.JSONObject;

@Component
public class KafkaProducer {

	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;

	//发送消息方法
	public void send(Long id) {
		Message message = new Message(id, UUID.randomUUID().toString(), new Date());
		ListenableFuture<SendResult<String, String>> futureResult = kafkaTemplate.send("topic", String.valueOf(id), JSONObject.toJSONString(message));
		try {
			SendResult<String, String> result = futureResult.get();
			System.out.println("=====================send:"+result.getProducerRecord().partition());
			System.out.println("=====================send:"+result.getProducerRecord().key());
			System.out.println("=====================send:"+result.getProducerRecord().topic());
			System.out.println("=====================send:"+result.getProducerRecord().timestamp());
			System.out.println("=====================send:"+result.getProducerRecord().headers());
			
			System.out.println("=====================send:"+result.getRecordMetadata().offset());
			System.out.println("=====================send:"+result.getRecordMetadata().serializedKeySize());
			System.out.println("=====================send:"+result.getRecordMetadata().serializedValueSize());
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
	}

}
