package aq.koptev.chapter2.variantB;

public class Interval {

	private static boolean isIntervalIncludeRight(int val, int left, int right) {
		return (val > left && val <= right);
	}
	
	private static boolean isIntervalIncludeLeft(int val, int left, int right) {
		return (val >= left && val < right);
	}
	
	private static boolean isIntervalIncludeRightLeft(int val, int left, int right) {
		return (val >= left && val <= right);
	}
	
	private static boolean isIntervalWithoutRightLeft(int val, int left, int right) {
		return (val > left && val < right);
	}
	
	public static void main(String[] args) {
		boolean isFromLeftIncludeRight = isIntervalIncludeRight(5, 2, 5);
		boolean isFromLeftIncludeLeft = isIntervalIncludeLeft(5, 2, 5);
		boolean isFromLeftIncludeRightLeft = isIntervalIncludeRightLeft(4, 2, 5);
		boolean isWithoutRightLeft = isIntervalWithoutRightLeft(1, 2, 5);
		System.out.printf("(n, m] is %b%n", isFromLeftIncludeRight);
		System.out.printf("[n, m) is %b%n", isFromLeftIncludeLeft);
		System.out.printf("[n, m] is %b%n", isFromLeftIncludeRightLeft);
		System.out.printf("(n, m) is %b%n", isWithoutRightLeft);
	}

}
