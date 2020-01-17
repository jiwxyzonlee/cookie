package java0117;

// 하나의 파일에 클래스를 2개 만든다면
// public class는 1개이어야 하고 파일이름은 public class의 이름이어야 함

// Runnable 인터페이스를 implements한 클래스
class RunnableImpl implements Runnable {
	// 스레드를 수행할 내용을 가지는 메소드
	public void run() {
		
	}
}


public class Main2 {

	public static void main(String[] args) {
		RunnableImpl r1 = new RunnableImpl();
		
		// r1과 r2는 같은 기능
		Runnable r2 = new Runnable() {
			public void run() {
				// Hello Runnable을 1초마다 5번 출력
				try {
					for (int i = 0; i < 5; i++) {
						Thread.sleep(1000);
						System.out.println("Hello Runnable");
					}
				} catch (Exception e) {
					System.out.println("스레드 예외 : " + e.getMessage());
				}
			}
		}; // Runnable interface로 만든 것은 바로 수행 못함
		
		// Thread 클래스의 인스턴스 생성
		Thread th = new Thread(r2);
		// r2의 run 메소드를 스레드로 수행
		th.start();
		
		// 사실 하나만 돌리면 다른 작업도 함께 있는지 모름
		// Thread 확인을 위해 다른 작업도 생성
		Thread th1 = new Thread() {
			public void run() {
				// Hello Runnable을 1초마다 5번 출력
				try {
					for (int i = 0; i < 5; i++) {
						Thread.sleep(1000);
						System.out.println("Hello Runnable");
					}
				} catch (Exception e) {
					System.out.println("스레드 예외 : " + e.getMessage());
				}
			}
		};
		// Thread로부터 상속받은 경우 바로 start() 호출 가능
		th1.start();
		// 출력 구분되는 거 보고 싶으면 out->err 바꿔보기
		// Hello Runnable 두줄 씩 출력 (빨강이 위에 있는 이유랑 검은색이 두 번 나오는 이유는?)
		// err이 out보다 우선순위가 낮아서 같이 쓰는 경우 out이 먼저 나오는 경우가 있음

	}

}
