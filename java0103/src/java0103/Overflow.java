package java0103;

public class Overflow {
	
	// Java 애플리케이션의 시작 메소드
	public static void main(String[] args) {
		/* short에 32767보다 큰 숫자는 아무 작업 없이는 저장 불가
		 * 강제 형 변환을 통해서만 저장 됨 
		 * 16 비트 앞쪽의 비트는 잘리게 됨 <- Overflow
		 * 가장 작은 숫자부터 다시 시작 <- 음수가 저장 
		 * 반대 되는 현상은 Underflow 라고 칭함 */
		short s = (short)32768;
		
		// 저장된 데이터 출력
		System.out.println("s : " + s);
		
		// s : -32768

	}

} 
