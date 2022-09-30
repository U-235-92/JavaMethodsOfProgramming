package aq.koptev.chapter2.variantC;

import aq.koptev.chapter2.MatrixGen;
import aq.koptev.chapter2.MatrixPrinter;

public class TransposeMatrix {

	private static int[][] transpose(int[][] matrix) {
		int[][] transpose = new int[matrix.length][matrix.length];
		for(int i = 0; i < matrix.length; i++) {
			for(int j = 0; j < matrix[0].length; j++) {
				transpose[i][j] = matrix[j][i];
			}
		}
		return transpose;
	}
	
	public static void main(String[] args) {
		int[][] matrix = MatrixGen.generateMatrix(3);
		MatrixPrinter.print(matrix);
		int[][] transpose = transpose(matrix);
		MatrixPrinter.print(transpose);
	}
}
