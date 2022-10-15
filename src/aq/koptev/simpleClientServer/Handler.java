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
				System.out.println("Client connection was broke!");
			}
		}); 
		thread.start();
	}
	
	private void processConection() throws IOException {
		String message = dis.readUTF();
		if(message.equals("exit")) {
			dos.writeUTF("[SERVER SYSTEM MESSAGE]: Client disconnected!");
			closeConnection();
		} else {
			dos.writeUTF("[SERVER ECHO]: " + message);
		}
	}
	
	private void closeConnection() {
		isConnected = false;
	}
}
