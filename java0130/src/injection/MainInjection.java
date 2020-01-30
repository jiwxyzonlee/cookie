package injection;

public class MainInjection {

	public static void main(String[] args) {
		Injection injection = new Injection("JavaScript");
		// 다른 메소드를 호출
		
		
		// 다른 메소드를 호출
		injection.setDiff2("Spring");
		injection.disp();
		// 사용하기 직전에 쓰면 메모리는 절약이 되나 느림
		
		// setDiff2를 호출하지 않았기 때문에  diff2가 null인 상태에서 toUpperCase를 호출해서 예외
		// Exception in thread "main" java.lang.NullPointerException
		injection = new Injection("FrontEnd");
		injection.disp();
		

	}

}
