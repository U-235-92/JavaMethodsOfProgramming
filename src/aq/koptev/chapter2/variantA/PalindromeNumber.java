package aq.koptev.chapter2.variantA;

import java.util.Arrays;

import aq.koptev.chapter2.Writer;

public class PalindromeNumber {

	private static int getPalindromeNumber(int[] numbers) {
		int[] palindroms = Arrays.stream(numbers).filter(value -> {
			StringBuilder orig = new StringBuilder(Integer.toString(value));
			StringBuilder reverse = new StringBuilder(Integer.toString(value)).reverse();
			return orig.toString().equals(reverse.toString());
		}).toArray();
		if(palindroms.length != 0) {
			if(palindroms.length >= 2) {
				return palindroms[1];
			} else {
				return palindroms[0];
			}
		} else {
			return 0;
		}
	}
	
	public static void main(String[] args) {
		int[] numbers = Writer.write(5);
		int palinrome = getPalindromeNumber(numbers);
		System.out.printf("The palindrome number is %d", palinrome);
	}
}
