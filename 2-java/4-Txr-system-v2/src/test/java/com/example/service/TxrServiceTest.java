package com.example.service;

import static org.hamcrest.CoreMatchers.any;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.exceptions.AccountBalanceException;
import com.example.model.Account;
import com.example.repository.AccountRepository;
import com.example.repository.SQLAccountRepository;

@ExtendWith(MockitoExtension.class)
@DisplayName("Txr system")
public class TxrServiceTest {

	private TxrService txrService;

	@Mock
	private AccountRepository accountRepository;

	Account fromAccount;
	Account toAccount;

	@BeforeEach
	public void init() {
		fromAccount = new Account("1", 1000.00);
		toAccount = new Account("2", 1000.00);
		// record expectations
		doReturn(fromAccount).when(accountRepository).load("1");
		doReturn(toAccount).when(accountRepository).load("2");
		txrService = new TxrServiceImpl(accountRepository); // DI
	}

	@DisplayName("a valid transfer")
	@Test
	public void validTxrTest() {
		// exercise
		Account account = txrService.transfer(500.00, "1", "2");
		// assert & verify
		assertEquals(500.00, account.getBalance(), "valid txr");
		verify(accountRepository).update(fromAccount);
		verify(accountRepository).update(toAccount);
	}

	@DisplayName("exception thrown on invalid transfer")
	@Test
	public void invalidTxrTest() {
		AccountBalanceException thrown = assertThrows(AccountBalanceException.class, () -> {
			txrService.transfer(5000.00, "1", "2");
		});
		assertEquals("Not enough balance", thrown.getMessage(), "invalidTxrTest");

	}

}
