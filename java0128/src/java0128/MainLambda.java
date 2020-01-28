package java0128;

import java.util.function.Consumer;
import java.util.function.Function;

// 매개변수가 없고 리턴타입이 없는 메소드를 소유한 인터페이스
interface NoArgNoReturn {
	public void method1();
}

// 매개변수가 있지만 리턴타입이 없는 경우
// 예) 원본에 작업을 해서 원본을 변환시키는 인터페이스(원본 자체 변화)
interface ArgNoReturn {
	public void method2(int x);
}

// 매개변수는 없고 리턴타입만 있는 경우 (드묾)
interface NoArgReturn {
	public double method3();
}

// 매개변수가 있고 리턴타입이 있는 경우 (가장 많음)
interface ArgReturn {
	public int method4(String str);
}

public class MainLambda {

	public static void main(String[] args) {
		// 매개변수가 없고 리턴도 없는 인터페이서 활용
		NoArgNoReturn ob1 = () -> {System.out.println("매개변수가 없고 리턴도 없는 람다");};
		ob1.method1();
		
		// 매개변수가 있는 경우
		ArgNoReturn ob2 = (int x) -> {System.out.println(x + 10);};
		//ArgNoREturn ob2 = (x) -> {}; // 자료형 생략 가능
		//ArgNoREturn ob2 = x -> {}; // 매개변수 하나인 경우 (소괄호) 생략 가능
		ob2.method2(100); // 110 출력
		
		// 매개변수는 없고 리턴만 있는 경우 (드문 케이스)
		NoArgReturn ob3 = () -> {return 10.3;};
		double d = ob3.method3();
		System.out.println(d); // 10.3 출력
		
		// 매개변수가 있고 리턴이 있는 경우 (데이터를 가공해서 리턴하는 함수)
		ArgReturn ob4 = (str) -> {return Integer.parseInt(str);};
		int i = ob4.method4("123219");
		System.out.println(i);
		
		// Consumer 인터페이스는 매개변수가 1개이고 리턴타입이 없는 메소드를 소유
		Consumer <String> consumer = (t) -> {System.out.println(t);};
		consumer.accept("Java Lambda");
		
		// Function 인터페이스는 매개변수가 1개이고 리턴타입이 있는 메소드를 소유
		// 제너릭에서 앞의 자료형은 매개변수의 자료형이고 뒤의 자료형은 리턴타입의 자료형
		// 데이터를 받아서 변환한 후 리턴해주는 메소드
		Function <String, String> function = (str) -> {
			if(str.length() <= 3) return str;
			else return str. substring(0, 3) + "..."; };
		String r = function.apply("hi");
		System.out.println(r);
		r = function.apply("Hello World");
		System.out.println(r); // Hel... 출력

	}

}
