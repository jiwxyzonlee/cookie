package java0115;

public class MainGenerics {

	public static void main(String[] args) {
		// 미지정 자료형 1개를 갖는 클래스의 인스턴스 만들기
		Integer [] ar = {100, 200, 300};
		
		// 클래스를 만들 때 사용한 E가 Integer로 치환되어 동작
		Generics <Integer> obj1 = new Generics<Integer>(ar);
		// Generics는 int 사용 불가
		
		// 메소드 호출
		obj1.disp();
		
		System.out.println();
		
		String [] br = {"안나", "엘사"};
		// 클래스를 만들 때 사용한 E가 String으로 치환되어 동작
		Generics <String> obj2 = new Generics<String>(br);
		obj2.disp();

	}

}
