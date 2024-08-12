package com.rays.service01.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class MessageProducer {

	@Autowired
	KafkaTemplate<String, String> template;

	public void sendMsgToTopic(String message) {
		template.send("my-topic", message);
	}

}
