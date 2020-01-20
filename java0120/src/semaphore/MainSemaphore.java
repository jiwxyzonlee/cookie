package semaphore;

import java.util.concurrent.Semaphore;

public class MainSemaphore {

	public static void main(String[] args) {
		// 코어개수 확인
		System.out.println(Runtime.getRuntime().availableProcessors()); //12
		// 동시에 3개까지 실행되는 semaphore 생성
		Semaphore sem = new Semaphore(3);
		for (int i = 0 ; i < 20; i++) {
			ThreadEx th = new ThreadEx(sem);
			th.start(); // 20개 동시에 실행 & 종료
		}

	}

}
