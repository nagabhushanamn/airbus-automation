package com.example.util;

public class Calculator {

	private CalculatorService calculatorService;

	public Calculator(CalculatorService calculatorService) {
		super();
		this.calculatorService = calculatorService;
	}

	public Integer add(int i, int j) {
		return calculatorService.add(i, j);
	}

	public Integer multiply(int i, int j) {
		return i * j;
	}

	public Object divide(int i, int j) {
		return i / j;
	}

	public Object subtract(int i, int j) {
		// TODO Auto-generated method stub
		return i - j;
	}

}
