package java0103;

import java.util.Scanner;

public class Condition2 {

	public static void main(String[] args) {
		// 키보드로부터 입력받기 위한 객체 생성
		Scanner sc = new Scanner(System.in);
		// 점수 입력 받기
		System.out.print("ENTER YOUR SCORE: ");
		int score = sc.nextInt();
		
		// 점수가 60점 이상이면 합격
		if (score >= 60) {
			System.out.println("PASS");
		}
		// 점수가 60점 미만 시 낙제
		else {
			System.out.println("FAIL");
		}
		sc.close();

	}
 
}
