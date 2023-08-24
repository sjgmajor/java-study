package chat.gui;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class ChatClientApp {

	private static final String SERVER_IP = "127.0.0.1";
	public static final int PORT = 6666;
	public static String name = null;
	public static String nickname;
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		Socket socket = null;
		
		while( true ) {
			System.out.println("대화명을 입력하세요.");
			System.out.print("> ");
			name = scanner.nextLine();
			
			if (name.isEmpty() == false ) {
				break;
			}
			System.out.println("대화명은 한글자 이상 입력해야 합니다.\n");
		}

		try {
		//1. create socket
		socket = new Socket();
		
		//2. connect server
		socket.connect(new InetSocketAddress(SERVER_IP, PORT));
	    log("connected");
	    
	    PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "utf-8"), true);
		BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "utf-8"));
	    
		//3. join protocol 진행
		System.out.print("닉네임: " );
	    nickname = scanner.nextLine();
	    pw.println("join:" + nickname);
		   
	    String ack = br.readLine();
	
    	if("join:ok".equals(ack)){
		new ChatWindow(name, socket).show();
		} 
		} catch(IOException e) {
			System.out.println("[client] error: " + e);
		} finally {
			if(scanner != null) {
				scanner.close();
			}
		}
	}
	
	private static void log(String message) {
		System.out.println("[클라이언트] " + message);
	}
}

