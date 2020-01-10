package AbstractClass;

// abstract를 붙이면 추상클래스가 되어 이 클래스 생성자 호출시 에러
// 내용이 아무것도 없으므로 클래스보단 인터페이스로 존재하는 게 나음
public interface Starcraft {
	// 하위 클래스의 인스턴스가 
	//attack을 호출할 수 있도록 오버라이딩을 위한 메소드
	// abstract를 붙이면 추상 메소드가 됨
	// 이 메소드는 내용이 없음
	
	// 이 메소드를 소유한 클래스나 
	// 인터페이스를 상속하거나 구현할 클래스에서는
	// 반드시 이 메소드를 재정의 해주어야 함
	public abstract void attack(); 

}
