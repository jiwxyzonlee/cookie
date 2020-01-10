package AbstractClass;

public class MainPolymorphism {

	public static void main(String[] args) {
		Starcraft star = new Terran();
		star.attack();
		
		star = new Zerg();
		star.attack();
		
		star = new Protoss();
		star.attack();
		
		// Starcraft가 추상 클래스가 아니라면 인스턴스가 생성 가능
		// Starcraft는 상속관계를 만들기 위해서 생성한 클래스
		// 이 클래스는 작업을 할 클래스가 아님
		//star = new Starcraft();
		
		
		// 키보드 a를 누르면 star.attack()이 호출되도록 연결

	}

}
