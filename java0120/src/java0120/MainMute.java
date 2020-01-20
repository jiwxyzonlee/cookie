package java0120;

public class MainMute {

	public static void main(String[] args) {
		//Runnable 인터페이스를 implements 한 클래스의 인스턴스 생성
		ThreadImpl threadImpl = new ThreadImpl();
		
		// Thread 클래스의 생성자에 대입해서 Thread 인스턴스 생성
		Thread th1 = new Thread(threadImpl);
		Thread th2 = new Thread(threadImpl);
		
		// 스레드 시작
		th1.start();
		th2.start();
		
		/*
		// 주의
		// 스레드는 비동기 th.start(); 동작 중 쉬는 시간에 아래 구문 실행됨
		System.out.println(threadImpl.getResult());*/
		
		try {
			Thread.sleep(30000);
			System.out.println(threadImpl.getResult());
		} catch (Exception e) {}
		

	}

}
