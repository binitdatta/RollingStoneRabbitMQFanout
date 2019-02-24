package com.rollingstone.listeners;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.rollingstone.events.SalesOrderEvent;
@Component
public class SalesOrderEventListeners {
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	private  RabbitTemplate rabbitTemplate;
	private  SalesOrderMessageSender salesOrderMessageSender;
	
	@Value("${sales-order.exchange.name}")
	private  String salesOrderExchangeName;
	
	@Value("${sales-order.routing.key}")
	private  String salesOrderRoutingKey;
	
	public SalesOrderEventListeners(RabbitTemplate rabbitTemplate, SalesOrderMessageSender salesOrderMessageSender) {
		    this.rabbitTemplate = rabbitTemplate;
		    this.salesOrderMessageSender = salesOrderMessageSender;
	}
	 
	@EventListener
	public void onApplicationEvent(SalesOrderEvent salesOrderEvent) {
		log.info("Received Account Event : "+salesOrderEvent.getEventType());
		log.info("Received Account From Account Event :"+salesOrderEvent.getSalesOrderDto().toString());
		 log.info("Sales Order created with ID :"+ salesOrderEvent.getSalesOrderDto().getOrderNumber() +
		    		"and Total Order Amount :"+ salesOrderEvent.getSalesOrderDto().getTotalOrderAmount()) ;
		 log.info("Printing Sales Order Details Data before sending message :"+ salesOrderEvent.getSalesOrderDto().toString());
		    salesOrderMessageSender.sendMessage(rabbitTemplate, salesOrderExchangeName, salesOrderRoutingKey, salesOrderEvent.getSalesOrderDto());
		   // rabbitTemplate.convertAndSend(exchange.getName(), accountRoutingKey, accountEvent.getAccount());
	}

}
