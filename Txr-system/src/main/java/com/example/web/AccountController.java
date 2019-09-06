package com.example.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Account;
import com.example.repository.AccountRepository;

@CrossOrigin(origins = { "*" })
@RestController
public class AccountController {

	@Autowired
	private AccountRepository accountRepository;

	@RequestMapping("/accounts/{number}")
	public Account get(@PathVariable String number) {
		return accountRepository.findById(number).orElse(new Account("", 0.0));
	}

}
