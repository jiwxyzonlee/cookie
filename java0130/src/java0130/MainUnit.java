package java0130;

import java.util.ArrayList;
import java.util.List;

public class MainUnit {

	public static void main(String[] args) {
		// 템플릿 메소드 패턴이 적용된 클래스의 인스턴스 만들기
		UnitImpl unitImpl = new UnitImpl();
		unitImpl.attack();
		unitImpl.move();
		// (이제껏 해왔던 방식임)
		
		// 변수는 인터페이스 이름을 사용하고 생성자는 클래스이름을 이용함
		Unit unit = new UnitImpl();
		unit.attack();
		unit.move();
		
		// 예)
		//List<String> list = new ArrayList<String>();

	}

}
