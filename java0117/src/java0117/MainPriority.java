package java0117;

// class를 만드는 경우 대부분 인스턴스를 두 개 이상 만다는 경우
class Threadext extends Thread {
	public void run() {
		// 스레드 자신의 이름을10번 출력(1초마다 쉬면서)
		for(int i = 0; i <10; i ++) {
			try {
				Thread.sleep(1000);
				System.out.println(getName());
			}
			// InterruptedException이 발생했을 때 return하도록 만들어주면
			// 스레드가 강제로 종료될 수 있음
			catch (InterruptedException e) {
				return;
				
			}
 		}
	}
	
}

public class MainPriority {

	public static void main(String[] args) {
		Threadext th1 = new Threadext();
		Threadext th2 = new Threadext();
		Threadext th3 = new Threadext();
		
		// 스레드의 우선 순위 설정
		th1.setPriority(Thread.MIN_PRIORITY);
		th2.setPriority(Thread.NORM_PRIORITY);
		th3.setPriority(Thread.MAX_PRIORITY);
		
		th1.start();
		th2.start();
		th3.start();
		
		try {
			Thread.sleep(3000);
			// th2 스레드에게 인터럽트 시도(발생)
			th2.interrupt(); // 3초 뒤 1 안 나옴 (위에 return 있어야 함)
		} catch (Exception e) {}

	}

}
