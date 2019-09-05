package com.example.specs;

//Let's import Mockito statically so that the code looks clearer
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import java.util.List;

import org.junit.jupiter.api.Test;

/**
 * 
 * @author nag-training
 * 
 *         1. Let's verify some behaviour!
 *
 */
public class Ex1 {

	@Test
	public void test() {

		// mock creation
		List mockedList = mock(List.class);

		// using mock object
		mockedList.add("one");
		mockedList.clear();

		// verification
		verify(mockedList).add("one");
		verify(mockedList).clear();

	}

}
