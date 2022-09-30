package aq.koptev.chapter2;

import java.util.Arrays;

public class MatrixPrinter {

	public static void print(int[][] matrix) {
		Arrays.stream(matrix).forEach(row -> {
			Arrays.stream(row).forEach(element -> System.out.printf("%4d", element));
			System.out.println();
		});
		for(int i = 0; i < matrix.length; i++) {
			System.out.printf("%4s", "_");
		}
		System.out.println();
	}
}
