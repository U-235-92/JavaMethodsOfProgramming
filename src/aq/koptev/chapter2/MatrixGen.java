package aq.koptev.chapter2;

import java.util.Arrays;

public class MatrixGen {
	
	public static int[][] generateMatrix(int size) {
		int[][] matrix = new int[size][size];
		Arrays.stream(matrix).forEach(row -> Arrays.setAll(row, operand -> (-size) + (int) (Math.random() * (size - (-size)) + 1)));
		return matrix;
	}
}
