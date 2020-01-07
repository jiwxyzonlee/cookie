package java0107;

public class BubbleSort {

	public static void main(String[] args) {
		int [] ar = {20, 30, 40, 50, 10};
		// 버블 정렬은 최대 n(데이터 개수)-1 회전 동안
		// 자신의 뒤에 있는 모든 위치의 데이터와 비교해서 정렬
		// 오름차순이면 뒤의 데이터가 작을 때 swap
		// 내림차순이면 뒤이 데이터가 작을 때 swap
		
		// 버블 정렬은 가장 큰 데이터가 맨 뒤로 이동하므로
		// 하나의 회전이 끝나면 맨 마지막 데이터와는 비교 불필요
		// 1회전 동안 데이터의 이동이 없으면 정렬 종료
		
		int len = ar.length;
		
		// 최대 n-1 회전
		for ( int i = 0; i < len - 1 ; i = i + 1){
			// 1회전 동안의 데이터 이동 여부를 관찰하기 위한 boolean변수
			boolean flag = false;
			
			// 자신과 인접한 데이터와 비교하기 위한 제어문
		    for (int j = 0; j < len-i-1; j = j + 1){
		    	// 뒤의 데이터가 더 작으면 swap
		        if ( ar[j] > ar[j+1]) {
		        	// swap
		        	int temp = ar[j];
		        	ar[j] = ar[j+1];
		        	ar[j+1] = temp;
		        	//데이터 이동 여부 표시
		        	flag = true;

		        }
		        
		    }
		    // 데이터의 이동이 없으면 정렬 종료
		    if (flag == false) {
		    	break;
		    }
		    
		}
		// 데이터 출력
		for (int temp : ar) {
			System.out.print(temp + "\t");
		}

	}
	
}