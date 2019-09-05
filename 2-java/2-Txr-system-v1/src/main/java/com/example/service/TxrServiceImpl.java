package com.example.service;

import com.example.exceptions.AccountBalanceException;
import com.example.model.Account;

public class TxrServiceImpl implements TxrService {

	@Override
	public Account transfer(double amout, Account fromAccount, Account toAccount) {
		if (fromAccount.getBalance() < amout)
			throw new AccountBalanceException("Not enough balance");

		fromAccount.setBalance(fromAccount.getBalance() - amout);
		toAccount.setBalance(toAccount.getBalance() + amout);

		return fromAccount;
	}

}
