package com.rollingstone.spring.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.rollingstone.spring.dao.FulfillmentDaoRepository;
import com.rollingstone.spring.model.Fulfillment;

@Service
public class FulfillmentServiceImpl implements FulfillmentService {

	  final static Logger logger = LoggerFactory.getLogger(FulfillmentServiceImpl.class);

	  
	private FulfillmentDaoRepository fulfillmentDao; 
	  
	public FulfillmentServiceImpl(FulfillmentDaoRepository fulfillmentDao) {
		this.fulfillmentDao = fulfillmentDao;
	}
  
  
   @Override
   public Fulfillment save(Fulfillment fulfillment) {
	  logger.info("(KC Modi is here is AccountReceivableImpl");
	  logger.info("Account Model Received from KC Modi :"+fulfillment.toString());
      return fulfillmentDao.save(fulfillment);
   }
   
   @Override
   public Fulfillment getFulfillment(long id) {
	   logger.info("Inside getAccount");
	   if (fulfillmentDao == null) {
		   logger.info("Inside fulfillmentDao null");
	   }
	   Fulfillment fulfillment = fulfillmentDao.getFulfillmentByid(id);
	   if (fulfillment == null) {
		   logger.info("Inside getFulfillment null");
		   logger.info("Inside getFulfillment null id "+id);

	   }
	   return fulfillment;
   }

 

   @Override
   public Page<Fulfillment> getFulfillmentByPage(Integer pageNumber, Integer pageSize) {
	   Pageable pageable = PageRequest.of(pageNumber, pageSize, Sort.by("fullfillment number").descending());
	   return fulfillmentDao.findAll(pageable);
   }

   @Override
   public void update(long id, Fulfillment fulfillment) {
	   fulfillmentDao.save(fulfillment);
   }

   
   @Override
   public void delete(long id) {
	   fulfillmentDao.deleteById(id);
   }

}
