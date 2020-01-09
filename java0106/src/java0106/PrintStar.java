package java0106;

public class PrintStar {

	public static void main(String[] args) {
		// 반복문 2개를 이용하여 별 다섯 개씩 다섯 줄 출력
		for (int i = 0; i < 5; i = i + 1) {
			for (int j = 0; j < 5 - i; j = j + 1) {
				System.out.print("*"); // println 하면 안됨!
			}
			System.out.print("\n"); // println 하면 안됨!
		}
	}

}
 