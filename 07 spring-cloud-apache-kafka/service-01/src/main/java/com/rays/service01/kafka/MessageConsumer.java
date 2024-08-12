package com.rays.service01.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class MessageConsumer {

	@KafkaListener(topics = "my-topic", groupId = "my-group")
	public void listenToTopic(String message) {
		System.out.println("Received message = " + message);
	}

}
