package com.example.web;

import com.example.model.Account;

public class TxrResponse {

	private String message;
	private Account account;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

}
