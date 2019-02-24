package com.rollingstone.spring.service;

import org.springframework.data.domain.Page;

import com.rollingstone.spring.model.Fulfillment;

public interface FulfillmentService {

	Fulfillment save(Fulfillment fulfillment);
	Fulfillment getFulfillment(long id);
   Page<Fulfillment> getFulfillmentByPage(Integer pageNumber, Integer pageSize);
   void update(long id, Fulfillment fulfillment);
   void delete(long id);
}
