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
import java.io.PrintWriter;

public class ChatWindow {

	private Frame frame;
	private Panel pannel;
	private Button buttonSend;
	private TextField textField;
	private TextArea textArea;
	private int count = 0;
	private PrintWriter pw = null;
	private BufferedReader br = null;

	public ChatWindow(String name, PrintWriter pw, BufferedReader br) {
		frame = new Frame(name);
		pannel = new Panel();
		buttonSend = new Button("Send");
		textField = new TextField();
		textArea = new TextArea(30, 80);
		this.pw = pw;
		this.br = br;
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
		new ChatClientThread().start();

	}
	private void sendMessage() {
				
				if(count == 1) {
					String message;
					message = textField.getText();
					
					textField.setText("");
					textField.requestFocus();
					
					if("quit".equals(message)) {
						finish();
					}
					//ChatClinetThread에서 서버로부터 받는 메시지가 있다고 치고~~
					if ((message.trim()).isEmpty() == false ) {
				    System.out.println(ChatClientApp.nickname + "님이 메세지를 보내는 프로코톨 구현: " + message);
					updateTextArea(ChatClientApp.nickname + ": " + message);				 
					}
					else {
					updateTextArea("메세지는 한글자 이상 입력해야 합니다.");
					}
					
				}
				if(count == 0) {
					count = 1;
					textField.setText("");
					textField.requestFocus();
					updateTextArea("채팅창에 입장하였습니다.");
					updateTextArea("----------------------------");
					updateTextArea("보낼 매세지를 입력하고 Enter");
					updateTextArea("채팅을 종료하려면 quit를 입력하고 Enter");
					updateTextArea("----------------------------");
				}
	}
	
	private void finish() {
		// quit 프로토콜 구현
//		pw.println("quit");
//		// exit java(JVM)
//		try {
//			if(pw != null) {
//				pw.close();
//			}
//			if(br != null) {
//				br.close();
//			}
//		} catch(IOException e) {
//			e.printStackTrace();
//		}
//		
		System.exit(0);
	}
	private void updateTextArea(String message) {
		textArea.append(message);
		textArea.append("\n");
	}
	
	private class ChatClientThread extends Thread{
		@Override
		public void run() {
			
			sendMessage();
			
		}
	}
}