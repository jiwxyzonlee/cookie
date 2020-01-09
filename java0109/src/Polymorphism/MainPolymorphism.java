package Polymorphism;

public class MainPolymorphism {

	public static void main(String[] args) {
		Starcraft star = new Terran();
		star.attack();
		
		star = new Zerg();
		star.attack();
		
		star = new Protoss();
		star.attack();
		
		// 키보드 a를 누르면 star.attack()이 호출되도록 연결

	}

}
