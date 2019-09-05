package com.example.specs;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.TestInfo;

public class RepeatedTestsDemo {

	@BeforeEach
	void beforeEach(TestInfo testInfo, RepetitionInfo repetitionInfo) {
		int currentRepetition = repetitionInfo.getCurrentRepetition();
		int totalRepetitions = repetitionInfo.getTotalRepetitions();
		String methodName = testInfo.getTestMethod().get().getName();
		System.out.println(String.format("About to execute repetition %d of %d for %s", currentRepetition,totalRepetitions, methodName));
	}

	@RepeatedTest(10)
	void repeatedTest() {
		// ...
	}

//	@RepeatedTest(value = 1, name = "{displayName} {currentRepetition}/{totalRepetitions}")
//	@DisplayName("Repeat!")
//	void customDisplayName(TestInfo testInfo) {
//		assertEquals("Repeat! 1/1", testInfo.getDisplayName());
//	}

}
