package aq.koptev.chapter2.variantA;

import java.util.Arrays;
import java.util.OptionalInt;

import aq.koptev.chapter2.Writer;

public class DiffDigitsNumber {

	private static int getDiffDigitsNumber(int[] numbers) {
		OptionalInt diff = Arrays.stream(numbers).filter(value -> {
			boolean isDiff = true;
			char[] chrs = Integer.toString(value).toCharArray();
			loop:
			for(int i = 0; i < chrs.length; i++) {
				for(int j = i + 1; j < chrs.length; j++) {
					if(chrs[i] == chrs[j]) {
						isDiff = false;
						break loop;
					}
				}
			}
			return isDiff;
		}).findFirst();
		return diff.getAsInt();
	}
	
	public static void main(String[] args) {
		int[] numbers = Writer.write(5);
		int diff = getDiffDigitsNumber(numbers);
		System.out.printf("The 1st not same digit number is %d", diff);
	}
}
