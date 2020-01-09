package inheritance;

// Based 클래스를 상속받은 Derived 클래스
public class Derived extends Based {
	// 상위 클래스의 default constructor가 없는 경우에
	// 생성자를 만들고 super를 이용해서 상위 클래스의 생성자 호출
	// 프레임워크를 사용하면 상위 클래스를 우리가 수정할 수 없음
	// 따라서 하위 클래스에서 해결해야 함
	// 안드로이드에서 많이 사용되는 코드 방식
	// (Android Native App 개발을 위한 Java Framework)
	// Android Studio에서 많이 사용됨
	public Derived() {
		// new Based(10) 와 동일한 코드
		super(10);  // 정수 하나는 줘야 함
	}
	// 상위 클래스에 print()가 있음에도 하위클래스에 다시 만듦
	// Method Overriding
	@Override // Based에 있으므로 Error 발생 안 함
	public void print() {
		System.out.println("Sub Class print out");
	}
	public void method() {
		print();
		// 앞에 아무것도 붙지 않았을 때 자신의 클래스부터 찾아감
		// 자신의 클래스에서 만든 print() 이용
		System.out.println("===================");
		
		super.print();
		// 상위 클래스에서 print()를 찾음
		// Based에 만든 print()
	}
	
	// 메소드
	public void disp() {
		// num = 10;
		// num은 private member라서 not visible error
		// protected 변경 여부 물어봄(Eclipse)
		
		title = "제목";
		content = "내용";
		readcnt = 0;
	}

}
