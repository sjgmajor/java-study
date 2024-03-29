package echo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketException;

public class EchoRequestHandler extends Thread {
		public Socket socket;
		
	public EchoRequestHandler(Socket socket) {
		this.socket = socket;
	}

	@Override
	public void run() {
		try {
			InetSocketAddress remoteInetSocketAddress = (InetSocketAddress) socket.getRemoteSocketAddress();
			String remoteHostAddress = remoteInetSocketAddress.getAddress().getHostAddress();
			int remotePort = remoteInetSocketAddress.getPort();
			log("connected by client[" + remoteHostAddress + ":" + remotePort + "]");

//			OutputStream os = socket.getOutputStream();
//			InputStream is = socket.getInputStream();
//			PrintWriter pw = new PrintWriter(new OutputStreamWriter(os, "utf-8")); 
//			pw.print("안녕");
//			pw.flush(); // byte를 채우기 전에 전송
			
			PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(),"utf-8"), true);
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "utf-8"));
//			pw.println("안녕");
			
			while(true) {
//				byte[] buffer = new byte[256];
//				int readByteCount = is.read(buffer); 
				String data = br.readLine();
				if(data == null) {
					log("closed by client");
					break;
				}
				log("received: " + data);
				pw.println(data);
			}
			
		} catch(SocketException e) {
			log("suddenly closed by client");
		} catch(IOException e) {
			log("error: " + e);
		} finally {
			try {
				if(socket != null && !socket.isClosed()) {
					socket.close();
				}
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
		}	
	
	private void log(String message) {
		System.out.println("[EchoClient#" + getId() + "] " + message);

}
}


