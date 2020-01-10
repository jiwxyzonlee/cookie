package interfaceUse;

// ISample 이라는 인터페이스를 구현한 클래스
public class ISampleImpl implements ISample {

	@Override
	public void disp() {
		System.out.println("TODAY");
		// 수정은 안 됨(인터페이스의 변수는 무조건 상수)
		// T0DAY = "2020-01-11"; //Error

	}

}
