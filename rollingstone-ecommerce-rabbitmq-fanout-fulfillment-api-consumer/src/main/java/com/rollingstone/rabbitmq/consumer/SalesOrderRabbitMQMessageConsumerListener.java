package com.rollingstone.rabbitmq.consumer;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.AmqpRejectAndDontRequeueException;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;


import com.rollingstone.config.ApplicationConstant;
import com.rollingstone.spring.model.Address;
import com.rollingstone.spring.model.Fulfillment;
import com.rollingstone.spring.model.ItemMaster;
import com.rollingstone.spring.model.SalesOrderDTO;
import com.rollingstone.spring.service.FulfillmentService;

@Service
public class SalesOrderRabbitMQMessageConsumerListener {

	private static final Logger log = LoggerFactory.getLogger(SalesOrderRabbitMQMessageConsumerListener.class);

	private FulfillmentService fulfillmentService;
	 
	private Fulfillment fulfillment;
	 
	public SalesOrderRabbitMQMessageConsumerListener(FulfillmentService fulfillmentService) {
		super();
		this.fulfillmentService = fulfillmentService;
	}


	public Fulfillment getFulfillment() {
		return fulfillment;
	}

	public void setFulfillment(Fulfillment fulfillment) {
		this.fulfillment = fulfillment;
	}

	@RabbitListener(queues = "${fulfillment.queue.name}")
	public void receiveMessageForApp1(final SalesOrderDTO salesOrderDto) {
		log.info("Received account dto message: {} from account queue.", salesOrderDto);

		try {
			log.info("Ta Think");
			// TODO: Code to send email to the Account Holder
			retrieveDataForfulfillment(salesOrderDto);
			if (fulfillment != null) {
				log.info("accountReceivable is not null");
			}
			// accountReceivableService.save(accountReceivable);
			
			log.info("Message Saved");
		} catch (HttpClientErrorException ex) {

			if (ex.getStatusCode() == HttpStatus.NOT_FOUND) {
				log.info("Delay...");
				try {
					Thread.sleep(ApplicationConstant.MESSAGE_RETRY_DELAY);
				} catch (InterruptedException e) {
				}

				log.info("Throwing exception so that message will be requed in the queue.");
				// Note: Typically Application specific exception should be thrown below
				throw new RuntimeException();
			} else {
				throw new AmqpRejectAndDontRequeueException(ex);
			}

		} catch (Exception e) {
			log.error("Internal server error occurred in API call. Bypassing message requeue {}", e);
			throw new AmqpRejectAndDontRequeueException(e);
		}
	}
	
	 private void retrieveDataForfulfillment(SalesOrderDTO salesOrderDto) {
		System.out.println(salesOrderDto.toString()); 
		String fulfillmentNumber = "FLFILMNT"+salesOrderDto.getOrderNumber();
		String orderNumber = salesOrderDto.getOrderNumber();
		String specialInstruction = salesOrderDto.getSpecialInstruction();
		String shippingMethod = salesOrderDto.getShippingMethod();
		Date estimatedDeliveryDate = salesOrderDto.getEstimatedDelivaryDate();
		ItemMaster itemMaster = salesOrderDto.getItemMaster();
		String itemUPCCOde = itemMaster.getItemUPCCode();
		String itemName = itemMaster.getItemName();
		log.info("Printing Item Qty :"+salesOrderDto.getItemQuantity());
		int itemQuantity = salesOrderDto.getItemQuantity();
		String color = itemMaster.getColor();
		String pattern = itemMaster.getPattern();
		String size = itemMaster.getSize();
		String shippedBy = itemMaster.getShippedBy();
		Address address = salesOrderDto.getAddress();
		String shippingAddress = salesOrderDto.getAccount().getUser().getFirstName() + " "
								+ salesOrderDto.getAccount().getUser().getLastName() + " "
								+ address.getHouseNumber() + " " 
								+ address.getStreetAddress() + " "
								+ address.getCity() + " "
								+ address.getState() + "-"
								+ address.getZipCode();
		
		this.fulfillment = new Fulfillment(fulfillmentNumber, orderNumber, specialInstruction, shippingMethod, estimatedDeliveryDate,
				itemUPCCOde, itemName, new Integer(itemQuantity).toString(), size, color, pattern, shippedBy, shippingAddress);
		System.out.println(fulfillment.toString());
		fulfillmentService.save(fulfillment);
	}


}
