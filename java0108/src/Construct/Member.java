package Construct;

public class Member {
	private String id;
	private String pw;
	// static{}는 클래스를 처음 사용할 때 1번만 호출
	// 게임에서 로고 보여줄 때
	
	// 클래스 안에 {중괄호}를 만들고 내용작성시
	// 생성자 호출할 때마다 생성자보다 먼저 호출, 내용 수행
	// 스테이지마다 나와야 하는 내용
	{
		System.out.println("객체를 생성합니다");
	}
	
	// Member 클래스의 생성
	// 생성자는 return type 없이 클래스 이름을 그대로 사용
	// 매개 변수가 없는 생성자를 *Default Constructor*라고 함
	public Member() {
		id = "root";
		pw = "1234";
	}
	
	// 매개 변수가 두 개인 생성자
	// (두 개의 문자열을 받아 id와 pw에 대입)
	public Member(String id, String pw) {
		this.id = id;
		this.pw = pw;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	
	
	
	// 인스턴스를 복제해주는 메소드
	public Member clone() {
		//인스턴스 생성
		Member other = new Member();
		// 데이터를 복제
		// 원래 참조형 데이터도 clone해줘야지만 String은 예외
		other.id = this.id;
		other.pw = this.pw;
		
		//복제된 데이터를 갖는 객체를 return
		return other;
	}

}
