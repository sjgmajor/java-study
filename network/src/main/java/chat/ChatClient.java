package chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketException;
import java.util.Scanner;

public class ChatClient {

	private static final String SERVER_IP = "127.0.0.1";
	public static final int PORT = 6666;	
	
	public static void main(String[] args) {
		Scanner scanner = null;
		Socket socket = null;
		
		try {
		   //1. 키보드 연결
			scanner = new Scanner(System.in);
			
		   //2. socket 생성
		    socket = new Socket();
			
		   //3. 연결
		    socket.connect(new InetSocketAddress(SERVER_IP, PORT));
		    log("connected");
			
		   //4. reader/writer 생성
			PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "utf-8"), true);
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "utf-8"));
			
		   //5. join 프로토콜
		    System.out.print("닉네임:" );
		    String nickname = scanner.nextLine();
		    pw.println("join:" + nickname);
		   
		    String ack = br.readLine();
		
	    	if("join:ok".equals(ack)){
			System.out.println("채팅창에 입장하였습니다.");
			System.out.println("----------------------------");
			System.out.println("보낼 매세지를 입력하고 Enter");
			System.out.println("채팅을 종료하려면 quit를 입력하고 Enter");
			System.out.println("----------------------------");
	    	}
	    
		   //6. ChatClientReceiveThread 시작
			new ChatClientThread(socket).start();

		   //7. 키보드 입력 처리
			while( true ){
		      String input = scanner.nextLine();
		      if("quit".equals(input) == true) {
		          // 8. quit 프로토콜 처리
		          pw.println("quit");
		    	  break;
		      } else if("".equals(input) == false){
		          // 9. 메시지 처리
		    	  pw.println("message:" + input);
		      }
		   }

		} catch(IOException e) {
			System.out.println("[client] error: " + e);
		} finally {
			try {
				if(socket != null && !socket.isClosed()) {
					socket.close();
				}
				if(scanner != null) {
					scanner.close();
				}
			} catch(IOException e){
				e.printStackTrace();
				}
		}
	}

	private static void log(String message) {
		// TODO Auto-generated method stub
		System.out.println("[클라이언트] " + message);
	}
}
