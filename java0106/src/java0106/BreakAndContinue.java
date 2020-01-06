package java0106;

public class BreakAndContinue {

	public static void main(String[] args) {
		// 1부터 10까지 출력
		for(int i = 1; i < 11; i = i + 1) {
			// 4의 배수가 될 시 반복문 중단
			if( i % 4 == 0) {
				break;
			}
			System.out.println("i : " + i);
		}

		System.out.println("===================");
		// 1부터 10까지 출력
		for(int i = 1; i < 11; i = i + 1) {
			// 4의 배수가 될 시 다음 반복으로 이동
			//1, 2, 3, 5, 6, 7, 9, 10 (4빼고 출력)
			if( i % 4 == 0) {
				continue;
			}
			System.out.println("i : " + i);
		}

	}

}
 