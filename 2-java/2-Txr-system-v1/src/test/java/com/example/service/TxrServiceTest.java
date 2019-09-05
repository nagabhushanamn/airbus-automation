package com.example.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.example.exceptions.AccountBalanceException;
import com.example.model.Account;

@DisplayName("Txr system")
public class TxrServiceTest {

	private TxrService txrService;

	@BeforeEach
	public void init() {
		txrService = new TxrServiceImpl();
	}

	@DisplayName("a valid transfer")
	@Test
	public void validTxrTest() {

		Account fromAccount = new Account("1", 1000.00);
		Account toAccount = new Account("2", 1000.00);

		Account account = txrService.transfer(500.00, fromAccount, toAccount);

		assertEquals(500.00, account.getBalance(), "valid txr");

	}

	@DisplayName("exception thrown on invalid transfer")
	@Test
	public void invalidTxrTest() {

		Account fromAccount = new Account("1", 1000.00);
		Account toAccount = new Account("2", 1000.00);

		AccountBalanceException thrown = assertThrows(AccountBalanceException.class, () -> {
			txrService.transfer(5000.00, fromAccount, toAccount);
		});
		assertEquals("Not enough balance", thrown.getMessage(), "invalidTxrTest");

	}

}
