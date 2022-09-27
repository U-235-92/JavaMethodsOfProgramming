package aq.koptev.chapter2.variantA;

import aq.koptev.chapter2.Writer;

public class MinMaxNumber {

	private static void minMax() {
		int[] numbers = Writer.write(5);
		int min = numbers[0], max = numbers[0];
		for(int i = 1; i < numbers.length; i++) {
			if(numbers[i] > max) {
				max = numbers[i];
			}
			if(numbers[i] < min) {
				min = numbers[i];
			}
		}
		System.out.printf("The MAX number is %d, the MIN number is %d", max, min);
	}
	
	public static void main(String[] args) {
		minMax();
	}

}
