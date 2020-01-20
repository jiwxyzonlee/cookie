package consumer;

public class Producer extends Thread {
	private Product product;
	
	// 외부에서 인스턴스를 주입받아 객체를 생성하는 생성자
	public Producer(Product product) {
		this.product = product;
	}
	
	// 스레드로 동작하는 메소드
	public void run() { // i = i + 1 에러날 수도 있음
		for(char i = 'A'; i <= 'Z'; i++) {
			product.put(i);
		}
	}

}
