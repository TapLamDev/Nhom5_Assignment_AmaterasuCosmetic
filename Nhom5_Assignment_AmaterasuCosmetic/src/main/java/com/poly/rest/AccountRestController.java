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

import jakarta.validation.Valid;

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

	@GetMapping("{username}")
	public Account getOne(@PathVariable("username") String username) {
		return accountService.findByUserName(username);
	}

	@PostMapping()
	public Account create(@Valid @RequestBody Account account) {
		return accountService.create(account);
	}

	@PutMapping("{username}")
	public Account update(@PathVariable("username") String username, @Valid @RequestBody Account account) {
		return accountService.update(account);
	}

	@DeleteMapping("{username}")
	public void delete(@PathVariable("username") String username) {
		accountService.delete(username);
	}
}
