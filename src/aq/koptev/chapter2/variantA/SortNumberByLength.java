package aq.koptev.chapter2.variantA;

import java.util.Arrays;

import aq.koptev.chapter2.Writer;

public class SortNumberByLength {

	private static void sort(int[] numbers) {
		fastSort(numbers, 0, numbers.length - 1);
	}
	
	
	private static void fastSort(int[] numbers, int left, int right) {
		int i = left, j = right;
		String middle = Integer.toString(Math.abs(numbers[(i + j) / 2]));
		while(i <= j) {
			while(Integer.toString(Math.abs(numbers[i])).length() < middle.length()) {
				i++;
			}
			while(Integer.toString(Math.abs(numbers[j])).length() > middle.length()) {
				j--;
			}
			if(i <= j) {
				swap(numbers, i, j);
				i++; j--;
			}
		}
		if(i < right) {
			fastSort(numbers, i, right);
		}
		if(j > left) {
			fastSort(numbers, j, left);
		}
	}
	
	
	private static void swap(int[] numbers, int i, int j) {
		int tmp = numbers[i];
		numbers[i] = numbers[j];
		numbers[j] = tmp;
	}

	public static void main(String[] args) {
		int[] numbers = Writer.write(5);
		System.out.println(Arrays.toString(numbers));
		sort(numbers);
		System.out.println(Arrays.toString(numbers));
	}
}
