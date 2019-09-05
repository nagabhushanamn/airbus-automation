package com.example.specs;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.example.util.Calculator;

public class CalculatorTest {

	// Arrange
	private final Calculator calculator = new Calculator();

	@Test
	void addition() {
		// Act & Assert
		assertEquals(2, calculator.add(1, 1));
	}

}