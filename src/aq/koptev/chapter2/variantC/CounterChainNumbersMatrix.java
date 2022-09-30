package aq.koptev.chapter2.variantC;

import aq.koptev.chapter2.MatrixGen;
import aq.koptev.chapter2.MatrixPrinter;

public class CounterChainNumbersMatrix {

	private static int getMaxCountASCChainNumbers(int[][] matrix) {
		int maxCount = 0;
		int chainCount = 1;
		for(int i = 0; i < matrix.length; i++) {
			for(int j = 1; j < matrix[0].length; j++) {
				if(matrix[i][j] > matrix[i][j - 1]) {
					chainCount++;
				} else {
					if(chainCount > maxCount) {
						maxCount = chainCount;
						chainCount = 1;
					}
				}
			}
		}
		return maxCount;
	}
	
	private static int getMaxCountDESCChainNumbers(int[][] matrix) {
		int maxCount = 0;
		int chainCount = 1;
		for(int i = 0; i < matrix.length; i++) {
			for(int j = 1; j < matrix[0].length; j++) {
				if(matrix[i][j] < matrix[i][j - 1]) {
					chainCount++;
				} else {
					if(chainCount > maxCount) {
						maxCount = chainCount;
						chainCount = 1;
					}
				}
			}
		}
		return maxCount;
	}
	
	public static void main(String[] args) {
		int[][] matrix = MatrixGen.generateMatrix(3);
		MatrixPrinter.print(matrix);
		int maxCountASC = getMaxCountASCChainNumbers(matrix);
		int maxCountDESC = getMaxCountDESCChainNumbers(matrix);
		System.out.printf("ASC chain count = %d, DESC chain count = %d", maxCountASC, maxCountDESC);
	}
}
