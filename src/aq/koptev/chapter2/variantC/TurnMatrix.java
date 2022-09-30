package aq.koptev.chapter2.variantC;

import aq.koptev.chapter2.MatrixGen;
import aq.koptev.chapter2.MatrixPrinter;

public class TurnMatrix {

	private static int[][] turnMatrix90Left(int[][] matrix) {
		int[][] turnMatrix = new int[matrix.length][matrix.length];
		for(int i = 0; i < matrix.length; i++) {
			for(int j = 0; j < matrix[0].length; j++) {
				int rowPos = (matrix.length - 1) - j;
				turnMatrix[rowPos][i] = matrix[i][j];
			}
		}
		return turnMatrix;
	}
	
	private static int[][] turnMatrix90Right(int[][] matrix) {
		int[][] turnMatrix = new int[matrix.length][matrix.length];
		for(int i = 0; i < matrix.length; i++) {
			for(int j = 0; j < matrix[0].length; j++) {
				int rowPos = (matrix.length - 1) - j;
				turnMatrix[i][j] = matrix[rowPos][i];
			}
		}
		return turnMatrix;
	}
	
	public static void main(String[] args) {
		int[][] matrix = MatrixGen.generateMatrix(3);
		MatrixPrinter.print(matrix);
		int[][] turnMatrix = turnMatrix90Right(matrix);
		MatrixPrinter.print(turnMatrix);
	}
}
