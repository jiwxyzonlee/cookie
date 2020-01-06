package java0103;

public class LiteralSave {

	public static void main(String[] args) {
		// 3개의 정수 저장 변수 생성(2개는 동일 값, 1개는 다른 값)
		int a = 10;
		int b = 10;
		int c = 11;
		
		System.out.println("a : " + System.identityHashCode(a));
		System.out.println("b : " + System.identityHashCode(b));
		System.out.println("c : " + System.identityHashCode(c));
		// a와 b는 동일한 데이터를 저장했으므로 해시코드 동일
		// c는 다른 데이터를 저장했으므로 해시코드 상이

	}

}
 