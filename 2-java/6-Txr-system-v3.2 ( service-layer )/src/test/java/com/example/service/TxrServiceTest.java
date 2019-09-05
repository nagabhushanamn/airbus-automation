package com.example.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.doReturn;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.example.exceptions.AccountBalanceException;
import com.example.model.Account;
import com.example.repository.AccountRepository;


@ExtendWith(SpringExtension.class)
@SpringBootTest
public class TxrServiceTest {
	

	@Autowired
	private TxrService txrService;

	@MockBean
	private AccountRepository accountRepository;

	@BeforeEach
	public void init() {
		doReturn(Optional.of(new Account("1", 1000.00))).when(accountRepository).findById("1");
		doReturn(Optional.of(new Account("2", 1000.00))).when(accountRepository).findById("2");
		txrService = new TxrServiceImpl(accountRepository);
	}

	@org.junit.jupiter.api.Test
	public void validTxrTest() {
		Account account = txrService.transfer(500.00, "1", "2");
		assertEquals(500.00, account.getBalance(), "validTxrTest");
	}

	@org.junit.jupiter.api.Test
	public void invalidTxrTest() {
		AccountBalanceException thrown = assertThrows(AccountBalanceException.class, () -> {
			txrService.transfer(5000.00, "1", "2");
		});
		assertEquals("Not enough balance", thrown.getMessage(), "invalidTxrTest");

	}

}
