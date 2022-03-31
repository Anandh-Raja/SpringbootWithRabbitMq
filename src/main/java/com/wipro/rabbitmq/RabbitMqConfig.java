package com.wipro.rabbitmq;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RabbitMqConfig {
@Value("${rabbitmq.queue}")
String queueName;
@Value("${rabbitmq.exchange}")
String exchange;
@Value("${rabbitmq.routingkey}")
private String routingkey;
@Bean 
public RestTemplate restTemplate() {
	return new RestTemplate();
}
@Bean
Queue queue() {
	return new Queue(queueName,false);
}
@Bean
DirectExchange exchange() {
	return new DirectExchange(exchange);
}
@Bean
Binding binding(Queue queue,DirectExchange exchange)
{
	
return BindingBuilder.bind(queue).to(exchange).with(routingkey);}
@Bean
MessageConverter jsonMessageConverter() {
	return new Jackson2JsonMessageConverter();
}
@Bean
public AmqpTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
	final RabbitTemplate rabbitTemplate=new RabbitTemplate(connectionFactory);
	rabbitTemplate.setMessageConverter(jsonMessageConverter());
	return rabbitTemplate;
}
}