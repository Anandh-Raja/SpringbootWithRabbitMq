package com.wipro.spoa;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.annotation.RabbitListenerConfigurer;
import org.springframework.amqp.rabbit.listener.RabbitListenerEndpointRegistrar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.messaging.converter.MappingJackson2MessageConverter;
import org.springframework.messaging.handler.annotation.support.DefaultMessageHandlerMethodFactory;

@SpringBootApplication
@EnableRabbit
public class SportsAcademyApplication implements RabbitListenerConfigurer{

	public static void main(String[] args) {
		SpringApplication.run(SportsAcademyApplication.class, args);
	}
	@Bean
	public MappingJackson2MessageConverter jackson2Converter() {
		MappingJackson2MessageConverter c=new MappingJackson2MessageConverter();
		return c;
	}
	@Bean
	public DefaultMessageHandlerMethodFactory myHandlerMethodFactory() {
		DefaultMessageHandlerMethodFactory mhf=new DefaultMessageHandlerMethodFactory();
		mhf.setMessageConverter(jackson2Converter());
		return mhf;
	}
	@Override
	public void configureRabbitListeners(RabbitListenerEndpointRegistrar r) {
r.setMessageHandlerMethodFactory(myHandlerMethodFactory());
}
	@Autowired
	RabbitMqConsumer consumer;
}