package com.example.specs;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(value = Lifecycle.PER_CLASS)
public class TestInstanceLifecycleDemo {

	public TestInstanceLifecycleDemo() {
		System.out.println("TestInstanceLifecycleDemo :: constructor");
	}

	@Test
	public void test1() {

	}

	@Test
	public void test2() {

	}

}
