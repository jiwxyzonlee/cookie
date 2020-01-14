package java0114;

public class Main2 {

	public static void main(String[] args) {
		int i = 0;
		while(i<10) {
			System.out.println("Hello Exception");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			i ++;
		}

	}

}
