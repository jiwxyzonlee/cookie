package java0106;

import java.util.Scanner;

public class Triangle {

	public static void main(String[] args) {
		// 입력값 변수 생성
		Scanner sc = new Scanner(System.in);
		System.out.print("출력할 라인 수: ");
		int line = sc.nextInt();
		
		for (int i = 0; i < line; i = i + 1) {
			for (int j = 0; j < line - (i+1); j = j + 1 ) {
				System.out.print(" ");
			}

			for (int k = 0; k < 2*i+1; k = k + 1) {
				System.out.print(k);
				for (int l = 0; l < 2*i - 1; l = l + 1) {
					if (i == line - 1) {
						k = 2*line - 2; k = k + 1;
						System.out.print(k);
					}
					System.out.print(" ");
				}
				
			}

			System.out.print('\n');
		}
		
		sc.close();
	}

}
 