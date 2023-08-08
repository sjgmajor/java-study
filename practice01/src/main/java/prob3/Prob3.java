package prob3;

import java.util.Scanner;

public class Prob3 {
	
	public static void main(String[] args) {


		
		Scanner scanner = new Scanner(System.in);
		
		/* 코드 작성 */
	
		int j = 0;
		
		while(j < 3) {
		j++;
		
		int sum1 = 0;
		int sum2 = 0;
		System.out.print("수를 입력하세요 : ");
		int n = scanner.nextInt();
		
		for(int i = 1; i <= n; i++) {
			if(i%2 == 0 ) {
				sum1 += i;
			}	
			else {
				sum2 += i;
			}
		
		}
		
		if(n%2 == 0 ) {
			System.out.println("결과 값 : " + sum1);
		}	
		else {
			System.out.println("결과 값 : " + sum2);
		}
		
		
		}
		scanner.close();
	}
}
