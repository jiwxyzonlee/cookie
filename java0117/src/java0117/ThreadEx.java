package java0117;

public class ThreadEx extends Thread {
	public void run() {
		// 1초마다 Hello Thread 라는 문자열을 10번 출력
		for (int i = 0; i < 10; i++) {
			System.out.println("Hello Thread");
			try {
				// 스레드 1초 대기
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// Thread.sleep(초*1000)은 예외 처리를 하지 않으면 실행할 수 없음
				e.printStackTrace();
			} 
		}
	}

}
