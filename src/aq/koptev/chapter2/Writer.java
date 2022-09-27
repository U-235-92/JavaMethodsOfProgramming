package aq.koptev.chapter2;

import java.util.Scanner;

public class Writer {
	
	public static int[] write(int n) {
		System.out.printf("Write %d numbers ([e] for exit):%n", n);
		Scanner scanner = new Scanner(System.in);
		int[] numbers = new int[n];
		int i = 0;
		while(n > 0) {
			if(scanner.hasNextInt()) {
				numbers[i++] = scanner.nextInt();
				n--;
			} else {
				String incomming = scanner.nextLine();
				if(incomming.equals("e")) {
					break;
				}
			}
		}
		scanner.close();
		return numbers;
	}
}
