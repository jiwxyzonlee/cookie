package java0117;

public class ThreadMain {

	public static void main(String[] args) {
		// ThreadEx 인스턴스 2개를 생성
		ThreadEx th1 = new ThreadEx();
		ThreadEx th2 = new ThreadEx();
		
		// 일반적인 메소드 호출
		// 하나의 메소드 수행이 종료되고 나서야 다른 메소드를 수행
		/*th1.run(); // 1초마다 Hello World 출력
		th2.run();*/
		
		// 스레드로 실행
		// 하나의 스레드가 쉬는시간이 생기면 다른 스레드의 작업을 처리
		th1.start(); // Hello World 두줄 씩 출력되는 모습
		th2.start(); // 사실 동시에 되는 건 아님

	}

}
