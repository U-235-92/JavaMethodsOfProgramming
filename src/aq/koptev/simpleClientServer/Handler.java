package aq.koptev.simpleClientServer;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Handler {

	private Socket clientSocket;
	private DataInputStream dis;
	private DataOutputStream dos;
	private boolean isConnected = true;
	
	public Handler(Socket clientSocket) throws IOException {
		this.clientSocket = clientSocket;
		dis = new DataInputStream(clientSocket.getInputStream());
		dos = new DataOutputStream(clientSocket.getOutputStream());
	}
	
	public void handle() {
		Thread thread = new Thread(() -> {
			try {
				while(isConnected) {
					processConection();
				}
				clientSocket.close();
			} catch(IOException e) {
				System.out.println("[handler]: Client disconnected!");
			}
		}); 
		thread.start();
	}
	
	private void processConection() throws IOException {
		String message = dis.readUTF();
		if(message.equals("exit")) {
			closeConnection();
		} else {
			dos.writeUTF(message);
		}
	}
	
	private void closeConnection() {
		isConnected = false;
	}
}
