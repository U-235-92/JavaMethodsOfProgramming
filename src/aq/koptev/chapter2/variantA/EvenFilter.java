package aq.koptev.chapter2.variantA;

import java.util.Arrays;

import aq.koptev.chapter2.Writer;

public class EvenFilter {

	private static int getCountEvenFiltredNumbers(int[] numbers) {
		int[] evens = Arrays.stream(numbers).filter(value -> value % 2 == 0).toArray();
		int[] sameNumbersOddEvenDigits = Arrays.stream(evens).filter(value -> {
			int evenCount = 0, oddCount = 0;
			char[] chars = Integer.toString(value).toCharArray();
			for(char ch : chars) {
				if((int) ch % 2 == 0) {
					evenCount++;
				} else {
					oddCount++;
				}
			}
			return evenCount == oddCount;
		}).toArray();
		return sameNumbersOddEvenDigits.length;
	}
	
	public static void main(String[] args) {
		int[] numbers = Writer.write(5);
		int count = getCountEvenFiltredNumbers(numbers);
		System.out.printf("The count of even numbers with same count odd and even digits = %d%n", count);
		/*896
		8996
		99
		4
		888 */
	}

}
