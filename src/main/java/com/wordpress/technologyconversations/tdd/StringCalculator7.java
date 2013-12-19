package com.wordpress.technologyconversations.tdd;

public class StringCalculator7 {
	
	public static final int add(final String numbers) {
		if (numbers.trim().isEmpty()) {
			return 0;
		}
		String delimiter = ",";
		String numbersWithoutDelimiter = numbers;
		if (numbers.startsWith("//")) {
			int delimiterIndex = numbers.indexOf("//") + 2;
			delimiter = numbers.substring(delimiterIndex, delimiterIndex + 1);
			numbersWithoutDelimiter = numbers.substring(numbers.indexOf("\n") + 1);	
		}
		return add(numbersWithoutDelimiter, delimiter);
	}
	
	private static final int add(final String numbers, final String delimiter) {
		int returnValue = 0;
		String[] numbersArray = numbers.split(delimiter);
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
