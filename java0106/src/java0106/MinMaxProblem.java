package java0106;

public class MinMaxProblem {

	public static void main(String[] args) {
		int []ar = {30, 47, 51, 27, 38};
		// 위 배열에서 최댓값 구하기
		
		//int max = 0;
		// 만약 값들이 음수일 경우 0이 최댓값이 돼서 안됨
		// 0번째 데이터로 초기화하는 이유
		
		int max = ar[0];
		
		for (int data : ar) {
			if (max < data) {
				max = data;
			}
		}
		System.out.print("최댓값 : " + max +"\n");
		
		// 위의 데이터 배열에서 40과 가장 가까운 수 찾기
		// 40과 차가 최소인 데이터 찾기 
		// 차이는 음수가 나올 수 없으므로
		// 음수가 나오면 -1을 곱해서 양수로 만들기
		int chaMin = ar[0] -40;
		if (chaMin < 0) {
			chaMin = chaMin * -1;
		}
		// 차이가 가장 작은 데이터의 위치를 저장할 변수
		int first = ar[0];
		
		// 데이터 순회
		for(int data : ar) {
			// 40과의 차 계산하기
			int cha = data - 40;
			if (cha <0) {
				cha = cha * -1;
			}
			// 차이가 최소인 데이터 찾기
			if (chaMin > cha) {
				// 차이의 최소를  chaMin에 저장
				chaMin = cha;
				// 차이가 최소인 데이터를 first에 저장
				first = data;
			}
		}
		System.out.print("40과 가장 가까운 수: " + first +"\n");
		System.out.println("40c과의 차: " + chaMin);
		/* 두 점 사이의 거리 계산
		 * (x1, y1), (x2, y2)
		 * 유클리디안 거리: (x1-x2)**2 + (y1-y2)**2
		 * 맨하탄 거리: (x1-x2)절대값 + (y1-y2)절대값
		 */
		
			
	}

}

 