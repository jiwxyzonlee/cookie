package Construct;

public class Main {

	public static void main(String[] args) {
		// Member 클래스의 인스턴스 생성

		// 자바 개발자의 대부분은 인스턴스를 1개만 만드는 경우
		//클래스 이름의 첫글자만
		// 소문자로 변환해서 이름을 생성
		// 자바 개발 시 인스턴스를 자동으로 생성해주는 
		//스프링 프레임워크를 많이 사용하며
		// 스프링이 이름을 만들 때 이 규칙을 적용함
		
		// 인스턴스가 많을 경우 이런식으로 해도 무방
		Member mem1 = new Member();		
		// mem1.setId("root");
		// mem1.setPw("1234");
		
		System.out.println("id : " + mem1.getId() + "\npw : " + mem1.getPw());
		
		Member mem2 = new Member();		
		// mem2.setId("root");
		// mem2.setPw("1234");
		// Member 클래스에서 미리 설정하였기 때문에
		//메소드 설정이 필요 없어짐
		
		System.out.println("id : " + mem2.getId() + "\npw : " + mem2.getPw());
		
		// 생성자에 두 개의 데이터를 대입해서 인스턴스 생성
		Member mem3 = new Member("admin", "1000");
		System.out.println("id : " + mem3.getId() + "\npw : " + mem3.getPw());
		
		/*
		// Member 클래스에 인스턴스 배열 생성
		// Member 인스턴스의 참조를 저장할 수 있는 공간 5개 생성
		Member [] ar = new Member[5];
		for (Member imsi : ar) {
			System.out.println(imsi); // null 로 다섯줄 출력(안 만들어짐)
		}
		*/
		
		// Member 클래스에 인스턴스 배열 생성
		// Member 인스턴스의 참조를 저장할 수 있는 공간 5개 생성
		Member [] ar = new Member[5];
		
		// 공간에 인스턴스 생성해서 대입
		ar[0] = new Member();
		ar[1] = new Member();
		
		for (Member imsi : ar) {
			System.out.println(imsi);
		}
		
		// 인스턴스 한 개 생성, 내부 데이터 설정
		Member origin = new Member();
		origin.setId("googleblogger");
		origin.setPw("100100100");
		
		// 참조형 사이의 대입
		// origin이 가리키고 있는 인스턴스 weak도 가리키게 됨
		// 동일한 인스턴스를 가리킴
		Member weak = origin;
		
		// weak가 id를 변경했으므로 origin도 변경됨
		weak.setId("bloggergoogle");
		System.out.println(weak.getId());
		System.out.println(origin.getId());
		
		
		System.out.println("======");
		// origin 을 복제해서 대입
		// 현재는 내용이 같음
		Member deep = origin.clone();
		System.out.println(deep.getId());
		System.out.println(deep.getPw());
		// 복사를 해서 deep에 대입했기 때문에 변경하기 전에는 내용이 같지만
		// 한쪽에서 내용을 변경해도 다른 쪽에는 영향이 없기 때문에
		// deep의 내용을 변경해도 origin은 그대로
		System.out.println("=======");
		deep.setId("choongang");
		System.out.println(deep.getId());
		System.out.println(origin.getId());
		
	}

}
