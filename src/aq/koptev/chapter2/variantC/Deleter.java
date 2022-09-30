package aq.koptev.chapter2.variantC;

import java.util.Arrays;

import aq.koptev.chapter2.MatrixGen;
import aq.koptev.chapter2.MatrixPrinter;

public class Deleter {

	private static int getMax(int[][] matrix) {
		int max = matrix[0][0];
		for(int i = 0; i < matrix.length; i++) {
			for(int j = 0; j < matrix[0].length; j++) {
				if(max < matrix[i][j]) {
					max = matrix[i][j];
				}
			}
		}
		return max;
	}
	
	private static void del(int[][] matrix) {
		int max = getMax(matrix);
		System.out.println("Max element = " + max);
		int[][] mask = new int[matrix.length][matrix.length];
		Arrays.stream(mask).forEach(row -> Arrays.setAll(row, operand ->  1));
		for(int i = 0; i < matrix.length; i++) {
			for(int j = 0; j < matrix[0].length; j++) {
				if(matrix[i][j] == max) {
					for(int m = 0; m < mask.length; m++) {
						mask[i][m] = 0;
					}
					for(int p = 0; p < mask[0].length; p++) {
						mask[p][j] = 0;
					}
				}
			}
		}
		for(int i = 0; i < matrix.length; i++) {
			for(int j = 0; j < matrix.length; j++) {
				if(mask[i][j] != 0) {
					System.out.printf("%4d ", matrix[i][j]);
				}
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		int[][] matrix = MatrixGen.generateMatrix(5);
		MatrixPrinter.print(matrix);
		del(matrix);
	}
}
