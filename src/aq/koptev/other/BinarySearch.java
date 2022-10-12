package aq.koptev.other;

import java.util.Arrays;

public class BinarySearch {

	private static int search(int[] numbers, int val) {
		int left = 0, right = numbers.length - 1;
		int middle = 0;
		while(left <= right) {
			middle = (right + left) / 2;
			if(numbers[middle] == val) {
				return middle;
			} else if(val > numbers[middle]) {
				left = middle + 1;
			} else {
				right = middle - 1;
			}
		}
		return -1;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] numbers = new int[] {9, 55, 21, 4, 8, 5, 7, 4};
		Arrays.sort(numbers);
		int position = search(numbers, 5);
		System.out.println(position);
	}

}
