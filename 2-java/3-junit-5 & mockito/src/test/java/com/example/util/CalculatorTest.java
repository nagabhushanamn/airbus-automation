package com.example.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CalculatorTest {

	private Calculator calculator;
	private CalculatorService calculatorService;

	@BeforeEach
	public void init() {
		calculatorService = mock(CalculatorService.class);
		calculator = new Calculator(calculatorService);
	}

	@Test
	void addition() {
		when(calculatorService.add(1, 1)).thenReturn(2);
		assertEquals(2, calculator.add(1, 1));
	}

}
