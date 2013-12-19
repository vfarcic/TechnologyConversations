package com.wordpress.technologyconversations.tddtest;

import junit.framework.Assert;

import org.junit.Test;

import com.wordpress.technologyconversations.tdd.StringCalculator9;

public class StringCalculator9Test {
	
	@Test
	public final void whenEmptyStringIsUsedThenReturnValueIs0() {
		Assert.assertEquals(0, StringCalculator9.add(""));
	}
	
	@Test
	public final void whenOneNumberIsUsedThenReturnValueIsThatSameNumber() {
		Assert.assertEquals(3, StringCalculator9.add("3"));
	}

	@Test
	public final void whenTwoNumbersAreUsedThenReturnValueIsTheirSum() {
		Assert.assertEquals(3+6, StringCalculator9.add("3,6"));
	}
	
	@Test
	public final void whenAnyNumberOfNumbersIsUsedThenReturnValuesAreTheirSums() {
		Assert.assertEquals(3+6+15+18+46+33, StringCalculator9.add("3,6,15,18,46,33"));
	}

	@Test
	public final void whenNewLineIsUsedBetweenNumbersThenReturnValuesAreTheirSums() {
		Assert.assertEquals(3+6+15, StringCalculator9.add("3,6\n,15"));
	}

	@Test(expected = RuntimeException.class)
	public final void whenOneOfNumbersIsEmptyStringThenExceptionIsThrown() {
		StringCalculator9.add("3,\n,15");
	}

	@Test
	public final void whenDelimitedIsSpecifiedThenItIsUsedToSeparateNumbers() {
		Assert.assertEquals(3+6+15, StringCalculator9.add("//;\n3;6;15"));
	}
	
	@Test(expected = RuntimeException.class)
	public final void whenNegativeNumberIsUsedThenRuntimeExceptionIsThrown() {
		StringCalculator9.add("3,-6,15,18,46,33");
	}

	@Test
	public final void whenNegativeNumbersAreUsedThenRuntimeExceptionIsThrown() {
		RuntimeException exception = null;
		try {
			StringCalculator9.add("3,-6,15,-18,46,33");
		} catch (RuntimeException e) {
			exception = e;
		}
		Assert.assertNotNull(exception);
		Assert.assertEquals("Negatives not allowed: [-6, -18]", exception.getMessage());
	}

	@Test
	public final void whenOneOrMoreNumbersAreGreaterThan1000IsUsedThenItIsNotIncludedInSum() {
		Assert.assertEquals(3+6, StringCalculator9.add("3,1001,6,1234"));
	}

}
