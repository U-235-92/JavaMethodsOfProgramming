package aq.koptev.simpleClientServer;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {

	private Socket socket;
	private DataInputStream dis;
	private DataOutputStream dos;
	private volatile boolean isConnected = true;
	
	public Client() throws UnknownHostException, IOException {
		socket = new Socket("localhost", 5082);
		dos = new DataOutputStream(socket.getOutputStream());
		dis = new DataInputStream(socket.getInputStream());
		waitMessages();
	}
	
	private void waitMessages() {
		Thread thread = new Thread(() -> {
			try {
				while(isConnected) {
					String message = dis.readUTF();
					if(message.equals("exit")) {
						closeConnection();
					} else {
						System.out.println(message);
					}
				}
				socket.close();
			} catch (IOException e) {
				System.out.println("Close client connection!");
			}
		});
		thread.setDaemon(true);
		thread.start();
	}
	
	private void closeConnection() {
		isConnected = false;
	}
	
	public void writeMessage(String message) {
		try {
			dos.writeUTF(message);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public boolean isConnected() {
		return isConnected;
	}
}
