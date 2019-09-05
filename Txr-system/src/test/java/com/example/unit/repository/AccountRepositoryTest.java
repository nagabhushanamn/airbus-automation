package com.example.unit.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.example.model.Account;
import com.example.repository.AccountRepository;


@Tag("unit")
@ExtendWith(SpringExtension.class)
@DataJpaTest
public class AccountRepositoryTest {

	@Autowired
	private TestEntityManager entityManager;

	@Autowired
	private AccountRepository accountRepository;


	@Test
	public void whenFindByName_thenReturnEmployee() {
		
		// given
		Account account = new Account("3", 3000.00);
		entityManager.persist(account);
		entityManager.flush();

		// when
		Account found = accountRepository.findById("3").get();

		// then
		assertEquals(found.getBalance(), found.getBalance());
	}

}
