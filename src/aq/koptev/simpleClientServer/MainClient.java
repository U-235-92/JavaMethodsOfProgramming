package aq.koptev.simpleClientServer;

import java.io.IOException;
import java.util.Scanner;

public class MainClient {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Client client = null;
		try {
			client = new Client();
		} catch(IOException e) {
			e.printStackTrace();
		}
		System.out.println("Input message");
		while(client.isConnected()) {
			String message = scanner.nextLine();
			client.writeMessage(message);
		}
		scanner.close();
	}
}
