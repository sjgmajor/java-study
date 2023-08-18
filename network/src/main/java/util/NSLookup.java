package util;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Scanner;

public class NSLookup {

	public static void main(String[] args) {
	
		Scanner scanner = new Scanner(System.in);
		
		while(true) {
			System.out.print(">> ");
			String line = scanner.nextLine();
		
			if("quit".equals(line)) {
				break;
			}
			
			try {
				  InetAddress inetAddress = InetAddress.getLocalHost();
							
				  /* 여기에 정보를 출력하는 코드 추가 */		
							
				  InetAddress[] s = InetAddress.getAllByName(line);
				  
				  for(InetAddress i : s) {
				  System.out.println(i.getHostName() + " : " + i.getHostAddress());
				  }
				  
				} catch (UnknownHostException e) {
				      e.printStackTrace();
				}
			
		}
		scanner.close();
		
	}

}
