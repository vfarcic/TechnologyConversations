package com.wordpress.technologyconversations.tddexamplewalkthrough;

public class StringCalculator6 {
	
	public static int add(final String numbers) {
		String delimiter = ",|\n";
		String numbersWithoutDelimiter = numbers;
		if (numbers.startsWith("//")) {
			int delimiterIndex = numbers.indexOf("//") + 2;
			delimiter = numbers.substring(delimiterIndex, delimiterIndex + 1);
			numbersWithoutDelimiter = numbers.substring(numbers.indexOf("\n") + 1);	
		}
		return add(numbersWithoutDelimiter, delimiter);
	}
	
	private static int add(final String numbers, final String delimiter) {
		int returnValue = 0;
		String[] numbersArray = numbers.split(delimiter);
		for (String number : numbersArray) {
			if (!number.trim().isEmpty()) {
				returnValue += Integer.parseInt(number.trim());
			}
		}
		return returnValue;		
	}
	
}
