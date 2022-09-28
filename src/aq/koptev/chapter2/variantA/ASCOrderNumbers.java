package aq.koptev.chapter2.variantA;

import java.util.Arrays;

import aq.koptev.chapter2.Writer;

public class ASCOrderNumbers {

	private static int getASCOrderNumber(int[] numbers) {
		int[] ascOrderNumbers = Arrays.stream(numbers).filter(value -> {
			boolean isMath = false;
			int tmp = value;
			int prev = tmp % 10;
			tmp /= 10;
			while(Math.abs(tmp) > 0) {
				if((tmp % 10) < prev) {
					prev = tmp % 10;
					tmp /= 10;
					isMath = true;
				} else {
					isMath = false;
					break;
				}
			}
			return isMath;
		}).toArray();
		return ascOrderNumbers[0];
	}
	
	public static void main(String[] args) {
		int[] numbers = Writer.write(5);
		int ascOrderNumber = getASCOrderNumber(numbers);
		System.out.printf("The 1st ASC number is %d", ascOrderNumber);
	}
}
