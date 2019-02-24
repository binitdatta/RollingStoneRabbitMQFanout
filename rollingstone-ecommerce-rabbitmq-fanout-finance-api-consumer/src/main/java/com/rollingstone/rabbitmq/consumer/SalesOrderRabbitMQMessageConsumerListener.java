package com.rollingstone.rabbitmq.consumer;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.AmqpRejectAndDontRequeueException;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import com.rollingstone.config.ApplicationConstant;
import com.rollingstone.model.AccountReceivable;
import com.rollingstone.model.SalesOrderDTO;
import com.rollingstone.spring.service.AccountReceivableService;

@Service
public class SalesOrderRabbitMQMessageConsumerListener {

	private static final Logger log = LoggerFactory.getLogger(SalesOrderRabbitMQMessageConsumerListener.class);

	private AccountReceivableService accountReceivableService;
	 
	private AccountReceivable accountReceivable;
	 
	public SalesOrderRabbitMQMessageConsumerListener(AccountReceivableService accountReceivableService) {
		super();
		this.accountReceivableService = accountReceivableService;
	}

	public AccountReceivable getAccountReceivable() {
		return accountReceivable;
	}

	public void setAccountReceivable(AccountReceivable accountReceivable) {
		this.accountReceivable = accountReceivable;
	}
	@RabbitListener(queues = "${account-receivable.queue.name}")
	public void receiveMessageForApp1(final SalesOrderDTO salesOrderDto) {
		log.info("Received account dto message: {} from account queue.", salesOrderDto);

		try {
			log.info("Ta Think");
			// TODO: Code to send email to the Account Holder
			retrieveDataForAccountReceivable(salesOrderDto);
			if (accountReceivable != null) {
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
	
	 private void retrieveDataForAccountReceivable(SalesOrderDTO salesOrderDto) {
		String transactionNumber = "TRNSLS"+salesOrderDto.getOrderNumber();
		long accountId = salesOrderDto.getAccount().getId();
		long userId = salesOrderDto.getAccount().getUser().getId();
		long salesOrderId = salesOrderDto.getId();
		Date transactionDate = salesOrderDto.getSalesDate();
		double transactionAmount = salesOrderDto.getTotalOrderAmount();
		long salesRepId = salesOrderDto.getEmployee().getId();
		
		this.accountReceivable = new AccountReceivable(transactionNumber, accountId, userId, 
				salesOrderId, transactionDate, transactionAmount, salesRepId);
		
		accountReceivableService.save(accountReceivable);


	}


}
