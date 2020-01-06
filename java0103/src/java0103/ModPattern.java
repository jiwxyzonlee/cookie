package java0103;

public class ModPattern {

	public static void main(String[] args) {
		// 오미크론 두 배 출력
		int i = 0;
		for (;;) {
			try {  // try click하면 catch 자동생성
				i = i % 3;
				if(i == 0)
					System.out.println("라투");
				else if(i == 1)
					System.out.println("오미크론");
				else if(i == 2)
					System.out.println("다크스펙터");
				else
					System.out.println("오미크론");
				Thread.sleep(1000);
				i++;
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		

	}

}
 