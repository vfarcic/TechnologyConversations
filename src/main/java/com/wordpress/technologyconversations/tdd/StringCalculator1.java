package com.wordpress.technologyconversations.tdd;

public class StringCalculator1 {
	
	public static final void add(final String numbers) {
		String[] numbersArray = numbers.split(",");
		if (numbersArray.length > 2) {
			throw new RuntimeException("Up to 2 numbers separated by comma (,) are allowed");
		}
	}

}
