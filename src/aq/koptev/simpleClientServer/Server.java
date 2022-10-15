package aq.koptev.simpleClientServer;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	private static final int PORT = 5082;
	private ServerSocket serverSocket;
	private Socket clientSocket;
	
	public Server() throws IOException {
		serverSocket = new ServerSocket(PORT);
	}
	
	public void start() throws IOException {
		System.out.println("Start server!");
		while(!serverSocket.isClosed()) {
			System.out.println("Wait connection...");
			clientSocket = serverSocket.accept();
			System.out.println("New connection!");
			Handler handler = new Handler(clientSocket);
			handler.handle();
		}
	}
}
