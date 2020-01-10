package interfaceUse;

public class MainUse {

	public static void main(String[] args) {
		// ISampleImpl 클래스에 있는 disp 라는 메소드 호출
		// ISampleImpl sample = new ISampleImpl();
		
		// 변수 생성시 인터페이스 이름 사용가능
		// 대입되는 인스턴스는
		// 반드시 인터페이스 implements 한 클래스의 인스턴스여야 함
		ISample sample = new ISampleImpl();
		sample.disp();
		
		// 관습적으로 변수를 만들 때는 구현된 클래스가 아닌 인터페이스 이름 사용
		UserService userService = new UserServiceImpl();
		userService.disp();

	}

}
