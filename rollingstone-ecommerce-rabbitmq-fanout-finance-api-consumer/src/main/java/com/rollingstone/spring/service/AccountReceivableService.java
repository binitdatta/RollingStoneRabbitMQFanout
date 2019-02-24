package com.rollingstone.spring.service;

import org.springframework.data.domain.Page;

import com.rollingstone.model.AccountReceivable;

public interface AccountReceivableService {

	AccountReceivable save(AccountReceivable accounteceivable);
	AccountReceivable getAccountReceivable(long id);
   Page<AccountReceivable> getAccountReceivablesByPage(Integer pageNumber, Integer pageSize);
   void update(long id, AccountReceivable account);
   void delete(long id);
}
