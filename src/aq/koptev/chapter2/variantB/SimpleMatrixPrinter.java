package aq.koptev.chapter2.variantB;

import java.util.Arrays;

import aq.koptev.chapter2.Writer;

public class SimpleMatrixPrinter {
	
	private static void printNumbersFromLeftToRight(int[] numbers) {
		int[][] matrix = new int[numbers.length][numbers.length];
		for(int i = 0; i < numbers.length; i++) {
			for(int k = i; k < matrix[0].length; k++) {
				for(int m = 0; m < matrix.length; m++) {
					matrix[m][k] = numbers[i];
				}
			}
		}
		for(int[] n : matrix) {
			System.out.println(Arrays.toString(n));
		}
	}
	
	private static void printNumbersFromTopToDown(int[] numbers) {
		int[][] matrix = new int[numbers.length][numbers.length];
		for(int i = 0; i < numbers.length; i++) {
			for(int k = 0; k < matrix[0].length; k++) {
				for(int m = i; m < matrix.length; m++) {
					matrix[m][k] = numbers[i];
				}
			}
		}
		for(int[] n : matrix) {
			System.out.println(Arrays.toString(n));
		}
	}
	
	public static void main(String[] args) {
		int[] numbers = Writer.write(3);
		printNumbersFromLeftToRight(numbers);
		System.out.println("##");
		printNumbersFromTopToDown(numbers);
	}
}
