package java0117;

public class MainDaemon {

	public static void main(String[] args) {
		
		Thread th = new Thread() {
			public void run() {
				try {
					for (int i = 0; i < 10; i++) {
						Thread.sleep(1000);
						System.out.println("데몬 스레드");
					}
				} catch (Exception e) {
					
				}
			}
		};
		// th를 데몬으로 설정
		// 다른 작업이 없으면 자동으로 종료되도록 함
		// 프로그램에서는 데몬 스레드가 더 많이 사용됨
		th.setDaemon(true);
		
		// 메인이 종료되어도 "데몬 스레드" 출력 계속 실행
		th.start(); 
		// th.setDaemon(true);
		// start 뒤에 놓으면 Daemon의도대로 실행되지 않음
		
		try {
			Thread.sleep(3000); // 3초 만에 메인 종료
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		System.out.println("메인 종료");

	}

}
