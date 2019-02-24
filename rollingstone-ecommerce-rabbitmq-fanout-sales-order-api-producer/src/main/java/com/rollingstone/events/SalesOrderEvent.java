package com.rollingstone.events;

import org.springframework.context.ApplicationEvent;

import com.rollingstone.spring.model.SalesOrderDTO;

public class SalesOrderEvent extends ApplicationEvent{

	private static final long serialVersionUID = 1L;
	private String eventType;
	private SalesOrderDTO salesOrderDto;
	
	public String getEventType() {
		return eventType;
	}

	public void setEventType(String eventType) {
		this.eventType = eventType;
	}

	public SalesOrderDTO getSalesOrderDto() {
		return salesOrderDto;
	}

	public void setSalesOrderDto(SalesOrderDTO salesOrderDto) {
		this.salesOrderDto = salesOrderDto;
	}
	
	public SalesOrderEvent(Object source, String eventType, SalesOrderDTO salesOrderDto) {
		super(source);
		this.eventType = eventType;
		this.salesOrderDto = salesOrderDto;
	}

	@Override
	public String toString() {
		return "SalesOrderEvent [eventType=" + eventType + ", salesOrderDto=" + salesOrderDto + "]";
	}

}
