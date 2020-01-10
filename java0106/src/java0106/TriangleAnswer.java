package java0106;

import java.util.Scanner;

public class TriangleAnswer {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("출력할 라인 수: ");
		int line = sc.nextInt();
		
		int su = 0;
		
		for(int i = 0; i < line; i = i + 1) {
			
			// 공백 출력
			for(int j = 0; j < line - (i+1); j = j + 1) {
				System.out.print(" ");
			}
			
			// 숫자와 공백 출력
			// 첫번째 줄은 숫자 1게, 마지막 줄은 숫자 2*line - 1 개
			// 그 이외의 경우는 숫자 1개 공백 숫자 1개 출력
			if (i == 0) {
				System.out.print(su % 10);
				su = su + 1;
			}
			
			// 맨 마지막 줄
			else if ( i == line - 1) {
				for(int j = 0; j < 2*line - 1; j = j + 1) {
					System.out.print(su % 10);
					su = su + 1;
				}
			}
			
			// 첫번째와 마지막을 제외한 가운데
			else {
				// 숫자 1개 출력
				System.out.print(su % 10);
				su = su + 1;
				// 중간 공백 만들기 : 2*i-1 개
				for (int j = 0; j < 2*i - 1; j = j + 1) {
					System.out.print(" ");
				}
				// 숫자 1개 출력
				System.out.print(su % 10);
				su = su + 1;
			}
			// System.out.println();
			System.out.print("\n");
		}
		sc.close();
	}
}