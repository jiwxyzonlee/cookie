package method;

public class Main {
	
	// 재귀를 이용하지 않고 n번째 피보나치 수열의 값을 리턴하는 메소드
	public static int fibo1(int n) {
		// 첫번째나 두번째는 무조건 1
		if (n ==1 || n ==2) {
			return 1;
		}
		// 세번째부터는 이전 2개 항의 합
		else {
			int result = -1;
			// 현재 계산할 항의 이전 두번째 항의 값을 저장할 변수
			int f2 = 1;
			// 현재 계산할 항의 이전 첫번째 항의 값을 저장할 변수
			int f1 = 1;
			for (int i = 3; i <= n; i = i + 1) {
				// 이전 2개 항의 합을 계산하고 다음 항으로 이동
				result = f2 + f1;
				f2 = f1;
				f1 = result;
			}
			return result;
		}
		
	}
	
	//재귀를 이용해서 피보나치 수열의 값을 찾아주는 메소드
	public static int fibo2(int n) {
		if (n == 1 || n == 2) {
			return 1;
		}else {
			//fibo2 메소드 내에서 fibo2를 호출하기 때문에 재귀
			return fibo2(n-1) + fibo2(n-2);
		}
	}
 
	public static void main(String[] args) {
		// Student 클래스의 인스턴스 생성
		Student student = new Student();
		// 인스턴스 변수에 값을 설정
		student.setNum(1);
		student.setName("park");
		student.setMajor("CS");
		
		// 인스턴스 변수의 값 가져오기
		System.out.println("번호 : " + student.getNum());
		System.out.println("이름 : " + student.getName());
		System.out.println("전공 : " + student.getMajor());
		
		// 현재 클래스 내부에 있는 메소드를 호출할 때는 이름만 기재
		int r = fibo1(10);
		System.out.println("r : " + r);
		
		r = fibo2(10);
		System.out.println("r : " + r);
	}

}
