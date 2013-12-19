package com.wordpress.technologyconversations.tdd;

public class StringCalculator5 {
	
	public static final int add(final String numbers) {
		int returnValue = 0;
		String[] numbersArray = numbers.split(",");
		for (String number : numbersArray) {
			if (!number.trim().isEmpty()) {
				returnValue += Integer.parseInt(number.trim());
			}
		}
		return returnValue;
	}


}
