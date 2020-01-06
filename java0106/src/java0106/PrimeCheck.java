package java0106;

import java.util.Scanner;

public class PrimeCheck {

	public static void main(String[] args) {
		// 하나의 정수 입력받기
		Scanner sc = new Scanner(System.in);
		System.out.println("소수 판별 정수 입력: ");
		int su = sc.nextInt();
		
		//소수 판별을 위한 flag 변수 생성
		boolean flag = false;
		
		// 소수 판별 반복문
		for (int i = 2; i <= su/2; i = i + 1) {
			// 이 경우는 소수가 아님
			if (su % i == 0) {
				flag = true;
				break;
			}
		}
		
		//su가 소수인지 출력
		if(flag == false) {
			System.out.println(su + "는 소수");
		}else {
			System.out.println(su + "는 소수가 아님");
		}
		sc.close();

	}

}
 