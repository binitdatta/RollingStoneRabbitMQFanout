package com.rollingstone.spring.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.rollingstone.model.AccountReceivable;
import com.rollingstone.spring.dao.AccountReceivableDaoRepository;

@Service
public class AccountReceivableImpl implements AccountReceivableService {

	  final static Logger logger = LoggerFactory.getLogger(AccountReceivableImpl.class);

	  
	private AccountReceivableDaoRepository accountDao; 
	  
	public AccountReceivableImpl(AccountReceivableDaoRepository accountDao) {
		this.accountDao = accountDao;
	}
  
  
   @Override
   public AccountReceivable save(AccountReceivable account) {
	  logger.info("(KC Modi is here is AccountReceivableImpl");
	  logger.info("Account Model Received from KC Modi :"+account.toString());
      return accountDao.save(account);
   }
   
   @Override
   public    AccountReceivable getAccountReceivable(long id) {
	   logger.info("Inside getAccount");
	   if (accountDao == null) {
		   logger.info("Inside accountDao null");
	   }
	   AccountReceivable accountDto = accountDao.getAccountReceivableByid(id);
	   if (accountDto == null) {
		   logger.info("Inside getAccount null");
		   logger.info("Inside getAccount null id "+id);

	   }
	   return accountDto;
   }

 

   @Override
   public Page<AccountReceivable> getAccountReceivablesByPage(Integer pageNumber, Integer pageSize) {
	   Pageable pageable = PageRequest.of(pageNumber, pageSize, Sort.by("accountNumber").descending());
	   return accountDao.findAll(pageable);
   }

   @Override
   public void update(long id, AccountReceivable account) {
      accountDao.save(account);
   }

   
   @Override
   public void delete(long id) {
      accountDao.deleteById(id);
   }

}
