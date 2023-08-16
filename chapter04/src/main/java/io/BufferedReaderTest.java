package io;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class BufferedReaderTest {

	public static void main(String[] args) {
		
		BufferedReader br = null;
		
		try {
			// 기반 스트림
			FileReader fr = new FileReader("./src/main/java/io/FileReaderTest.java");
			
			br = new BufferedReader(fr);
			
			String line = null;
			while((line = br.readLine()) != null) {
				System.out.println(line);
			}
		
		} catch (FileNotFoundException e) {
			System.out.println("File Not Found: " + e);
		}catch (IOException e) {
			System.out.println("error: " + e);
		}finally {
			try {
			if(br != null) {
				br.close();
			}
			}catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
