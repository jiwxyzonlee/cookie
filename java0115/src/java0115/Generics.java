package java0115;

// Generics를 적용한 클래스
public class Generics <E> {
	// 미지정 자료형 배열 E
	private E [] data;
	
	// 생성자
	public Generics(E [] data) {
		this.data = data;
	}
	
	// 메소드
	public void disp() {
		for(E temp : data) {
			System.out.print(temp + "\t");
		}
		System.out.println();
	}
}
