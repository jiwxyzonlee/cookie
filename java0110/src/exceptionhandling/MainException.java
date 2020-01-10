package exceptionhandling;

public class MainException {

	public static void main(String[] args) {
		int [] ar = {100, 200};
		System.out.println("예외처리의 목적");
		try {
			System.out.println(ar[2]); //예외 발생
		} catch(Exception e) {
			System.err.println(e.getMessage() + "발생");
		} finally {
			System.out.println("예외처리의 목적 중 하나는"
				+ "예외가 발생하더라도 계속 작업을 수행하기"
				+ "위해서입니다");
		}
		
	}

}
