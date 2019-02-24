package com.rollingstone.spring.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.rollingstone.events.SalesOrderEvent;
import com.rollingstone.spring.model.SalesOrder;
import com.rollingstone.spring.model.SalesOrderDTO;
import com.rollingstone.spring.service.SalesOrderService;

@RestController
@RequestMapping(value="/rscommerce/pdp-service")
public class SalesOrderController extends AbstractController {
	Logger logger = LoggerFactory.getLogger(this.getClass());
	  
	   private SalesOrderService salesOrderService;
	   
	   
	   public SalesOrderController(SalesOrderService salesOrderService) 
			   {
		   this.salesOrderService = salesOrderService;
	   }

	   /*---Add new Account---*/
	   @PostMapping("/salesOrder")
	   public ResponseEntity<?> createSalesOrder(@RequestBody SalesOrder salesPrder) {
	      SalesOrder savedSalesOrder = salesOrderService.save(salesPrder);
	      SalesOrderDTO sosDto = salesOrderService.getSalesOrder(savedSalesOrder.getId());
	      SalesOrderEvent salesOrderCreatedEvent = new SalesOrderEvent(this, "SalesOrderCreatedEvent", sosDto);
	      eventPublisher.publishEvent(salesOrderCreatedEvent);
	      return ResponseEntity.ok().body("New Account has been saved with ID:" + savedSalesOrder.getId());
	   }

	   /*---Get a Account by id---*/
	   @GetMapping("/salesOrder/{id}")
	   @ResponseBody
	   public SalesOrderDTO getSalesOrder(@PathVariable("id") long id) {
		   if (salesOrderService == null) {
			   logger.info("salesOrderService is null");
		   }
		   SalesOrderDTO sosDto = salesOrderService.getSalesOrder(id);
		  //logger.info("Account is :"+account.toString());
		   SalesOrderEvent salesOrderRetriveEvent = new SalesOrderEvent(this, "salesOrderRetriveEvent", sosDto);
	      eventPublisher.publishEvent(salesOrderRetriveEvent);
	      return sosDto;
	   }
	   
	 

	   /*---Delete a Account by id---*/
	   @DeleteMapping("/salesOrder/{id}")
	   public ResponseEntity<?> deleteSalesOrder(@PathVariable("id") long id) {
			  checkResourceFound(this.salesOrderService.getSalesOrder(id));
			  salesOrderService.delete(id);
	      return ResponseEntity.ok().body("Sales Order has been deleted successfully.");
	   }
}
