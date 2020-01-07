package java0107;

public class SelectionSort {

	public static void main(String[] args) {
		int [] ar = {20, 30, 40, 50, 10};
		// 선택 정렬은 첫번째부터 마지막 바로 앞 데이터까지
		// 자신의 뒤에 있는 모든 위치의 데이터와 비교해서 정렬
		// 오름차순이면 뒤의 데이터가 작을 때 swap
		// 내림차순이면 뒤이 데이터가 작을 때 swap
		
		int len = ar.length;
		
		// 첫번째부터 마지막 바로 앞 자리까지
		for ( int i = 0; i < len - 1 ; i = i + 1){
			// 비교위치 반복문
		    for (int j = i + 1; j < len; j = j + 1){
		    	// 기준점 데이터가 크면 swap
		        if ( ar[i] > ar[j]) {
		        	// swap
		        	int temp = ar[i];
		        	ar[i] = ar[j];
		        	ar[j] = temp;

		        }
		        
		    }
		    
		}
		// 데이터 출력
		for (int temp : ar) {
			System.out.print(temp + "\t");
		}

	}
	
}
