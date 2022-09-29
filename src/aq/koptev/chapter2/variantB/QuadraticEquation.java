package aq.koptev.chapter2.variantB;

public class QuadraticEquation {

	private static void quadraticEquation(int a, int b, int c) {
		int d = ((int)Math.pow(b, 2) - (4 * a * c));
		if(d > 0) {
			double x1 = ((-b + Math.sqrt(d)) / (2 * a));
			double x2 = ((-b - Math.sqrt(d)) / (2 * a));
			System.out.printf("The equation has got 2 roots: [x1 = %.2f], [x2 = %.2f]%n", x1, x2);
		} else if(d == 0) {
			double x = (-b / (2 * a));
			System.out.printf("The equation has got 1 root: [x = %.2f]%n", x);
		} else {
			System.out.println("The equation hasn't got solution");
		}
	}
	
	public static void main(String[] args) {
		quadraticEquation(4, -7, -2);
	}
}
