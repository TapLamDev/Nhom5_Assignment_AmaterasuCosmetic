package com.poly.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.poly.entity.Account;
import com.poly.entity.Account;
import com.poly.service.AccountService;
import com.poly.service.AccountService;

@CrossOrigin("*")
@RestController
@RequestMapping("/rest/register")
public class AccountRestController {

	@Autowired
	AccountService accountService;
	
	@GetMapping()
	public List<Account> getAll() {
		return accountService.findAll();
	}
	
	@GetMapping("{userName}")
	public Account getOne(@PathVariable("userName") String userName) {
		return accountService.findByUserName(userName);
	}
	

	@PostMapping()
	public Account create(@RequestBody Account account) {
		return accountService.create(account);
	}
	
	@PutMapping("{userName}")
	public Account update(@PathVariable("userName") String userName, @RequestBody Account account) {
		return accountService.update(account);
	}
	
	@DeleteMapping("{userName}")
	public void delete(@PathVariable("userName") String userName) {
		accountService.delete(userName);
	}
}
