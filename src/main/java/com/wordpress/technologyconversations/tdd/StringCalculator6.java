package com.wordpress.technologyconversations.tdd;

public class StringCalculator6 {
	
	public static final int add(final String numbers) {
		if (numbers.trim().isEmpty()) {
			return 0;
		}
		int returnValue = 0;
		String[] numbersArray = numbers.split(",");
		for (String number : numbersArray) {
			if (!number.trim().isEmpty()) {
				returnValue += Integer.parseInt(number.trim());
			} else {
				throw new RuntimeException("Empty number is not allowed");
			}
		}
		return returnValue;
	}


}
