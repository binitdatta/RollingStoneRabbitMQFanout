package com.rollingstone.spring.service;

import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.rollingstone.spring.dao.SalesOrderDaoRepository;
import com.rollingstone.spring.model.SalesOrder;
import com.rollingstone.spring.model.SalesOrderDTO;
import com.rollingstone.spring.model.SalesOrderDetails;
@Service
public class SalesOrderServiceImpl implements SalesOrderService {

	final static Logger logger = LoggerFactory.getLogger(SalesOrderServiceImpl.class);

	@Autowired
	private SalesOrderDaoRepository salesOrderDao;  
	
	@Override
	public SalesOrder save(SalesOrder salesOrder) {
		Set<SalesOrderDetails> soDetails = salesOrder.getSalesOrderDetails();
		
		for (SalesOrderDetails details : soDetails ) {
			details.setSalesOrder(salesOrder);
		}
		
		return salesOrderDao.save(salesOrder);
	}

	@Override
	public SalesOrderDTO getSalesOrder(long id) {
		   logger.info("Inside getAccount");
		   if (salesOrderDao == null) {
			   logger.info("Inside salesOrderDao null");
		   }
		   SalesOrderDTO salesOrderDto = salesOrderDao.getSalesOrderByid(id);
		   if (salesOrderDto == null) {
			   logger.info("Inside getSalesOrder null");
			   logger.info("Inside getSalesOrder null id "+id);

		   }
		   return salesOrderDto;
	}

	@Override
	public Page<SalesOrder> getSalesOrderByPage(Integer pageNumber, Integer pageSize) {
		   Pageable pageable = PageRequest.of(pageNumber, pageSize, Sort.by("salesOrder").descending());
		   return salesOrderDao.findAll(pageable);
	}

	@Override
	public void update(long id, SalesOrder salesOrder) {
		salesOrderDao.save(salesOrder);

	}

	@Override
	public void delete(long id) {
		salesOrderDao.deleteById(id);

	}

}
