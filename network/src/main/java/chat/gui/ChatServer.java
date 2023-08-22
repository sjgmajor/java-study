package chat.gui;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ChatServer {

	public static final int PORT = 6666;	
	
	
	public static void main(String[] args) {
		
		List<PrintWriter> chatUsers = new ArrayList<PrintWriter>();
		ServerSocket serverSocket = null;
			
		try {
			serverSocket = new ServerSocket();
			log("시작됨");
			
			serverSocket.bind(new InetSocketAddress("0.0.0.0", PORT), 10);

			// 3. 요청 대기 
	            while (true) {
					Socket socket = serverSocket.accept();
					new ChatServerThread(socket, chatUsers);
	            }
			
		} catch (IOException e) {
			log("error:" + e);
		} finally {
			try {
				if(serverSocket != null && !serverSocket.isClosed()) {
					serverSocket.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}	
	}

	private static void log(String message) {
		System.out.println("[ChatServer#" + Thread.currentThread().getId() + "] " + message);
	}
}
