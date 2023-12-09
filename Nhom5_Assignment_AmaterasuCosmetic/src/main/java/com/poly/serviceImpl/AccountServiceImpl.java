package com.poly.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poly.dao.AccountDao;
import com.poly.entity.Account;
import com.poly.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	AccountDao aDao;
	
	@Override
	public List<Account> findAll() {
		// TODO Auto-generated method stub
		return aDao.findAll();
	}

	@Override
	public Account findByUserName(String username) {
		// TODO Auto-generated method stub
		return aDao.findById(username).get();
	}

	@Override
	public List<Account> findByAccountUserName(String cusername) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Account create(Account account) {
		// TODO Auto-generated method stub
		return aDao.save(account);
	}

	@Override
	public Account update(Account account) {
		// TODO Auto-generated method stub
		return aDao.save(account);
	}

	@Override
	public void delete(String username) {
		// TODO Auto-generated method stub
		aDao.deleteById(username);
	}
}
