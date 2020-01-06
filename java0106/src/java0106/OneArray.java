package java0106;

public class OneArray {

	public static void main(String[] args) {
		// 초기 값을 가지고 문자열 배열 생성
		String [] strAr = {"발렌수엘라", "클레멘테", "루게릭"};
		
		// 데이터 1개 출력
		System.out.println(strAr);
		// [Ljava.lang.String;@15db9742 (참조형이라서)
		System.out.println(strAr[0]);
		
		// 데이터 전체 출력
		// 배열이름.length 는 배열의 데이터 개수를 정수로 리턴
		for(int i = 0; i < strAr.length; i = i + 1) {
			System.out.println(strAr[i]);
		}
		System.out.println("================");
		
		// 배열을 기본값으로 만들고 나중에 데이터로 채우기
		/*String [] homerunHitters = null;
		System.out.println(homerunHitters[0]);*/
		//참조형 변수가 생성된 것이지 데이터가 발생된 것은 아니라서
		//NullPointerException
		
		String [] homerunHitters = new String[3];
		//공간만 할당받은 배열에 데이터 채우기
		homerunHitters[0] = "김봉연";
		homerunHitters[1] = "이만수";
		homerunHitters[2] = "김성한";
		
		// ArrayIndexOutOfBoundsException 발생
		//homerunHitters[3] = "김성래";
		
		for(int i = 0; i < homerunHitters.length; i = i + 1) {
			System.out.println(homerunHitters[i]);
		}
		// 반복문 안에서 동일한 참조형 내부 데이터를 접근하는 것은 비효율적
		
		System.out.println("================");
		// 참조형 내부 데이터를 기본형으로 저장하고 반복문 안에서 기본형 데이터 접근
		// 두 번째 접근부터 메모리 접근 횟수가 줄음
		int len = homerunHitters.length;
		for(int i = 0; i < len; i = i + 1) {
			System.out.println(homerunHitters[i]);
		}
		System.out.println("================");
		// 빠른 열거를 이용한 접근
		// 데이터의 시작과 끝을 직접 작성하지 않기 때문에 Index오류를 일으키지 않게 됨
		for(String temp : homerunHitters) {
			System.out.println(temp);
		}
	}

}
 