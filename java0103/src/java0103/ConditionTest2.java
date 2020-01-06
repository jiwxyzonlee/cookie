package java0103;

public class ConditionTest2 {

	public static void main(String[] args) {
		int x = 10;
		// x가 4의 배수인지 판별
		boolean result = x % 4 == 0;
		System.out.println("result : " + result);
		// false
		
		// 윤년인지 판별
		// 윤년은 4의 배수이고 100의 배수가 아닌 경우
		// 혹은 윤년은 400의 배수인 경우
		int year = 2020;
		result = year %4 == 0 && year % 100 != 0 || year % 400 == 0;
		System.out.println("result : " + result);
		// true

	}

} 
