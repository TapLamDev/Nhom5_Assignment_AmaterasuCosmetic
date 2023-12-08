package com.poly.service;

import java.util.List;

import com.poly.entity.Account;

public interface AccountService {
	
	List<Account> findAll();
	
	Account findByUserName(String username);
	
	List<Account> findByAccountUserName(String cusername);
	
	Account create(Account Account);
	
	Account update(Account Account);
	
	void delete(String username);
}
