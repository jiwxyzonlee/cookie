package java0128;

public class MainThread {

	public static void main(String[] args) {
		// Runnable 인터페이스를 구현한 클래스를 이용해서 스레드 생성 및 실행
		// 인스턴스를 1개만 만들어서 사용한다면 메모리 낭비임
		// 클래스를 만들었기 때문에 클래스는 메모리에서 삭제가 안 됨
		Thread th1 = new Thread(new RunnableImpl());
		th1.start();
		
		// 클래스를 만들지 않고 사용 - anonymous class
		Thread th2 = new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					for (int i = 0; i < 10; i++) {
						Thread.sleep(1000);
						System.out.println("anonymouns class 이용");
					}
				} catch (Exception e) {
					System.out.println("예외 발생 : " + e.getMessage());
				}
				
			}
			
		});
		th2.start();
		
		// 람다 이용
		Thread th3 = new Thread(
			()->{
					try {
						for (int i = 0; i < 10; i++) {
							Thread.sleep(1000);
							System.out.println("람다 이용");
						}
					} catch (Exception e) {
						System.out.println("예외 발생 : " + e.getMessage());
					}
				}
		);
		th3.start();

	}

}
