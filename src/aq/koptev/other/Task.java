package aq.koptev.other;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Task {

	private static void printNumbers(int n) {
		int[] numbers = IntStream.range(0, n).filter(value -> value % 3 == 0).filter(value -> value % 5 !=0).filter(value -> {
			int sum = 0;
			while(value > 0) {
				sum += value % 10;
				value /= 10;
			}
			return sum < 10;
		}).toArray();
		System.out.println(Arrays.toString(numbers));
	}
	
	public static void main(String[] args) {
		printNumbers(1000);
	}

}
