package com.wordpress.technologyconversations.tddexamplewalkthrough;

import junit.framework.Assert;

import org.junit.Test;

public class StringCalculator3Test {
	
	@Test(expected = RuntimeException.class)
	public final void whenMoreThan2NumbersAreUsedThenExceptionIsThrown() {
		StringCalculator3.add("1,2,3");
	}
	
	@Test
	public final void when2NumbersAreUsedThenNoExceptionIsThrown() {
		StringCalculator3.add("1,2");
		Assert.assertTrue(true);
	}

	@Test(expected = RuntimeException.class)
	public final void whenNonNumberIsUsedThenExceptionIsThrown() {
		StringCalculator3.add("1,X");
	}

	@Test
	public final void whenEmptyStringIsUsedThenReturnValueIs0() {
		Assert.assertEquals(0, StringCalculator3.add(""));
	}
	
	@Test
	public final void whenOneNumberIsUsedThenReturnValueIsThatSameNumber() {
		Assert.assertEquals(3, StringCalculator3.add("3"));
	}

	@Test
	public final void whenTwoNumbersAreUsedThenReturnValueIsTheirSum() {
		Assert.assertEquals(3+6, StringCalculator3.add("3,6"));
	}

}
