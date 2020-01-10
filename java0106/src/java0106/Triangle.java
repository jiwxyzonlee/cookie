package java0106;

import java.util.Scanner;

public class Triangle { // 끝!

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
				int top = i;
				System.out.print(top);
			}
			// 피라미드 왼쪽 사선 (홀수 반복)
			else if (i != line - 1) {
				int left = (2*i - 1) % 10;
				System.out.print(left);
			}
			// 피라미드 마지막 줄(숫자 한 줄 나열)
			// 작업이 독립적인 경우 위에서 사용한 변수를 다시 명시해도 에러가 나지 않는다
			else {
				for (int j = 2*(i+1) - 3; j < 4*i; j = j + 1 ) {
					int bottom = j % 10;
					System.out.print(bottom);
				}
			}
			
			// 피라미드 속 공백과 오른쪽 사선
			// 작업이 독립적인 경우 위에서 사용한 변수를 다시 사용해도 에러가 나지 않는다
			right_wing :
				// for (int j = 1; j < line - 2; j = j + 1) {
				for (int j = - 1; j < i - 1; j = j + 1) {
					if ( i != 0 && i != line - 1) {
						// 피라미드 속 공백
						for (int k = 0; k < 2*i - 1; k = k + 1) {
							System.out.print(" ");
						}
						// 오른쪽 사선(짝수 반복)
						int right = (2*i) % 10;
						System.out.print(right);
						break right_wing;
					}
					
				}
			System.out.print('\n');
		}
		sc.close();
	}		

}