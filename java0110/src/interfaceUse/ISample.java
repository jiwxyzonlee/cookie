package interfaceUse;

public interface ISample {
	// final이 없어도 final : 변경 못함
	public String TODAT = "2020-01-10";
	
	// abstract 없어도 abstract
	// : 내용 만들면 안되고 ISample을 implement한 곳에서는 반드시  Overriding
	public void disp();
	
	/*public void print() {
		// error 
	}*/
	
	default void print() {
		// 이건 괜찮음
		// 인터페이스에서 내용을 갖는 메소드를 만들고자 할 때
		// 접근지정자로 default 사용
	}

}
