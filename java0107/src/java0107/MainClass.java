package java0107;

public class MainClass {

	public static void main(String[] args) {
		// SampleClass의 인스턴스를 만들기
		// new SampleClass()가 인스턴스 생성 명령
		// 위의 구문은 수행을 하고 인스턴스의 참조를 return
		
		// 인스턴스를 재사용하려면 
		// 인스턴스의 참조를 동일한 자료형 변수에 대입해야 함
		SampleClass obj = new SampleClass();
		
		// final 변수는 생성과 동시에 값을 할당(값 변경 불가능)
		// final 변수이름은 모두 대분자로 작성하는 것이 관례
		final int TEN = 10;
		//TEN = 11; // Error
		
		// SampleClass의 인스턴스를 2개 생성
		SampleClass ob1 = new SampleClass();
		SampleClass ob2 = new SampleClass();
		
		// 인스턴스 변수에 값 대입
		ob1.name = "첫번째 인스턴스";
		ob2.name = "두번째 인스턴스";
		// static이 붙지 않은 멤버는 클래스를 호출할 수 없음
		//SampleClass.name // 없음, 호출 불가능

		// 인스턴스 변수 값 출력
		// : 인스턴스 변수는 각각 소유하기 때문에 서로 다른 값 출력
		System.out.println(ob1.name);
		System.out.println(ob2.name);
		
		// static 변수에 값 대입
		// : 클래스와 인스턴스 모두 접근 가능
		ob1.share = 100;
		SampleClass.share = 200;
		// static 변수는 하나만 만들어서 공유
		// 출력해 확인해 보면 동일한 값 나옴
		// 하나의 값을 공유하기 때문
		System.out.println(ob1.share);
		System.out.println(ob1.share);
		System.out.println(SampleClass.share);
		// 모두 200 출력
	}

}
