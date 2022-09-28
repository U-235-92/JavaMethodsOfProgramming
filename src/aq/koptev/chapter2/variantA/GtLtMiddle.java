package aq.koptev.chapter2.variantA;

import aq.koptev.chapter2.Writer;

public class GtLtMiddle {

	private static void printLittleNumbersThanMiddleNumberLength(int[] numbers) {
		int middleLength = getMiddleLengthNumber(numbers);
		System.out.printf("The middle length of number is: %d %n", middleLength);
		for(int num : numbers) {
			if(Integer.toString(num).length() < middleLength) {
				System.out.printf("Little number: %d, length: %d %n", num, Integer.toString(num).length());
			}
		}
	}
	
	private static void printGreaterNumbersThanMiddleNumberLength(int[] numbers) {
		int middleLength = getMiddleLengthNumber(numbers);
		System.out.printf("The middle length of number is: %d %n", middleLength);
		for(int num : numbers) {
			if(Integer.toString(num).length() > middleLength) {
				System.out.printf("Greater number: %d, length: %d %n", num, Integer.toString(num).length());
			}
		}
	}
	
	private static int getMiddleLengthNumber(int[] numbers) {
		int middleLength = 0;
		for(int num : numbers) {
			middleLength += Integer.toString(num).length();
		}
		return middleLength / numbers.length;
	}
	
	public static void main(String[] args) {
		int[] numbers = Writer.write(5);
		printGreaterNumbersThanMiddleNumberLength(numbers);
		printLittleNumbersThanMiddleNumberLength(numbers);
	}
}
