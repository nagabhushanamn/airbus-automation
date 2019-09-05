package com.example.service;

import org.springframework.stereotype.Service;

import com.example.exceptions.AccountBalanceException;
import com.example.model.Account;
import com.example.repository.AccountRepository;

@Service
public class TxrServiceImpl implements TxrService {

	private AccountRepository accountRepository;

	public TxrServiceImpl(AccountRepository accountRepository) {
		super();
		this.accountRepository = accountRepository;
	}

	@Override
	public Account transfer(double amout, String fromAccNumber, String toAccNumber) {

		Account fromAccount = accountRepository.findById(fromAccNumber).get();
		Account toAccount = accountRepository.findById(toAccNumber).get();

		if (fromAccount.getBalance() < amout)
			throw new AccountBalanceException("Not enough balance");

		fromAccount.setBalance(fromAccount.getBalance() - amout);
		toAccount.setBalance(toAccount.getBalance() + amout);

		accountRepository.save(fromAccount);
		accountRepository.save(toAccount);

		return fromAccount;
	}

}
