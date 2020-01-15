package java0115;

public class StringTest {

	public static void main(String[] args) {
		String str = "Hello";
		str.toLowerCase();
		// String은 자신의 데이터를 수정할 일이 없기 때문에
		// 메소드를 호출하거나 '+'(더하기) 연산하여 결과를 리턴
		// 원본에는 변화가 생기지 않음
		
		String result = str + "Java";
		str.toUpperCase();
		System.out.println(str);
		
		// 문자열을 Heap에 저장해서
		// 내용을 변경할 수 있는 클래스의 인스턴스 생성
		StringBuilder sb = new StringBuilder("Hello");
		
		// HashCode 출력
		System.out.println(System.identityHashCode(sb));
		
		// 기존 내용에 Java를 이어붙임
		sb.append("Java");
		System.out.println(sb);
		
		// HashCode 출력
		// : 이전 것과 동일, 현재의 영역에서 작업을 수행
		System.out.println(System.identityHashCode(sb));

	}

}
