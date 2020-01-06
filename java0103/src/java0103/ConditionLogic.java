package java0103;

public class ConditionLogic {

	public static void main(String[] args) {
		int a = 10;
		int b = 10;
		// a> 5 true && a++ > 10 false
		boolean result = a > 5 && (a++ > 10);
		System.out.println("결과 : " + result);
		System.out.println("a : " + a);
		// false지만 a = 11 출력
		
		// a < 5 false
		result = a < 5 && (a++ > 10);
		System.out.println("결과 : " + result);
		// 앞의 문장이 거짓이어서 a 증가 안함(a++ 수행x)
		System.out.println("a : " + a);
		// 11 출력

	}

}
 