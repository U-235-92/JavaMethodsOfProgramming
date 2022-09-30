package aq.koptev.chapter2.variantC;

import aq.koptev.chapter2.MatrixGen;
import aq.koptev.chapter2.MatrixPrinter;

public class SumElementMatrix {

	private static int sumBetweenFirstAndSecondPositiveElementEachRow(int[][] matrix) {
		int sum = 0;
		boolean lockFirstPositive = false, lockSecondPositive = false;
		int posFirst = 0, posSecond = 0;
		for(int i = 0; i < matrix.length; i++) {
			for(int j = 0; j < matrix[0].length; j++) {
				if(matrix[i][j] > 0) {
					if(!lockFirstPositive) {
						posFirst = j;
						lockFirstPositive = true;
						continue;
					}
					if(!lockSecondPositive) {
						posSecond = j;
						lockSecondPositive = true;
						break;
					}
				}
			}
			if((posFirst != 0 && posSecond != 0) && (posSecond > posFirst) && (posSecond - posFirst > 1)) {
				System.out.printf("Calculate sum between column [%d and %d], row %d%n", posFirst, posSecond, i);
				if((posSecond - posFirst == 2)) {
					sum += matrix[i][posSecond - 1];
				} else {
					for(int s = posFirst + 1; s < posSecond; s++) {
						sum += matrix[i][s];
					}
				}
			}
			lockFirstPositive = false; lockSecondPositive = false;
			posFirst = 0; posSecond = 0;
		}
		return sum;
	}
	
	public static void main(String[] args) {
		int[][] matrix = MatrixGen.generateMatrix(5);
		MatrixPrinter.print(matrix);
		int sum = sumBetweenFirstAndSecondPositiveElementEachRow(matrix);
		System.out.printf("The sum = %d", sum);
	}

}
