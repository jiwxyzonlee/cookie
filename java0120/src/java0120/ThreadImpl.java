package java0120;

// Runnable : 스레드를 동작할 수 있도록 해주는 인터페이스
public class ThreadImpl implements Runnable {
	// 인덱스 변수와 합계를 저장할 변수
	private int idx;
	private int result;
	
	// result를 리턴하는 메소드
	public int getResult() {
		return result;
	}
	
	// idx 값을 1씩 증가시키면서 result에 추가하는 메소드
	// 10000번 수행하는 메소드
	// 메소드 앞에 synchronized를 붙이면
	// 멀티 스레드 환경이더라도 이 메소드의 수행이 종료될 때까지 다른 작업 수행 불가
	private void sum() {
		for (int i = 0; i < 10000; i++) {
			// 이 블럭 안에서 this(자기 자신)의 요소를 사용하는 부분을 동기화
			synchronized(this) {
			idx = idx + 1;
			try {
				Thread.sleep(1);
			}catch (Exception e) {}
			result = result + idx;
			}
		}
	}

	// 스레드로 동작할 내용을 작성하는 메소드
	@Override
	public void run() {
		sum();

	}

}
