package java0102;

public class DataType_3 {

	public static void main(String[] args) {
		// 변수 선언(정수형)
		byte b = 100;
		short s = 1000;
		int i = 10000;
		long l = 10L;
		// L은 형 명시(정수형은 L을 빼도 됨)
		
		// 변수 선언(문자형)
		char c = 'A';
		
		//변수 선언(실수형)
		float f = 3.14f;
		// f는 형 명시(f 없을 시 error 발생)
		double db = 5.15d;
		// d는 형 명시(d 없어도 문제 없음)
		
		// 변수 선언(boolean형)
		boolean bo = true;
		// true/false 대문자 작성->error
		
		System.out.println("b = " + b);
		System.out.println("s = " + s);
		System.out.println("i = " + i);
		System.out.println("c = " + c);
		System.out.println("f = " + f);
		System.out.println("db = " + db);
		System.out.println("bo = " + bo);
		
		// 강제 형 변환
		f = (float)1.5;
		// 실수는 기본적으로 double 형임
		System.out.println("f = " + f);
		f = (float)db;
		System.out.println("f = " + f);
		

	}

}
