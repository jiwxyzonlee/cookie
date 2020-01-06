package java0103;

public class Shift {

	public static void main(String[] args) {
		int n = 10;
		// 오른쪽으로 2만큼 밀면 나누기 4한 효과 - 2 출력
		System.out.println("n >> 2 : " + (n>>2));
		
		// 32번 이상 밀면 모든 비트가 소멸된 효과
		// 32번 이상 shift시 32로 나눈 나머지만큼 shift - 2번만 shift
		System.out.println("n >> 34 : " + (n>>34));

	}

}
 