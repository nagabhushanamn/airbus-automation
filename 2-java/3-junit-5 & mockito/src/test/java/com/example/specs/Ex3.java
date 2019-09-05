package com.example.specs;

//Let's import Mockito statically so that the code looks clearer
import static org.mockito.Mockito.*;

import java.util.List;

import org.junit.jupiter.api.Test;

/**
 * 
 * @author nag-training
 *
 *         3. Argument matchers
 *
 */

public class Ex3 {

	@Test
	public void test() {

		// mock creation
		List mockedList = mock(List.class);

		// stubbing using built-in anyInt() argument matcher
		when(mockedList.get(anyInt())).thenReturn("element");

		// following prints "element"
		System.out.println(mockedList.get(999));

		// you can also verify using an argument matcher
		verify(mockedList).get(anyInt());

	}

}
