package java0114;

// 여러 개의 속성을 묶어서 표현하기 위한 클래스는 속성의 값을 빠르게 확인하기 위해서(디버깅)
// toString을 오버라이딩 함
public class DTO {
	// 속성은 private으로 만들고 접근자 메소드를 public으로 선언해서 사용
	private int num;
	private String name;
	
	// Generate getters and setters
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	// 인스턴스의 내용을 비교하는 메소드
	public boolean equals(DTO other) {
		// 내용 비교
		if(this.num == other.num && this.name.contentEquals(other.name)) {
			return true;
		}else {
			return false;
		}
	}
	
	// 인스턴스의 내용을 복사해서 리턴해주는 메소드
	public DTO clone() {
		// 새로운 인스턴스 생성
		DTO other= new DTO();
		// 기존 인스턴스의 내용 복제
		// this 생략 가능
		// (기존의 인스턴스 내용이라는 것을 강조하기 위해 this 붙임)
		other.setNum(this.num);
		other.setName(this.name);
		return other;
	}
	
	@Override
	public String toString() {
		return "DTO [num=" + num + ", name=" + name + "]";
	}
	
// [source] - [toString] 알아서 만들어줌
	
}
