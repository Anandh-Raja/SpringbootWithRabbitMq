package com.wipro.rabbitmq;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.entities.StudentSubscription;
@RestController
@RequestMapping(value="/rabbitmq")
public class RabbitMqController {
	@Autowired
	RabbitMqSender rbtmqsender;
	@PostMapping(value="/producer")
	public String producer(@RequestBody StudentSubscription studs) {
		rbtmqsender.send(studs);
		return "Message send to the RabbitMq Successfully";
	}

}
