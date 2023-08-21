package chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class ChatClientThread extends Thread {

	private Socket socket;
	
	public ChatClientThread(Socket socket) {
		this.socket = socket;
	}
	
	@Override
	public void run() {
	     /* reader를 통해 읽은 데이터 콘솔에 출력하기 (message 처리) */	
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "utf-8"));
		
		while(true) {
		String data = br.readLine();
		
		if(data == null) {
			log("closed by client");
			break;
		}
		System.out.println(data);
	}
		
	} catch (IOException e) {
		e.printStackTrace();
	}

	}

	private void log(String message) {
		System.out.println("[클라이언트] " + message);
	}

}
