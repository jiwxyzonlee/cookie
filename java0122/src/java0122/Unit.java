package java0122;

import java.io.Serializable;

public class Unit implements Serializable{
	/**
	 * 
	 */ // Add default serial version ID
	private static final long serialVersionUID = 1L;
	private int num;
	private String name;
	private int offense;
	private int defense;
	private int level;
	
	// Generate Constructors from Superclass
	// 매개변수가 없는 생성자
	// 기본 데이터가 제공되지 않을 때 사용
	public Unit() {
		super();
		// TODO Auto-generated constructor stub
	}

	// Generate Constructor using Fields
	// 모든 속성을 매개변수로 받아서 생성해주는 생성자
	// 기본 데이터가 제공될 때 사용(테스트할 때 좋음)
	public Unit(int num, String name, int offense, int defense, int level) {
		super();
		this.num = num;
		this.name = name;
		this.offense = offense;
		this.defense = defense;
		this.level = level;
	}

	// 접근자 메소드
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

	public int getOffense() {
		return offense;
	}

	public void setOffense(int offense) {
		this.offense = offense;
	}

	public int getDefense() {
		return defense;
	}

	public void setDefense(int defense) {
		this.defense = defense;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
		// level이 변경 때 offense 값이 자동으로 다시 계산됨
		offense = offense + level * 10;
	}

	// 모든 속성의 값을 하나의 문자열로 만들어서 리턴해주는 메소드
	// 출력하는 메소드에 인스턴스 이름을 대입하면 이 메소드가 호출됨
	// 모든 객체 지향언어는 이 방식을 이용해서 출력함
	// 메소드 이름이 다를 뿐(파이썬만 __str__)
	@Override
	public String toString() {
		return "Unit [num=" + num + ", name=" + name + 
				", offense=" + offense + ", defense=" + defense + ", level="
				+ level + "]";
	}

}
