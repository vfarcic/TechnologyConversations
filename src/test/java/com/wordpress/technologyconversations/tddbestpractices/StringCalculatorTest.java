package com.wordpress.technologyconversations.tddbestpractices;

import org.junit.Assert;
import org.junit.Test;

public class StringCalculatorTest {

    @Test
    public final void when2NumbersAreUsedThenNoExceptionIsThrown() {
        StringCalculator.add("1,2");
        Assert.assertTrue(true);
    }

    @Test(expected = RuntimeException.class)
    public final void whenNonNumberIsUsedThenExceptionIsThrown() {
        StringCalculator.add("1,X");
    }

    @Test
    public final void whenEmptyStringIsUsedThenReturnValueIs0() {
        Assert.assertEquals(0, StringCalculator.add(""));
    }

    @Test
    public final void whenOneNumberIsUsedThenReturnValueIsThatSameNumber() {
        Assert.assertEquals(3, StringCalculator.add("3"));
    }

    @Test
    public final void whenTwoNumbersAreUsedThenReturnValueIsTheirSum() {
        Assert.assertEquals(3+6, StringCalculator.add("3,6"));
    }

    @Test
    public final void whenAnyNumberOfNumbersIsUsedThenReturnValuesAreTheirSums() {
        Assert.assertEquals(3+6+15+18+46+33, StringCalculator.add("3,6,15,18,46,33"));
    }

    @Test
    public final void whenNewLineIsUsedBetweenNumbersThenReturnValuesAreTheirSums() {
        Assert.assertEquals(3+6+15, StringCalculator.add("3,6\n15"));
    }

    /**
     * This test specifies delimiter using //[DELIMITER]\n format.
     * Actual delimiter is semicolon (;).
     * Expected outcome is that sum of all numbers separated with semicolon is returned.
     */
    @Test
    public final void whenSemicolonDelimiterIsSpecifiedThenItIsUsedToSeparateNumbers() {
        Assert.assertEquals(3+6+15, StringCalculator.add("//;\n3;6;15"));
    }

    /**
     * BAD EXAMPLE: This test is the same as the one above but with poorly specified method name.
     *
     * This test specifies delimiter using //[DELIMITER]\n format.
     * Actual delimiter is semicolon (;).
     * Expected outcome is that sum of all numbers separated with semicolon is returned.
     */
    @Test
    public final void test1() {
        Assert.assertEquals(3+6+15, StringCalculator.add("//;\n3;6;15"));
    }

    @Test(expected = RuntimeException.class)
    public final void whenNegativeNumberIsUsedThenRuntimeExceptionIsThrown() {
        StringCalculator.add("3,-6,15,18,46,33");
    }

    @Test
    public final void whenNegativeNumbersAreUsedThenRuntimeExceptionIsThrown() {
        RuntimeException exception = null;
        try {
            StringCalculator.add("3,-6,15,-18,46,33");
        } catch (RuntimeException e) {
            exception = e;
        }
        Assert.assertNotNull("Exception was not thrown", exception);
        Assert.assertEquals("Negatives not allowed: [-6, -18]", exception.getMessage());
    }

    @Test
    public final void whenOneOrMoreNumbersAreGreaterThan1000IsUsedThenItIsNotIncludedInSum() {
        Assert.assertEquals(3+1000+6, StringCalculator.add("3,1000,1001,6,1234"));
    }

    @Test
    public final void whenAddIsUsedThenItWorks() {
        Assert.assertEquals(0, StringCalculator.add(""));
        Assert.assertEquals(3, StringCalculator.add("3"));
        Assert.assertEquals(3+6, StringCalculator.add("3,6"));
        Assert.assertEquals(3+6+15+18+46+33, StringCalculator.add("3,6,15,18,46,33"));
        Assert.assertEquals(3+6+15, StringCalculator.add("3,6\n15"));
        Assert.assertEquals(3+6+15, StringCalculator.add("//;\n3;6;15"));
        Assert.assertEquals(3+1000+6, StringCalculator.add("3,1000,1001,6,1234"));
    }

}
