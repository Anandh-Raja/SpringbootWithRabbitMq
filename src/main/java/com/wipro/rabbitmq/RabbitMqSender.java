package com.wipro.rabbitmq;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.wipro.entities.StudentSubscription;

import antlr.collections.List;

@Service
public class RabbitMqSender {
	@Autowired
	private AmqpTemplate rabbittemplate;
	@Autowired
	private RestTemplate resttemplate;
	@Value("${rabbitmq.exchange}")
	private String exchange;
	@Value("${rabbitmq.routingkey}")
	private String routingkey;
	@SuppressWarnings("unchecked")
	public void send(StudentSubscription studs)
	{
		List sportsList=resttemplate.getForObject("http:localhost:5050/sports", List.class);
		System.out.println("resttemplateoutput");
		System.out.println(sportsList);
		rabbittemplate.convertAndSend(exchange, routingkey,studs);
		System.out.println("send message="+studs);
	}

}
