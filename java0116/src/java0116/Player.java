package java0116;

// 선수번호(Integer & Primary Key), 선수이름, 타율
// Primary Key는 정수인 게 좋음
public class Player {
	private int num;
	private String name;
	private double hitrate;
	
	// Generate Constructors from Superclass 
	// 매개변수가 없는 생성자
	public Player() {
		super();
	}
	
	// Generate Constructor using fields
	// 모든 필드를 매개변수로 받아서 인스턴스 필드에 대입해주는 생성자
	public Player(int num, String name, double hitrate) {
		super();
		this.num = num;
		this.name = name;
		this.hitrate = hitrate;
	}
	
	// Generate Getters and Setters
	// 인스턴스 필드들은 private으로 만들었기 때문에 인스턴스가 접근 불가능
	// 인스턴스가 필드에 접근할 수 있도록 해주는 메소드
	// : Getters and Setters

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

	public double getHitrate() {
		return hitrate;
	}

	public void setHitrate(double hitrate) {
		this.hitrate = hitrate;
	}

	// Generate toString()
	// 필드의 값을 빠르게 확인하기 위한 메소드
	// : 디버깅을 위한 메소드
	@Override
	public String toString() {
		return "Player [num=" + num + ", name=" + name + 
				", hitrate=" + hitrate + "]";
	}

}
