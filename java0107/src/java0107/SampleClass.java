package java0107;

// 메인 메소드가 없는 클래스
// : 실행할 수 없는 보조적인 역할만 수행
public class SampleClass {

	// static 변수
	// : 클래스로 접근 가능하고 인스턴스로도 접근 가능
	// 모든 인스턴스 공유
	static int share = 1;
	
	// 인스턴스 변수(멤버 변수)
	// : 인스턴스만 접근 가능하며 인스턴스마다 별도로 소유
	String name; 
	
	// static 초기화 블럭
	static {
		System.out.println("클래스가 처음 호출될 때 1번만 수행");
		//SampleClass obj = new SampleClass(); <- (main에서)이때
	}
	
}
