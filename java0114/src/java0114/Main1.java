package java0114;

public class Main1 {

	public static void main(String[] args) {
		try {
			int [] ar = {100, 300};
			System.out.println(ar[2]); //ArrayIndexOurOfBoundsException 발생
		}
		// Exception 클래스가 ArrayINdexOutOfBoundsException의 상위 클래스라서
		// 예외가 발생하면 Exception이 처리
		// 맨 아래 catch구문은 도달할 수 없는 코드가 됨
		/* catch(Exception e) {
			System.out.println(e.getMessage());
		}*/
		catch(ArrayIndexOutOfBoundsException e) { //error
			System.out.println("예외가 발생했습니다");
			// 예외 메시지 내용을 출력
			System.err.println(e.getMessage());
		}
		
	}

}
