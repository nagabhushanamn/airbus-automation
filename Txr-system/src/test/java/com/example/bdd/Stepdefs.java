package com.example.bdd;

import static org.junit.Assert.assertEquals;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.model.Account;
import com.example.service.TxrService;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class Stepdefs extends CucumberStepDefinitions {

	private Account account;

	@Autowired
	protected TxrService txrService;

	@Given("^account with (\\d+) balance$")
	public void given(double balance) {
	}
	
	@When("^transfer (\\d+)$")
	public void when(double amount) {
		account = this.txrService.transfer(amount, "1", "2");
	}

	@Then("^account must have (\\d+) balance$")
	public void then(double expected) {
		assertEquals(expected, account.getBalance(), 1.0);
	}
}
