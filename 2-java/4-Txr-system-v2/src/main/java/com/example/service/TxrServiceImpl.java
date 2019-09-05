package com.example.service;

import com.example.exceptions.AccountBalanceException;
import com.example.model.Account;
import com.example.repository.AccountRepository;

public class TxrServiceImpl implements TxrService {

	private AccountRepository accountRepository;

	public TxrServiceImpl(AccountRepository accountRepository) {
		super();
		this.accountRepository = accountRepository;
	}

	@Override
	public Account transfer(double amout, String fromAccNumber, String toAccNumber) {

		Account fromAccount = accountRepository.load(fromAccNumber);
		Account toAccount = accountRepository.load(toAccNumber);

		if (fromAccount.getBalance() < amout)
			throw new AccountBalanceException("Not enough balance");

		fromAccount.setBalance(fromAccount.getBalance() + amout);
		toAccount.setBalance(toAccount.getBalance() + amout);

		accountRepository.update(fromAccount);
		accountRepository.update(toAccount);

		return fromAccount;
	}

}
