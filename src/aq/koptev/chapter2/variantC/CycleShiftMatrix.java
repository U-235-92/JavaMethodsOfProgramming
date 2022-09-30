package aq.koptev.chapter2.variantC;

import aq.koptev.chapter2.MatrixGen;
import aq.koptev.chapter2.MatrixPrinter;

public class CycleShiftMatrix {

	private static void downShift(int[][] matrix, int shift) {
		int[] tape = getVerticalTape(matrix);
		if(shift < matrix.length) {
			tapeShift(tape, shift);
		} else {
			while(shift > (matrix.length * matrix.length)) {
				shift -= shift - matrix.length;
			}
			tapeShift(tape, shift);
		}
		convertVerticalTapeToMatrix(tape, matrix);
	}

	private static void upShift(int[][] matrix, int shift) {
		int[] tape = getVerticalTape(matrix);
		if(shift < matrix.length) {
			tapeShift(tape, -shift);
		} else {
			while(shift > (matrix.length * matrix.length)) {
				shift -= shift - matrix.length;
			}
			tapeShift(tape, -shift);
		}
		convertVerticalTapeToMatrix(tape, matrix);
	}

	private static void leftShift(int[][] matrix, int shift) {
		int[] tape = getHorizontalTape(matrix);
		if(shift < matrix.length) {
			tapeShift(tape, -shift);
		} else {
			while(shift > (matrix.length * matrix.length)) {
				shift -= shift - matrix.length;
			}
			tapeShift(tape, -shift);
		}
		convertHorizontalTapeToMatrix(tape, matrix);
	}
	
	private static void rightShift(int[][] matrix, int shift) {
		int[] tape = getHorizontalTape(matrix);
		if(shift < matrix.length) {
			tapeShift(tape, shift);
		} else {
			while(shift > (matrix.length * matrix.length)) {
				shift -= shift - matrix.length;
			}
			tapeShift(tape, shift);
		}
		convertHorizontalTapeToMatrix(tape, matrix);
	}
	
	private static int[] getVerticalTape(int[][] matrix) {
		int[] tape = new int[matrix.length * matrix.length];
		int posPaste = 0;
		for(int i = 0; i < matrix[0].length; i++) {
			int[] tmp = new int[matrix[0].length];
			int p = 0;
			for(int j = 0; j < matrix.length; j++) {
				tmp[p++] = matrix[j][i];
			}
			System.arraycopy(tmp, 0, tape, posPaste, tmp.length);
			posPaste += tmp.length;
		}
		return tape;
	}
	
	private static int[] getHorizontalTape(int[][] matrix) {
		int[] tape = new int[matrix.length * matrix.length];
		int pasteToPosition = 0;
		for(int[] row : matrix) {
			System.arraycopy(row, 0, tape, pasteToPosition, row.length);
			pasteToPosition += row.length;
		}
		return tape;
	}
	
	private static void tapeShift(int[] tape, int shift) {
		if(shift != 0) {
			if(shift > 0) { 
				swap(tape, (tape.length - 1) - (shift - 1), tape.length - 1);
				swap(tape, 0, (tape.length - 1) - shift);
				swap(tape, 0, tape.length - 1);
			} else { 
				shift *= -1;
				swap(tape, 0, shift - 1);
				swap(tape, shift, tape.length - 1);
				swap(tape, 0, tape.length - 1);
			}
		}
	}
	
	private static void swap(int[] tape, int left, int right) {
		while(left <= right) {
			int tmp = tape[left];
			tape[left] = tape[right];
			tape[right] = tmp;
			left++; right--;
		}
	}
	
	private static void convertHorizontalTapeToMatrix(int[] tape, int[][]  matrix) {
		int pastePos = 0;
		for(int i = 0; i < matrix.length; i++) {
			System.arraycopy(tape, pastePos, matrix[i], 0, matrix.length);
			pastePos += matrix.length;
		}
	}
	
	private static void convertVerticalTapeToMatrix(int[] tape, int[][] matrix) {
		int p = 0;
		for(int i = 0; i < matrix[0].length; i++) {
			for(int j = 0; j < matrix.length; j++) {
				matrix[j][i] = tape[p++];
			}
		}
	}
	
	public static void main(String[] args) {
		int[][] matrix = MatrixGen.generateMatrix(3);
		MatrixPrinter.print(matrix);
		upShift(matrix, 9);
		MatrixPrinter.print(matrix);
	}
}
