package aq.koptev.simpleClientServer;

import java.io.IOException;

public class MainServer {

	public static void main(String[] args) {
		Server server;
		try {
			server = new Server();
			server.start();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
