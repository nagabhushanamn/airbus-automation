package com.example.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import com.example.model.Account;

@DisplayName("Txr system")
public class TxrServiceTestWithParams {

	private TxrService txrService;

	@BeforeEach
	public void init() {
		txrService = new TxrServiceImpl();
	}

	@DisplayName("a valid transfer")
	@ParameterizedTest
	@CsvSource({ "100,900", "200,800" })
	public void validTxrTest(double amount, double expected) {

		Account fromAccount = new Account("1", 1000.00);
		Account toAccount = new Account("2", 1000.00);

		Account account = txrService.transfer(amount, fromAccount, toAccount);

		assertEquals(expected, account.getBalance(), "valid txr");

	}

}
