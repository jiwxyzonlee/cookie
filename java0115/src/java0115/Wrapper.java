package java0115;

import java.math.BigDecimal;

public class Wrapper {

	public static void main(String[] args) {
		// 기본형 정수 데이터를 참조형 Integer로 생성
		Integer i = new Integer(100);
		i = 300; // AutoBoxing
		// : 기본형데이터를 참조형으로 자동 변환해주는 문법
		
		// 기본형을 참조형으로 표현할 수 있기 때문에 
		// Object 클래스의 변수에는 모든 데이터 대입가능
		Object obj = 300;
		// obj 에는 Integer를 저장하기는 했지만 변수 자료형이 Object여서
		// Object 것만 사용 가능
		// 원래 자료형에 있던 intValue() 사용 불가능
		
		// 원래 자료형에 있던 것들을 사용하려면 강제로 형 변환해야 함
		System.out.println(((Integer)obj).intValue());
		
		// 실수 연산 문제점 발생: 1.7000000000000002
		double d1 = 1.600000000000000000000000000000;
		double d2 = 0.100000000000000000000000000000;
		System.out.println(d1+d2);
		
		BigDecimal b1 = new BigDecimal("1.600000000000000000000000000000");
		BigDecimal b2 = new BigDecimal("0.100000000000000000000000000000");
		// import java.math.BigDecimal; 필요
		System.out.println(b1.add(b2));
		// 1.700000000000000000000000000000 출력
		// 프로그래밍 언어와 데이터베이스를 연동하는 경우
		// 대부분의 경우 데이터베이스가 정밀한 숫자를 저장하는 경우가 많음
		// 데이터베이스에 실수를 저장했을 때는 float이나 double로 받는 것보다는
		// BigDecimal 같은 클래스를 이용해서 저장하고 연산한 후
		// 결과를 float이나 double로 표현하는 것이 좋음 
		
		// 운영체제 버전과 자바버전을 확인
		System.out.println(System.getProperty("os.name"));
		System.out.println(System.getProperty("java.version"));

	}

}
