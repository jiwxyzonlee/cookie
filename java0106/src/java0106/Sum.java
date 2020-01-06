package java0106;

public class Sum {

	public static void main(String[] args) {
		int [] ar = {40, 37, 51, 65, 29};
		// 합계 구하기
		/* int sum = 0;
		for (int data: ar) {
			sum = sum + data;
		}
		System.out.print("합계: "+ sum + "\n" );
		*/
		
		
		// 50이 넘는 데이터의 개수
		/*
		int cnt = 0;
		for(int data : ar) {
			if (data > 50) { cnt = cnt + 1; }
		}
		System.out.print("50이 넘는 데이터 개수: "+ cnt +"\n");
		*/
		
		// 30이 넘는 데이터의 평균을 소수 첫째 자리에서 반올림
		int cnt = 0;
		int sum = 0;
		for (int data : ar) {
			if (data > 30) {
				cnt = cnt + 1;
				sum = sum + data;
			}
		}
		if (cnt == 0) {
			System.out.print("조건을 만족하는 데이터 없음");
		}else {
			Double avg = (double)sum/cnt;
			int result = (int)(avg + 0.5);
			System.out.print("평균 : " + result);
		}

	}
 
}
