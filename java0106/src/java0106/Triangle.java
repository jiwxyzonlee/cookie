package java0106;

import java.util.Scanner;

public class Triangle {

	public static void main(String[] args) {
		// 입력값 변수 생성
		Scanner sc = new Scanner(System.in);
		System.out.print("출력할 라인 수: ");
		int line = sc.nextInt();
		for (int i = 0; i < line; i = i + 1) {
			for (int j = 0; j < 2*line - i; j = j + 1 ) {
				System.out.print(" ");
				System.out.print(j);
				
			}
		}

		
		
		
		
		sc.close();
	}

}
 