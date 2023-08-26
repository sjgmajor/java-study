package chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.List;

public class ChatServerThread extends Thread {

	public static int userSize;
	public String nickname;
	private Socket socket;
	List<PrintWriter> chatUsers;
	
	public static int count = 0;
	
	public ChatServerThread( Socket socket, List<PrintWriter> chatUsers) {
		   this.socket = socket;
		   this.chatUsers = chatUsers;
		}

	@Override
	public void run() {
		
		PrintWriter pw = null;
		BufferedReader br = null;
		
		try {
			pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "utf-8"), true);
			br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "utf-8"));
			
			
			InetSocketAddress remoteInetSocketAddress = (InetSocketAddress) socket.getRemoteSocketAddress();
			String remoteHostAddress = remoteInetSocketAddress.getAddress().getHostAddress();
			int remotePort = remoteInetSocketAddress.getPort();
			log("connected by client[" + remoteHostAddress + ":" + remotePort + "]");

			while( true ) {
				   String line = br.readLine();
				   
				   if( line == null ) {
					   log( "클라이언트[" + remoteHostAddress + ":" + remotePort + "]" + "로부터 연결 끊김" );
					   doQuit(pw);
					   break;
				   }
				   
				   // 4. 프로토콜 분석
				   String[] tokens = line.split(":");
				
				   if( "join".equals(tokens[0]) ) {
					  doJoin(tokens[1], pw);
				   } else if("message".equals(tokens[0])) {
				      doMessage(tokens[1]);
				   } else if("quit".equals(tokens[0])) {
				      doQuit(pw);
				      break;
				   } else {
				      log("에러:알수 없는 요청(" + tokens[0] + ")");				      
				   }
				}	
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	private void doMessage(String message) {
		String data = this.nickname + ":" + message;
		broadcast( data );
	}
	
	private void doJoin(String nickName, PrintWriter pw ) {
		
	   	   this.nickname = nickName;
		   String data = nickName + "님이 참여하였습니다."; 
		  
		   broadcast(data);
		   
		   /* writer pool에  저장 */ 
		   addWriter(pw);
		   
		   // ack
		   pw.println("join:ok");
	}
		
	private void broadcast(String data) {
		synchronized( chatUsers ) {
		      for( PrintWriter pWriter : chatUsers ) {
			pWriter.println(data);
		      }
		   }
	}

	private void doQuit(PrintWriter pw) {
		   removeWriter(pw);
		   if( nickname !=null) {
		   String data = nickname + "님이 퇴장 하였습니다."; 
		   broadcast(data);
		   }
		}

	private void removeWriter(PrintWriter pw) {
		   /* 잘 구현 해보기 */	
			chatUsers.remove(pw);
		}
	
	private void addWriter(PrintWriter pw) {
	   synchronized(chatUsers) {
		   chatUsers.add(pw);
	   }
	}

	private static void log(String message) {
		System.out.println("[서버] " + message);
	}

}
