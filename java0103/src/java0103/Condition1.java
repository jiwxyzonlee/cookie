package java0103;

import java.util.Scanner;

public class Condition1 {

	public static void main(String[] args) {
		// 키보드로부터 입력받기 위한 객체 생성
		Scanner sc = new Scanner(System.in);
		// 점수 입력 받기
		System.out.print("ENTER YOUR SCORE: ");
		int score = sc.nextInt();
		
		// 점수가 90점 이상, 100이하 이면 A
		if (score >= 90 && score <= 100) {
			System.out.println("A");
		}
		// 점수가 80점 이상 90점 미만이면 B
		else if (score >= 80 && score < 90) {
			System.out.println("B");
		}
		// 점수가 70점 이상 60점 미만이면 C
		else if (score >= 70 && score < 80) {
			System.out.println("C");
		}
		// 점수가 60점 이상 70점 미만이면 D
		else if (score >= 60 && score < 70) {
			System.out.println("D");
		}
		// 점수가 60점  미만이면 F
		else if (score < 60) {
			System.out.println("F");
		}
		// 이외
		else {
			System.out.println("START AGAIN");
		}
		// else는 조건 처리문이 아닌 예외적인 발생에 대한 처리를 해주는 것이 유용
		sc.close();

	}

}
 