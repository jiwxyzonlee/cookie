package java0114;

import java.util.Scanner;

public class MainDTO {

	public static void main(String[] args) {
		// DTO 클래스의 인스턴스를 만들고 내용을 채운 후 출력
		DTO dto1 = new DTO();
		dto1.setNum(1);
		dto1.setName("김정화");
		// 출력 - 인스턴스 이름을 출력하는 메소드에 대입하면
		// toString()을 호출한 결과가 출력
		System.out.println(dto1);
		
		DTO dto2 = new DTO();
		dto2.setNum(1);
		dto2.setName("김화정");
		System.out.println(dto2);
		
		// 참조 비교
		System.out.println(dto1 == dto2);
		// 내용 비교
		System.out.println(dto1.equals(dto2));
		
		// 참조를 복사 - 하나의 변경이 다른 것에도 영향을 줌
		DTO dto3 = dto1;
		dto3.setNum(2);
		System.out.println(dto1);
		
		// 내용을 복제 - 하나의 변경이 다른 것에 영향을 주지 않음
		DTO dto4 = dto1.clone();
		dto4.setNum(3);
		System.out.println(dto1);

	}

}
