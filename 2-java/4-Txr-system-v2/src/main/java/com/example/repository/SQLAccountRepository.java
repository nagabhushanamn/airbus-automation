package com.example.repository;

import com.example.model.Account;

public class SQLAccountRepository implements AccountRepository {

	@Override
	public Account load(String accNumber) {
		// ..
		Account account = new Account(accNumber, 1000.00);
		return account;
	}

	@Override
	public Account update(Account account) {
		// ..
		return account;
	}

}
