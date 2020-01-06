package java0106;

import java.util.Scanner;

public class Fibonacci {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		System.out.println("합을 구할 항의 번호 : ");
		int su = sc.nextInt();
		if (su == 1) {
			System.out.print("합은 1\n");
		}else if(su == 2) {
			System.out.print("합은 2\n");
		}else {
			// 두 번째 항까지는 규칙이 적용되지 않기 때문에
			// 미리 합계를 구해놓아야 함
			int sum = 2;
			// 현재 항의 두번째 이전 데이터를 저장할 변수
			int f2 = 1;
			// 현재 항의 첫번째 이전 데이터를 저장할 변수
			int f1 = 1;
			// 현재 계산될 항
			int f = 2;
			for(int i = 3; i <= su; i = i + 1) {
				sum = sum + f;
				
				// 현재 피보나치 수열의 값을 계산하는 방법
				f2 = f1;
				f1 = f;
				f = f1 + f2;
				
			}
			System.out.print("합 : " + sum);
		}
		
		
		sc.close();

	}

}
 