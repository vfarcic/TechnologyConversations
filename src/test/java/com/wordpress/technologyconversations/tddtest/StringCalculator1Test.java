package com.wordpress.technologyconversations.tddtest;

import org.junit.Test;

import com.wordpress.technologyconversations.tdd.StringCalculator1;

public class StringCalculator1Test {
	
	@Test(expected = RuntimeException.class)
	public final void whenMoreThan2NumbersAreUsedThenExceptionIsThrown() {
		StringCalculator1.add("1,2,3");
	}

}
