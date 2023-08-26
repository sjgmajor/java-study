package chat.gui;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class ChatWindow {

	private Frame frame;
	private Panel pannel;
	private Button buttonSend;
	private TextField textField;
	private TextArea textArea;
	
	private String message;
	private String name;
	
	private Socket socket;
	private PrintWriter pw;
	private BufferedReader br;

	public ChatWindow(String name, Socket socket) {
		frame = new Frame(name);
		pannel = new Panel();
		buttonSend = new Button("Send");
		textField = new TextField();
		textArea = new TextArea(30, 80);
		this.name = name;
		this.socket = socket;
	}

	public void show() {
		// Button
		buttonSend.setBackground(Color.GRAY);
		buttonSend.setForeground(Color.WHITE);
		buttonSend.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent actionEvent ) {
				sendMessage();
			}
		});
//		buttonSend.addActionListener((ActionEvent e) -> {
//			
//		});
		// Textfield
		textField.setColumns(80);
		textField.addKeyListener(new KeyAdapter() {

			@Override
			public void keyPressed(KeyEvent e) {
				char keyCode = e.getKeyChar();
				if(keyCode == KeyEvent.VK_ENTER){
					sendMessage();
				}
			}
		});

		// Pannel
		pannel.setBackground(Color.LIGHT_GRAY);
		pannel.add(textField);
		pannel.add(buttonSend);
		frame.add(BorderLayout.SOUTH, pannel);

		// TextArea
		textArea.setEditable(false);
		frame.add(BorderLayout.CENTER, textArea);

		// Frame
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				finish();
			}
		});
		
		frame.setVisible(true);
		frame.pack();
		
		//IOStream 받아오기
		//ChatClientThread 생성하고 실행
		
		updateTextArea("채팅창에 입장하였습니다.");
		updateTextArea("----------------------------");
		updateTextArea("보낼 매세지를 입력하고 Enter");
		updateTextArea("채팅을 종료하려면 quit를 입력하고 Enter");
		updateTextArea("----------------------------");
		
		try {
			pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "utf-8"), true);
			br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "utf-8"));
			new ChatClientThread(socket).start();
			
		} catch (IOException e) {
			log("error:" + e);
		} 
	}
	
	private void sendMessage() {
				message = textField.getText();
				
				if ((message.trim()).isEmpty() == false ) {
					
					if(message.equals("quit")) {
						finish();
					}
					
					pw.println("message:" + message);
					textField.setText("");
					textField.requestFocus();
					//ChatClinetThread에서 서버로부터 받는 메시지가 있다고 치고~~
					System.out.println(ChatClientApp.nickname + "님이 메세지를 보내는 프로코톨 구현: " + message);
				}
				else {
					updateTextArea("메세지는 한글자 이상 입력해야 합니다.");
				}
	}
	
	private void finish() {
        //quit 프로토콜 구현
		// exit java(JVM)
		try {
			if(socket != null && !socket.isClosed()) {
			socket.close();
			}
//			pw.println("quit");
			System.exit(0);
		} catch (IOException e) {
			log("error:" + e);
		}
	}
	
	private void updateTextArea(String message) {
		textArea.append(message);
		textArea.append("\n");
	}
	
	private class ChatClientThread extends Thread{
		
		private Socket socket;

		public ChatClientThread(Socket socket) {
			this.socket = socket;
		}

		@Override
		public void run() {
			try {
				 while(true) {
					String data = br.readLine();
					updateTextArea(data);
				 }
			} catch (IOException e) {
				log("error:" + e);
			}
		}
}
	private static void log(String message) {
		System.out.println("[클라이언트] " + message);
	}
}