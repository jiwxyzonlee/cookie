package java0103;

public class Inc {

	public static void main(String[] args) {
		
		int a = 10;
		
		// a의 값 증가
		a++;

		System.out.println("a : " + a);  
		// 11출력
		
		System.out.println("a : " + (a++));  
		// 11 출력(11-> 12 -> 계산 이전 출력 - 출력 명령 후 계산)
		
		// a를 먼저 증가시켜서 13을 만들고 명령 사용
		System.out.println("a : " + (++a));

		a = 0;
		int result = ++a + ++a;
		System.out.println("result : " + result); 
		// 3 출력( = 1+2)

	}

}
 