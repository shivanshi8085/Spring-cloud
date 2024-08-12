package com.rays.service01.ctl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rays.service01.kafka.MessageProducer;

@RestController
@RequestMapping(value = "api")
public class KafkaController {

	@Autowired
	MessageProducer producer;

	@GetMapping("producerMsg")
	public void getMessageFromClient(@RequestParam("message") String message) {
		System.out.println("kafka controller get");
		producer.sendMsgToTopic(message);
	}

}
