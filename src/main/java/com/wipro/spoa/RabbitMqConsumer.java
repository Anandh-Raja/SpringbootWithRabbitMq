package com.wipro.spoa;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class RabbitMqConsumer {
	@Autowired
	SportARepo repository;
	@RabbitListener(queues="${rabbitmq.queue}")
	public void receivedMessage(StudentSubscription studsub) {
		repository.save(studsub);
		System.out.println("Message from RabbitMq"+ studsub);
	}

}
