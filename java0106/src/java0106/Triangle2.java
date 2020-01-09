package java0106;

import java.util.Scanner;

public class Triangle2 { // 미완성!

	public static void main(String[] args) {
		// 입력값 변수 생성
		Scanner sc = new Scanner(System.in);
		System.out.print("출력할 라인 수: ");
		int line = sc.nextInt();
				
		// 역삼각 공백(숫자 앞 공백)
		for (int i = 0; i < line; i = i + 1) {	
			for (int j = 0; j < line - (i+1); j = j + 1 ) {
				System.out.print(" ");
			}
			// 꼭대기 0
			if (i == 0) {
				System.out.print(i);
			}
			// 첫번째 사선 (홀수)
			else if (i != line - 1) {
				System.out.print(2*i - 1);
			}
			
			// 피라미드 속 공백과 두번째 사선
			right_wing :
				for (int k = 1; k < line - 2; k = k + 1) {
					for (int l = 0; l < 2*i - 1; l = l + 1) {
						// 피라미드 속 공백
						if (i != 0 && i != line - 1) {
							System.out.print(" ");
						}
					}
					// 두번째 사선 (짝수)
					if (i !=0 && i != line - 1) {
						System.out.print(2*i);
						break right_wing;
					}
				} 
			
			System.out.print('\n');
		}		
		sc.close();
	}

}
	 