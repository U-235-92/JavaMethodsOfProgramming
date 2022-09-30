package aq.koptev.chapter2.variantC;

import java.util.Arrays;

import aq.koptev.chapter2.MatrixGen;
import aq.koptev.chapter2.MatrixPrinter;

public class SortMatrix {

	@SuppressWarnings("unused")
	private static void sortByColumn(int[][] matrix, int column) {
		if(column < matrix.length) {
			int[] tmp = new int[matrix[0].length];
			for(int i = 0; i < matrix.length; i++) {
				tmp[i] = matrix[i][column];
			}
			Arrays.sort(tmp);
			for(int i = 0; i < matrix.length; i++) {
				matrix[i][column] = tmp[i];
			}
		}
	}
	
	@SuppressWarnings("unused")
	private static void sortByRow(int[][] matrix, int row) {
		if(row < matrix.length) {
			Arrays.sort(matrix[row]);
		}
	}
	
	public static void main(String[] args) {
		int[][] matrix = MatrixGen.generateMatrix(5);
		MatrixPrinter.print(matrix);
		sortByRow(matrix, 0);
		MatrixPrinter.print(matrix);
	}
}
