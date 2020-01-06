package java0102;

public class DataType_2 {

	public static void main(String[] args) {
		double r = 10 / 4;
		System.out.println("r : " + r );
		// 정수 / 정수  = 정수, 결과  2.0
		r = (double)10 / 4;
		System.out.println("r: " + r);
		// 실수 / 정수 = 실수 로 return
		
		// 실수 / 실수 = 결과를 정수로 저장하고자 -> 결과 int 변환
		int result = (int)(10.3 / 5.2);
		System.out.println("result: " + result);
		
		double d = 18.75;
		// d를 소수 첫째 자리에서 반올림해서 정수로 변환
		// int n = (int) Math.round(d);
		int n = (int)(d + 0.5);
		System.out.println("n: " + n);
		
		// 일의 자리에서 반올림
		n = (int)(d*0.1 + 0.5) * 10;
		System.out.println("n: " + n);
		
	}

}

