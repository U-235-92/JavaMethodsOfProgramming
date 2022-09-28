package aq.koptev.chapter2.variantA;

public class MinCountDifferentDigitsInNumber {

	private static void printNumberWithMinDifferentDigits(int[] numbers) {
		int minDiff = numbers[0];
		int countDiff = getCountDiff(numbers[0]);
		for(int p = 1; p < numbers.length; p++) {
			if(getCountDiff(numbers[p]) < countDiff) {
				minDiff = numbers[p];
				countDiff = getCountDiff(numbers[p]);
			}
		}
		System.out.println(minDiff);
	}
	
	private static int getCountDiff(int num) {
		int countDiff = 1;
		char[] chrsNum = Integer.toString(num).toCharArray();
		char ch = chrsNum[0];
		for(int i = 1; i < chrsNum.length; i++) {
			if(ch != chrsNum[i]) {
				countDiff += 1;
				ch = chrsNum[i];
			}
		}
		return countDiff;
	}
	
	public static void main(String[] args) {
		int[] numbers = new int[] {111111112, 12345, 2222332, 12, 9769};
		printNumberWithMinDifferentDigits(numbers);
	}

}
