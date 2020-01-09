package inheritance;

public class Based {
	private int num;
	// 자신의 클래스 내 메소드 안에서만 사용 가능
	// "빨강" 네모
	
	String title;
	// 접근 지정자를 설정하지 않는 것을 default 또는 package
	// 클래스 내부 메소드에서 사용가능하고 
	
	//동일한 package 내에 있으면 
	// public처럼 상속받은 클래스, 인스턴스가 사용가능
	
	protected String content;
	// default 다른 패키지에서도 상속받은 클래스에서는 사용가능
	
	public int readcnt;
	// 자신의 클래스, 상속받은 클래스, 인스턴스가 사용 가능
	// "녹색" 동그라미
	
	public void print() {
		System.out.println("Super Class print out");
	}
	
	// 정수 1개를 가지고 인스턴스를 생성하는 생성자
	// 생성자를 만들면 public Based()는 소멸됨
	public Based(int x) {
		num = x;  // Derived Class에서 Error
		//Derived의 super() 는  new Based()
	}

}
