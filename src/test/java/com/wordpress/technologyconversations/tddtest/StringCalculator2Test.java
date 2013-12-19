package com.wordpress.technologyconversations.tddtest;

import junit.framework.Assert;

import org.junit.Test;

import com.wordpress.technologyconversations.tdd.StringCalculator2;

public class StringCalculator2Test {
	
	@Test(expected = RuntimeException.class)
	public final void whenMoreThan2NumbersAreUsedThenExceptionIsThrown() {
		StringCalculator2.add("1,2,3");
	}
	
	@Test
	public final void whenEmptyStringIsUsedThenReturnValueIs0() {
		Assert.assertEquals(0, StringCalculator2.add(""));
	}

}
