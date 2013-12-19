package com.wordpress.technologyconversations.tddtest;

import junit.framework.Assert;

import org.junit.Test;

import com.wordpress.technologyconversations.tdd.StringCalculator4;

public class StringCalculator4Test {
	
	// Removed after exception
//	@Test(expected = RuntimeException.class)
//	public final void whenMoreThan2NumbersAreUsedThenExceptionIsThrown() {
//		StringCalculator4.add("1,2,3");
//	}
	
	@Test
	public final void whenEmptyStringIsUsedThenReturnValueIs0() {
		Assert.assertEquals(0, StringCalculator4.add(""));
	}
	
	@Test
	public final void whenOneNumberIsUsedThenReturnValueIsThatSameNumber() {
		Assert.assertEquals(3, StringCalculator4.add("3"));
	}

	@Test
	public final void whenTwoNumbersAreUsedThenReturnValueIsTheirSum() {
		Assert.assertEquals(3+6, StringCalculator4.add("3,6"));
	}
	
	@Test
	public final void whenAnyNumberOfNumbersIsUsedThenReturnValuesAreTheirSums() {
		Assert.assertEquals(3+6+15+18+46+33, StringCalculator4.add("3,6,15,18,46,33"));
	}

}
