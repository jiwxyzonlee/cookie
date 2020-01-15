package java0115;

import java.io.IOException;

public class ProcessExecute {

	public static void main(String[] args) {
		// Runtime 클래스의 인스턴스 2개 생성
		Runtime r1 = Runtime.getRuntime();
		Runtime r2 = Runtime.getRuntime();
		
		// HashCode 출력
		// HashCode 동일하게 출력
		// Runtime은 인스턴스를 1개만 만들 수 있는 클래스
		// 생성하는 메소드를 여러 번 호출해도 하나만 가지고 작업
		// : Singleton 패턴
		// 서버쪽은 대부분 Singleton (일관성 문제와 연관)
		System.out.println("r1 : " + System.identityHashCode(r1));
		System.out.println("r1 : " + System.identityHashCode(r2));
		
		// 메모장 실행 (큰따옴표 속 띄어쓰기 조심)
		try {
			r1.exec("notepad.exe "
					+ "C:\\Users\\admin\\Documents\\java\\200110\\0110.txt");
		} catch(IOException e) {
			e.printStackTrace();
		}

	}

}
