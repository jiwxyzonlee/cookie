package method;

public class Main {

	public static void main(String[] args) {
		// 일정한 패턴을 갖는 연속된 문장 -> 반복문 변경
		/*System.out.println("Hello Java");
		System.out.println("Hello Java");
		System.out.println("Hello Java");*/
		
		// MethodClass의 인스턴스 생성
		MethodClass obj = new MethodClass();
		
		// 메소드 호출
		// 수행할 내용을 변경하고자 하면 메소드의 내용만 변경하면됨 
		obj.disp();
		
		System.out.println("Hello Python");
		
		// 메소드 호출
		obj.disp();
		
		// 매개변수가 있는 메소드 호출
		obj.disp(2);
		obj.disp(2);
		
		int x = 100;
		int [] br = { 100, 200, 300};
		obj.inc(x);
		// x의 값은 직접 호출해서 변경하지 않는 한 절대로 변경되지 않음
		System.out.println("x: " + x);
		
		obj.dec(br);
		// 참조형의 경우 메소드의 매개변수로 대입되면 데이터가 변경될 수도 있음
		System.out.println("br[0] : " + br[0]);
		
		obj.sum(10,30);
		obj.sum(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		
		obj.addDisplay(100, 200); // 더하기, 빼기 못하고 결과 보는 것만
		
		// return이 있는 메소드
		int r = obj.addReturn(200, 300);
		// 값이 출력되지 않아서 프린트 메소드 사용해야 함
		System.out.println("결과 : " + r);
		// 이전 작업 결과가 r에 저장되어 있기 때문에 다음 작업에 이어갈 수 있음
		r = obj.addReturn(r, 700);
		
		// 한번에 여러 개 호출 가능
		// return 값이 있는 메소드는 다른 메소드의 매개변수가 될 수 있음
		r = obj.addReturn(300, obj.addReturn(300, 700));
		System.out.println("결과 : " + r);
	}

}
