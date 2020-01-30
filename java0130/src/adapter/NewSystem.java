package adapter;

public class NewSystem extends OldSystem implements Target {

	@Override
	public void process() {
		// 구현된 메소드의 오버라이딩
		// 상위 클래스의 메소드를 호출하고 기능을 추가
		/*
		super.process();
		System.out.println("기능 추가");
		*/
		
		System.out.println("새로운 기능");
	}

	@Override
	public void legacyProcess() {
		super.process();
		
	}

}
